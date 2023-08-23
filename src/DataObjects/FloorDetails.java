package DataObjects;

import java.util.ArrayList;
import java.util.List;

public class FloorDetails {
    private String buildingName;
    private String floorName;
    private List<ConferenceRoom> conferenceRooms;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<ConferenceRoom> getConferenceRooms() {
        if (conferenceRooms == null) {
            conferenceRooms = new ArrayList<>();
        }
        return conferenceRooms;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
}
