package Controller;

import DataObjects.AddDataObject;
import DataObjects.BookingDetails;
import DataObjects.SearchDetails;
import Service.AddService;
import Service.BookService;
import Service.SearchService;
import Service.impl.AddServiceImpl;
import Service.impl.BookServiceImpl;
import Service.impl.SearchServiceImpl;
import Validations.*;

import java.util.List;

public class ConferenceRoomController {
    private static final BuildingValidator buildingValidator = new BuildingValidator();
    private static final FloorValidator floorValidator = new FloorValidator();
    private static final ConferenceRoomValidator conferenceRoomValidator = new ConferenceRoomValidator();
    private static final BookValidator bookValidator = new BookValidator();
    private static final AddService addService = new AddServiceImpl();
    private static final BookService bookService = new BookServiceImpl();
    private static final SearchValidator searchValidator = new SearchValidator();
    private static final SearchService searchService = new SearchServiceImpl();
    public void addBuilding(AddDataObject addReq) {
        try {
            buildingValidator.validate(addReq);
            addService.addBuilding(addReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addFloor(AddDataObject addReq) {
        try {
            floorValidator.validate(addReq);
            addService.addFloor(addReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addConferenceRoom(AddDataObject addReq) {
        try {
            conferenceRoomValidator.validate(addReq);
            addService.addConferenceRoom(addReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bookConferenceRoom(BookingDetails bookingDetails) {
        try{
            bookValidator.validate(bookingDetails);
            bookService.bookConferenceRoom(bookingDetails);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelConferenceRoom(BookingDetails bookingDetails) {
        try{
            bookValidator.validate(bookingDetails);
            bookService.cancelConferenceRoom(bookingDetails);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listBookings(BookingDetails bookingDetails) {
        List<String> bookings = bookService.listBookings(bookingDetails);
        for(String booking: bookings) {
            String[] details = booking.split("_");
            System.out.println(details[1] + " " + bookingDetails.getFloorName() + " " + bookingDetails.getBuildingName() + " " + details[0] + " " + details[2]);
        }
    }

    public void searchRooms(SearchDetails searchDetails) {
        try{
            searchValidator.validate(searchDetails);
            searchService.searchRooms(searchDetails);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
