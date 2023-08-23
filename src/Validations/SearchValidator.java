package Validations;

import DataObjects.SearchDetails;

public class SearchValidator extends AbstractValidator<SearchDetails> {
    @Override
    public void validate(SearchDetails req) throws Exception {
        checkIfBuildingAndFloorExist(req.getBuildingName(), req.getFloorName());
        validateSlot(req.getSlot());
    }
}
