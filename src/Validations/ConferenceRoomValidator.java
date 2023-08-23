package Validations;

import DataObjects.AddDataObject;

public class ConferenceRoomValidator extends AbstractValidator<AddDataObject> {
    @Override
    public void validate(AddDataObject req) throws Exception {
        checkIfBuildingAndFloorExist(req.getBuildingName(), req.getFloorName());

        boolean isConferenceRoomPresent = checkIfConferenceRoomAlreadyExist(req.getBuildingName(), req.getFloorName(), req.getConferenceRoomName());
        if (isConferenceRoomPresent) {
            throw new Exception(req.getConferenceRoomName() + " ConferenceRoom already present for Floor " + req.getFloorName() + " in Building " + req.getBuildingName());
        }
    }
}
