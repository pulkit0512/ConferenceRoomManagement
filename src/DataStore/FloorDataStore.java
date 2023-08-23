package DataStore;

import DataObjects.FloorDetails;

public interface FloorDataStore {
    void addFloor(FloorDetails floorDetails);
    void updateFloor(FloorDetails floorDetails);
    FloorDetails getFloor(String floorId);
}
