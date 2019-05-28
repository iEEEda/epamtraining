package kz.eduard.palmetto.validator;

public class NameValidator {
    private static final byte MIN_LENGTH_NAME = 4;
    private static final byte MAX_LENGTH_NAME = 20;
    private static final byte ASCII_OF_UPPER_A = 65;
    private static final byte ASCII_OF_UPPER_Z = 90;
    private static final byte ASCII_OF_LOWER_A = 97;
    private static final byte ASCII_OF_LOWER_Z = 122;

    public boolean validateName(String name){
        if(name.length() <= MAX_LENGTH_NAME && name.length() >= MIN_LENGTH_NAME) {
            char[] nameCharArray = name.toCharArray();
            for (int i = 0; i < nameCharArray.length; i++) {
                char charOfName = nameCharArray[i];
                boolean lessThanUpperA = charOfName < ASCII_OF_UPPER_A;
                boolean betweenUpperZAndLowerA = charOfName > ASCII_OF_UPPER_Z && charOfName < ASCII_OF_LOWER_A;
                boolean biggerThanLowerZ = charOfName > ASCII_OF_LOWER_Z;
                if(lessThanUpperA || betweenUpperZAndLowerA || biggerThanLowerZ){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
