package DataStore.impl;

import DataObjects.ConferenceRoom;
import DataStore.ConferenceRoomDataStore;

import java.util.HashMap;
import java.util.Map;

public class ConferenceRoomDataStoreImpl implements ConferenceRoomDataStore {
    private static final Map<String, ConferenceRoom> conferenceRoomDB = new HashMap<>();
    @Override
    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        conferenceRoomDB.put(conferenceRoom.getConferenceRoomId(), conferenceRoom);
    }

    @Override
    public void updateConferenceRoom(ConferenceRoom conferenceRoom) {
        addConferenceRoom(conferenceRoom);
    }

    @Override
    public ConferenceRoom getConferenceRoom(String conferenceRoomId) {
        return conferenceRoomDB.get(conferenceRoomId);
    }
}
