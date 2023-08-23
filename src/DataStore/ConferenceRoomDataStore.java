package DataStore;

import DataObjects.ConferenceRoom;

public interface ConferenceRoomDataStore {
    void addConferenceRoom(ConferenceRoom conferenceRoom);
    void updateConferenceRoom(ConferenceRoom conferenceRoom);
    ConferenceRoom getConferenceRoom(String conferenceRoomId);
}
