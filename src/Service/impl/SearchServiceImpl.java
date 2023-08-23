package Service.impl;

import DataObjects.ConferenceRoom;
import DataObjects.SearchDetails;
import DataStore.FloorDataStore;
import DataStore.impl.FloorDataStoreImpl;
import Service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    private static final FloorDataStore floorDataStore = new FloorDataStoreImpl();
    @Override
    public void searchRooms(SearchDetails searchDetails) {
        String key = searchDetails.getBuildingName()+"_"+searchDetails.getFloorName();
        List<ConferenceRoom> conferenceRooms = floorDataStore.getFloor(key).getConferenceRooms();
        List<String> availableConferenceRooms = new ArrayList<>();

        String[] slot = searchDetails.getSlot().split(":");
        int startTime = Integer.parseInt(slot[0]);
        int endTime = Integer.parseInt(slot[1]);

        for(ConferenceRoom conferenceRoom : conferenceRooms) {
            boolean isRoomAvailable = isBookingPossible(startTime, endTime, conferenceRoom);
            if (isRoomAvailable) {
                availableConferenceRooms.add(conferenceRoom.getConferenceRoomName());
            }
        }
        System.out.println(availableConferenceRooms);
    }

    private boolean isBookingPossible(int startTime, int endTime, ConferenceRoom conferenceRoom) {
        for(int time = startTime; time<=endTime; time++) {
            if(conferenceRoom.getSlotsBooked()[time]) {
                return false;
            }
        }
        return true;
    }
}
