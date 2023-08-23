package DataStore;

import DataObjects.BuildingDetails;

public interface BuildingDataStore {
    void addBuilding(BuildingDetails buildingDetails);
    void updateBuilding(BuildingDetails buildingDetails);
    BuildingDetails getBuilding(String buildingName);
}
