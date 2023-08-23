package DataStore.impl;

import DataObjects.BookingDetails;

import java.util.List;

public interface BookDataStore {
    void addBookingToDataBase(BookingDetails bookingDetails);
    void cancelBookingFromDataBase(BookingDetails bookingDetails);
    List<String> listBooking(String key);
}
