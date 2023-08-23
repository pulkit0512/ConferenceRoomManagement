package DataObjects;

public class ConferenceRoom {
    // Primary Key for this entity
    private String conferenceRoomId;
    private String conferenceRoomName;
    private boolean[] slotsBooked;

    public String getConferenceRoomId() {
        return conferenceRoomId;
    }

    public void setConferenceRoomId(String conferenceRoomId) {
        this.conferenceRoomId = conferenceRoomId;
    }

    public boolean[] getSlotsBooked() {
        if (slotsBooked == null) {
            slotsBooked = new boolean[24];
        }
        return slotsBooked;
    }

    public String getConferenceRoomName() {
        return conferenceRoomName;
    }

    public void setConferenceRoomName(String conferenceRoomName) {
        this.conferenceRoomName = conferenceRoomName;
    }
}
