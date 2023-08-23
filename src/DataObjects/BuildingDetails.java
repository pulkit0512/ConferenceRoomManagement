package DataObjects;

import java.util.ArrayList;
import java.util.List;

public class BuildingDetails {
    // Primary key for this entity
    private String buildingName;

    private List<FloorDetails> floorDetails;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<FloorDetails> getFloorDetails() {
        if (floorDetails == null) {
            floorDetails = new ArrayList<>();
        }
        return floorDetails;
    }
}
