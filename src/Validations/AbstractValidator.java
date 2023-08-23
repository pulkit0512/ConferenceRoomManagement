package Validations;

import DataStore.BuildingDataStore;
import DataStore.ConferenceRoomDataStore;
import DataStore.FloorDataStore;
import DataStore.impl.BuildingDataStoreImpl;
import DataStore.impl.ConferenceRoomDataStoreImpl;
import DataStore.impl.FloorDataStoreImpl;

public abstract class AbstractValidator<R> implements Validator<R> {
    private static final BuildingDataStore buildingDataStore = new BuildingDataStoreImpl();
    private static final FloorDataStore floorDataStore = new FloorDataStoreImpl();
    private static final ConferenceRoomDataStore conferenceRoomDataStore = new ConferenceRoomDataStoreImpl();

    protected boolean checkIfBuildingAlreadyExist(String building) {
        return buildingDataStore.getBuilding(building) != null;
    }

    protected boolean checkIfFloorAlreadyExist(String building, String floor) {
        return floorDataStore.getFloor(building+"_"+floor) != null;
    }

    protected void checkIfBuildingAndFloorExist(String building, String floor) throws Exception {
        boolean isBuildingPresent = checkIfBuildingAlreadyExist(building);
        if (!isBuildingPresent) {
            throw new Exception(building + " Building does not exist in Database");
        }

        boolean isFloorPresent = checkIfFloorAlreadyExist(building, floor);
        if (!isFloorPresent) {
            throw new Exception(floor + " Floor does not exist in Building " + building);
        }
    }

    protected void validateSlot(String slotInput) throws Exception {
        String[] slot = slotInput.split(":");
        if(slot.length != 2) {
            throw new Exception("Slot information not valid. Expected Format startTime:endTime");
        }
        int startTime, endTime;
        try {
            startTime = Integer.parseInt(slot[0]);
            endTime = Integer.parseInt(slot[1]);

            if(startTime >= endTime) {
                throw new Exception("Slot information not valid. startTime<endTime");
            }
            if(startTime < 0 || endTime>=24) {
                throw new Exception("Slot information not valid. startTime and endTime should be in range [0,23]");
            }
        } catch (Exception e) {
            throw new Exception("Slot information not valid.");
        }
    }

    protected boolean checkIfConferenceRoomAlreadyExist(String building, String floor, String conferenceRoom) {
        return conferenceRoomDataStore.getConferenceRoom(building+"_"+floor+"_"+conferenceRoom) != null;
    }
}
