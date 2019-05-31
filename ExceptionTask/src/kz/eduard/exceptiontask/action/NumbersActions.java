package kz.eduard.exceptiontask.action;

import java.util.List;

public class NumbersActions {
    public static double getSum(List<Double> numbers){
        double sum = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    public static double getAverage(List<Double> numbers){
        return getSum(numbers) / numbers.size();
    }
}
