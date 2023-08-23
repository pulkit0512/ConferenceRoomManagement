package Validations;

import DataObjects.BookingDetails;

public class BookValidator extends AbstractValidator<BookingDetails> {
    @Override
    public void validate(BookingDetails req) throws Exception {
        checkIfBuildingAndFloorExist(req.getBuildingName(), req.getFloorName());

        boolean isConferenceRoomPresent = checkIfConferenceRoomAlreadyExist(req.getBuildingName(), req.getFloorName(), req.getConferenceRoomName());
        if (!isConferenceRoomPresent) {
            throw new Exception(req.getConferenceRoomName() + " ConferenceRoom does not exist on Floor " + req.getFloorName() + " in Building " + req.getBuildingName());
        }

        validateSlot(req.getSlot());
    }
}
