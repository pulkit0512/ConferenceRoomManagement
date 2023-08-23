package Service;

import DataObjects.BookingDetails;

import java.util.List;

public interface BookService {
    void bookConferenceRoom(BookingDetails bookingDetails);
    void cancelConferenceRoom(BookingDetails bookingDetails);
    List<String> listBookings(BookingDetails bookingDetails);
}
