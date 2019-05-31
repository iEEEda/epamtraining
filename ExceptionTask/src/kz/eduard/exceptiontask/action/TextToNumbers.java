package kz.eduard.exceptiontask.action;

import kz.eduard.exceptiontask.validator.ValidateText;

import java.util.ArrayList;
import java.util.List;

public class TextToNumbers {

    public static List<Double> convertTextToNumbers(String text){
        List<Double> numbers = new ArrayList<Double>();
        String[] textNumbers = text.split("[,:?@%$# \\n]+");

        ValidateText validateText = new ValidateText();

        for (int i = 0; i < textNumbers.length; i++) {
            if(validateText.isValidNumber(textNumbers[i])){
                numbers.add(Double.parseDouble(textNumbers[i]));
            }
        }
        return numbers;
    }

}
