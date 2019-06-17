package kz.eduard.matrix.action;

import kz.eduard.matrix.validator.ValidateText;

import java.util.ArrayList;
import java.util.List;

public class TextToNumbers {

    public static List<Integer> convertTextToNumbers(String text){
        List<Integer> numbers = new ArrayList<Integer>();
        String[] textNumbers = text.split("[,:?@%$# \\n]+");

        ValidateText validateText = new ValidateText();

        for (int i = 0; i < textNumbers.length; i++) {
            if(validateText.isValidNumber(textNumbers[i])){
                numbers.add(Integer.parseInt(textNumbers[i]));
            }
        }
        return numbers;
    }

}
