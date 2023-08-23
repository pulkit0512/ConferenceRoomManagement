package DataStore.impl;

import DataObjects.BuildingDetails;
import DataStore.BuildingDataStore;

import java.util.HashMap;
import java.util.Map;

public class BuildingDataStoreImpl implements BuildingDataStore {
    private static final Map<String, BuildingDetails> buildingDB = new HashMap<>();
    @Override
    public void addBuilding(BuildingDetails buildingDetails) {
        buildingDB.put(buildingDetails.getBuildingName(), buildingDetails);
    }

    @Override
    public void updateBuilding(BuildingDetails buildingDetails) {
        addBuilding(buildingDetails);
    }

    @Override
    public BuildingDetails getBuilding(String buildingName) {
        return buildingDB.get(buildingName);
    }
}
