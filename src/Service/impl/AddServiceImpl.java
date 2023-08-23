package Service.impl;

import DataObjects.AddDataObject;
import DataObjects.BuildingDetails;
import DataObjects.ConferenceRoom;
import DataObjects.FloorDetails;
import DataStore.BuildingDataStore;
import DataStore.ConferenceRoomDataStore;
import DataStore.FloorDataStore;
import DataStore.impl.BuildingDataStoreImpl;
import DataStore.impl.ConferenceRoomDataStoreImpl;
import DataStore.impl.FloorDataStoreImpl;
import Service.AddService;

public class AddServiceImpl implements AddService {
    private static final BuildingDataStore buildingDataStore = new BuildingDataStoreImpl();
    private static final FloorDataStore floorDataStore = new FloorDataStoreImpl();
    private static final ConferenceRoomDataStore conferenceRoomDataStore = new ConferenceRoomDataStoreImpl();

    @Override
    public void addBuilding(AddDataObject addDataObject) {
        BuildingDetails buildingDetails = new BuildingDetails();
        buildingDetails.setBuildingName(addDataObject.getBuildingName());
        buildingDataStore.addBuilding(buildingDetails);
        System.out.println("Added building " + addDataObject.getBuildingName() + " into the system.");
    }

    @Override
    public void addFloor(AddDataObject addDataObject) {
        FloorDetails floorDetails = new FloorDetails();
        floorDetails.setFloorName(addDataObject.getFloorName());
        floorDetails.setBuildingName(addDataObject.getBuildingName());
        floorDataStore.addFloor(floorDetails);

        BuildingDetails buildingDetails = buildingDataStore.getBuilding(addDataObject.getBuildingName());
        buildingDetails.getFloorDetails().add(floorDetails);
        buildingDataStore.updateBuilding(buildingDetails);
        System.out.println("Floor " + addDataObject.getFloorName() + " added successfully to the building " + addDataObject.getBuildingName());
    }

    @Override
    public void addConferenceRoom(AddDataObject addDataObject) {
        String floorId = addDataObject.getBuildingName()+"_"+addDataObject.getFloorName();

        ConferenceRoom conferenceRoom = new ConferenceRoom();
        conferenceRoom.setConferenceRoomId(floorId + "_" + addDataObject.getConferenceRoomName());
        conferenceRoom.setConferenceRoomName(addDataObject.getConferenceRoomName());
        conferenceRoomDataStore.addConferenceRoom(conferenceRoom);

        FloorDetails floorDetails = floorDataStore.getFloor(floorId);
        floorDetails.getConferenceRooms().add(conferenceRoom);
        floorDataStore.updateFloor(floorDetails);
        System.out.println("Conference Room " + addDataObject.getConferenceRoomName() + " added successfully on floor "
                + addDataObject.getFloorName() + " in the building " + addDataObject.getBuildingName());
    }
}
