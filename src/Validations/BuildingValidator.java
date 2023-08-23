package Validations;

import DataObjects.AddDataObject;

public class BuildingValidator extends AbstractValidator<AddDataObject> {
    @Override
    public void validate(AddDataObject req) throws Exception {
        String buildingName = req.getBuildingName();
        boolean isBuildingPresent = checkIfBuildingAlreadyExist(buildingName);
        if (isBuildingPresent) {
            throw new Exception(req.getBuildingName() + " Building already exist in Database");
        }
    }
}
