package utils;

public class ValidatorSql {

    public String Validate(String argData) {
        argData = argData.replace('\'', ' ');
        argData = argData.replace('\"', ' ');
        argData = argData.replace(';', ' ');
        return argData;
    }

}