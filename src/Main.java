import Controller.ConferenceRoomController;
import DataObjects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final File FILE = new File("/Users/pulkitarora/learning/ConferenceRoom/input.txt");
    private static final ConferenceRoomController controller = new ConferenceRoomController();
    private static final Scanner sc;

    static {
        try {
            sc = new Scanner(FILE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Conference Room Management!");
        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            if (input.length < 2) {
                System.out.println("NOT A VALID COMMAND.");
                continue;
            }
            String action = input[0];
            if (action.equalsIgnoreCase("ADD")) {
                String objectType = input[1];
                if (objectType.equalsIgnoreCase(ObjectType.BUILDING.toString())) {
                    addBuilding(input);
                } else if (objectType.equalsIgnoreCase(ObjectType.FLOOR.toString())) {
                    addFloor(input);
                } else if (objectType.equalsIgnoreCase(ObjectType.CONFROOM.toString())) {
                    addConfRoom(input);
                } else {
                    System.out.println("Not a Valid ADD Command. You can only ADD BUILDING/FLOOR/CONFROOM");
                }
            } else if(action.equalsIgnoreCase("BOOK")) {
                bookConferenceRoom(input);
            } else if(action.equalsIgnoreCase("CANCEL")) {
                cancelConferenceRoom(input);
            } else if(action.equalsIgnoreCase("LIST")) {
                listBookings(input);
            } else if(action.equalsIgnoreCase("SEARCH")) {
                searchRooms(input);
            } else {
                System.out.println("Not a valid Command");
            }
        }
    }

    private static void addBuilding(String[] input) {
        if (input.length != 3) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: ADD BUILDING BUILDING_NAME");
            return;
        }
        AddDataObject addDataObject = new AddDataObject();
        addDataObject.setBuildingName(input[2].toUpperCase());
        controller.addBuilding(addDataObject);
    }

    private static void addFloor(String[] input) {
        if (input.length != 4) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: ADD FLOOR BUILDING_NAME FLOOR_NAME");
            return;
        }
        AddDataObject addDataObject = new AddDataObject();
        addDataObject.setBuildingName(input[2].toUpperCase());
        addDataObject.setFloorName(input[3].toUpperCase());
        controller.addFloor(addDataObject);
    }

    private static void addConfRoom(String[] input) {
        if (input.length != 5) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: ADD CONFROOM BUILDING_NAME FLOOR_NAME CONFERENCE_ROOM_NAME");
            return;
        }
        AddDataObject addDataObject = new AddDataObject();
        addDataObject.setBuildingName(input[2].toUpperCase());
        addDataObject.setFloorName(input[3].toUpperCase());
        addDataObject.setConferenceRoomName(input[4].toUpperCase());
        controller.addConferenceRoom(addDataObject);
    }

    private static void bookConferenceRoom(String[] input) {
        if (input.length != 5) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: BOOK SLOT BUILDING_NAME FLOOR_NAME CONFERENCE_ROOM_NAME");
            return;
        }
        BookingDetails bookingDetails = getBookingDetails(input);
        controller.bookConferenceRoom(bookingDetails);
    }

    private static void cancelConferenceRoom(String[] input) {
        if (input.length != 5) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: CANCEL SLOT BUILDING_NAME FLOOR_NAME CONFERENCE_ROOM_NAME");
            return;
        }
        BookingDetails bookingDetails = getBookingDetails(input);
        controller.cancelConferenceRoom(bookingDetails);
    }

    private static void listBookings(String[] input) {
        if (input.length != 4) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: LIST BOOKING BUILDING_NAME FLOOR_NAME");
            return;
        }

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setBuildingName(input[2].toUpperCase());
        bookingDetails.setFloorName(input[3].toUpperCase());

        controller.listBookings(bookingDetails);
    }

    private static void searchRooms(String[] input) {
        if (input.length != 4) {
            System.out.println("NOT A VALID COMMAND. SUPPORTED COMMAND: SEARCH SLOT BUILDING_NAME FLOOR_NAME");
            return;
        }
        SearchDetails searchDetails = new SearchDetails();
        searchDetails.setSlot(input[1].toUpperCase());
        searchDetails.setBuildingName(input[2].toUpperCase());
        searchDetails.setFloorName(input[3].toUpperCase());
        controller.searchRooms(searchDetails);
    }

    private static BookingDetails getBookingDetails(String[] input) {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setSlot(input[1].toUpperCase());
        bookingDetails.setBuildingName(input[2].toUpperCase());
        bookingDetails.setFloorName(input[3].toUpperCase());
        bookingDetails.setConferenceRoomName(input[4].toUpperCase());
        return bookingDetails;
    }

}