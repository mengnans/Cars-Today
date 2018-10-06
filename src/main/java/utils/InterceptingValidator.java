package utils;

public class InterceptingValidator {

    public static String ValidatePassword(String argPassword) {
        argPassword = new ValidatorSql().Validate(argPassword);
        argPassword = new ValidatorStringLength().Validate(argPassword);
        return argPassword;
    }

}