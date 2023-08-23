package Validations;

import DataObjects.AddDataObject;

public class FloorValidator extends AbstractValidator<AddDataObject> {
    @Override
    public void validate(AddDataObject req) throws Exception {
        boolean isBuildingPresent = checkIfBuildingAlreadyExist(req.getBuildingName());
        if (!isBuildingPresent) {
            throw new Exception(req.getBuildingName() + " Building does not exist in Database");
        }

        boolean isFloorPresent = checkIfFloorAlreadyExist(req.getBuildingName(), req.getFloorName());
        if (isFloorPresent) {
            throw new Exception(req.getFloorName() + " Floor already exist in Building " + req.getBuildingName());
        }
    }
}
