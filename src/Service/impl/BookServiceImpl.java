package Service.impl;

import DataObjects.BookingDetails;
import DataObjects.BookingStatus;
import DataObjects.ConferenceRoom;
import DataStore.ConferenceRoomDataStore;
import DataStore.impl.BookDataStore;
import DataStore.impl.BookDataStoreImpl;
import DataStore.impl.ConferenceRoomDataStoreImpl;
import Service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private static final ConferenceRoomDataStore conferenceRoomDataStore = new ConferenceRoomDataStoreImpl();
    private static final BookDataStore bookDataStore = new BookDataStoreImpl();
    @Override
    public void bookConferenceRoom(BookingDetails bookingDetails) {
        String key = bookingDetails.getBuildingName()+"_"+bookingDetails.getFloorName()+"_"+bookingDetails.getConferenceRoomName();
        ConferenceRoom conferenceRoom = conferenceRoomDataStore.getConferenceRoom(key);
        String[] slot = bookingDetails.getSlot().split(":");
        int startTime = Integer.parseInt(slot[0]);
        int endTime = Integer.parseInt(slot[1]);

        boolean bookingPossible = isBookingPossible(startTime, endTime, conferenceRoom);

        if(bookingPossible) {
            updateConferenceRoom(startTime, endTime, conferenceRoom, true);

            bookingDetails.setBookingStatus(BookingStatus.BOOKED);
            bookDataStore.addBookingToDataBase(bookingDetails);
            System.out.println("Booking Successful.");
        } else {
            System.out.println("Booking slot not available");
        }
    }

    private boolean isBookingPossible(int startTime, int endTime, ConferenceRoom conferenceRoom) {
        for(int time = startTime; time<=endTime; time++) {
            if(conferenceRoom.getSlotsBooked()[time]) {
                return false;
            }
        }
        return true;
    }

    private void updateConferenceRoom(int startTime, int endTime, ConferenceRoom conferenceRoom, boolean value) {
        for(int time = startTime; time<=endTime; time++) {
            conferenceRoom.getSlotsBooked()[time] = value;
        }
        conferenceRoomDataStore.updateConferenceRoom(conferenceRoom);
    }

    @Override
    public void cancelConferenceRoom(BookingDetails bookingDetails) {
        String key = bookingDetails.getBuildingName()+"_"+bookingDetails.getFloorName()+"_"+bookingDetails.getConferenceRoomName();
        ConferenceRoom conferenceRoom = conferenceRoomDataStore.getConferenceRoom(key);
        String[] slot = bookingDetails.getSlot().split(":");
        int endTime = Integer.parseInt(slot[1]);
        int startTime = Integer.parseInt(slot[0]);

        boolean bookingPresent = isBookingPresent(startTime, endTime, conferenceRoom);

        if(bookingPresent) {
            updateConferenceRoom(startTime, endTime, conferenceRoom, false);

            bookingDetails.setBookingStatus(BookingStatus.CANCELED);
            bookDataStore.cancelBookingFromDataBase(bookingDetails);
            System.out.println("Booking cancelled");
        } else {
            System.out.println("No Booking exist for this slot");
        }
    }

    @Override
    public List<String> listBookings(BookingDetails bookingDetails) {
        return bookDataStore.listBooking(bookingDetails.getBuildingName()+"_"+bookingDetails.getFloorName());
    }

    private boolean isBookingPresent(int startTime, int endTime, ConferenceRoom conferenceRoom) {
        for(int time = startTime; time<=endTime; time++) {
            if(!conferenceRoom.getSlotsBooked()[time]) {
                return false;
            }
        }
        return true;
    }
}
