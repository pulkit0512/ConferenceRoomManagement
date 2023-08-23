package DataStore.impl;

import DataObjects.BookingDetails;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookDataStoreImpl implements BookDataStore{
    private static final Map<String, List<String>> bookDB = new LinkedHashMap<>();
    @Override
    public void addBookingToDataBase(BookingDetails bookingDetails) {
        String key = bookingDetails.getBuildingName()+"_"+bookingDetails.getFloorName();
        String value = bookingDetails.getConferenceRoomName()+"_"+bookingDetails.getSlot()+"_"+bookingDetails.getBookingStatus().toString();

        List<String> values = bookDB.getOrDefault(key, new ArrayList<>());
        values.add(value);
        bookDB.put(key, values);
    }

    @Override
    public void cancelBookingFromDataBase(BookingDetails bookingDetails) {
        addBookingToDataBase(bookingDetails);
    }

    @Override
    public List<String> listBooking(String key) {
        return bookDB.getOrDefault(key, new ArrayList<>());
    }
}
