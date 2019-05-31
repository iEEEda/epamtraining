package kz.eduard.exceptiontask.main;

import kz.eduard.exceptiontask.action.NumbersActions;
import kz.eduard.exceptiontask.action.ReadFile;
import kz.eduard.exceptiontask.action.TextToNumbers;
import kz.eduard.exceptiontask.exception.FileException;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String path = "C:\\Users\\Админ\\IdeaProjects\\ExceptionTask\\src\\kz\\eduard\\exceptiontask\\file\\file.txt";
        try {
            ReadFile readFile = new ReadFile(path);
            String text = readFile.getText();
            List<Double> numbers = TextToNumbers.convertTextToNumbers(text);
            double average = NumbersActions.getAverage(numbers);
            double sum = NumbersActions.getSum(numbers);
            System.out.println("Average = " + average);
            System.out.println("Sum = " + sum);
        } catch(FileException ex) {
            ex.printStackTrace();
        }
    }
}
