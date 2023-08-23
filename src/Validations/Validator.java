package Validations;

public interface Validator<R>{
    void validate(R req) throws Exception;
}
