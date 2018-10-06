package utils;

public class ValidatorStringLength {

    public String Validate(String argData) {
        if (argData.length() < 200) return argData;
        return argData.substring(0, 200);
    }

}