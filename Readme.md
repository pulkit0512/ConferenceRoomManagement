# Question:
One of the core problems which people face at every company is the unavailability of conference rooms. 
So we thought of building one conference room management system. The system should have the following features.
## Assumptions:
1) Conference rooms are scattered across multiple buildings and multiple floors and each floor can have multiple conference rooms, but each conference room should be uniquely identifiable. 
2) Booking will be done for slots in hours. Hours will be taken in 24 hours format eg. Book from 1am to 3am {1:3}, from 12pm to 1pm {12:13} 
3) Each conference room can be booked given that no one has already booked for that slot. 
4) System will be used only by one user only. 
5) Booking can be done for 1 day only.

## Features:
1) Users should be able to list down all the conference rooms available in any building. Eg:Alpha building has conference rooms with names: a1, a2, a3, a4 etc. 
2) User should be able to find suitable rooms to book for a given slot. 
3) User should be able to cancel existing booking and rooms should be free to be booked again for that slot.
4) List down all the bookings made by the current user.
5) Command which will be executed to perform the above actions is listed below.
   *Note* All the input params given below are for demonstration purposes only, user can create his/her own building name and floor name, and conference rooms.
   
###Commands:
ADD BUILDING <building_name> //Adds building in the system
   
Eg: ADD BUILDING flipkart1

Output: Added building flipkart1 into the system.

ADD FLOOR <buildingName> <floorName>

Eg. ADD FLOOR FLIPKART1 FirstFloor

ADD CONFROOM <buildingName> <floorName> <conferenceRoomID>

Eg: ADD CONFROOM flipkart1 firstfloor c1

The above commands adds c1 conference room in firstfloor of building flipkart1

Output: Added conference room c1 on firstfloor in flipkart1

BOOK <SLOT> <BUILDING> <FLOOR>

Books the given Conference room for a given slot, on the given floor of the building.

Eg: BOOK 1:5 FLIPKART1 SEVENTH C1

CANCEL <SLOT> <BUILDING> <FLOOR> <ROOM ID>

Cancels the slot booked for the floor in a given building.

LIST BOOKING <BUILDING> <FLOOR>

Should list down all the bookings made by current user

Output format: <SLOT> <FLOOR> <BUILDING> <roomName>

2:6 THIRDFLOOR FLIPKART1 c1

6:10 THIRDFLOOR FLIPKART1 c2

SEARCH <SlotName> <BuildingName> <FloorName>

Search should return possible available rooms for given parameters.

SEARCH 2:3 flipkart3 seventhFloor -> Search conf rooms available for booking from 2->3 in flipkart3 building and seventhFloor floor

If no room is available for booking for given slot, search will return “No Rooms available”

## Bonus Functionality:
Existing search will return empty results if no rooms are available for a given slot. 
Users want a suggestion functionality using which users can get a list of possible future slots [Size limit to 3] which can be booked.

Eg. Assume no room is available for a slot then the search will return an empty result while SUGGEST command will return the next 3 suggestions.

Command: SUGGEST 3:10