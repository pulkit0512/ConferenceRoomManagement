package DataStore.impl;

import DataObjects.FloorDetails;
import DataStore.FloorDataStore;

import java.util.HashMap;
import java.util.Map;

public class FloorDataStoreImpl implements FloorDataStore {
    private static final Map<String, FloorDetails> floorDB = new HashMap<>();
    @Override
    public void addFloor(FloorDetails floorDetails) {
        String key = floorDetails.getBuildingName() + "_" + floorDetails.getFloorName();
        floorDB.put(key, floorDetails);
    }

    @Override
    public void updateFloor(FloorDetails floorDetails) {
        addFloor(floorDetails);
    }

    @Override
    public FloorDetails getFloor(String floorId) {
        return floorDB.get(floorId);
    }
}
