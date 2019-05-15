import java.util.Scanner;
import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Введите положительное количество чисел: ");
            size = scanner.nextInt();
        } while (size <= 0);
        int numbers[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите любое число: ");
            numbers[i] = scanner.nextInt();
        }
        //task 4:
        minimumDifferentNumbers(numbers);
        //task 5:
        allDifferentNumbers(numbers);
    }

    static void minimumDifferentNumbers(int[] numbers){
        int min = 0;
        int result = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            String number = Integer.toString(numbers[i]);
            if(number.length() == 1) {
                result = numbers[i];
                break;
            } else {
                int[] occurrences = new int[10];
                for (int j = 0; j < number.length(); j++) {
                    occurrences[Integer.parseInt(String.valueOf(number.charAt(j)))]++;
                }
                int sum = 0;
                for (int j = 0; j < 10; j++) {
                    sum = occurrences[j] != 0 ? sum + 1 : sum;
                }
                if(min == 0 || sum < min){
                    min = sum;
                    result = numbers[i];
                }
            }
        }
        System.out.println("Число с минимальным количеством различных цифр: " + result);
    }

    static void allDifferentNumbers(int[] numbers){
        int i = 0;
        boolean found = false;
        while (i < numbers.length && !found) {
            String number = Integer.toString(numbers[i]);
            if (number.length() == 1) {
                System.out.println("Число, состоящее из разных цифр: " + numbers[i]);
                found = true;
            } else {
                int[] occurrences = new int[10];
                for (int j = 0; j < number.length(); j++) {
                    occurrences[Integer.parseInt(String.valueOf(number.charAt(j)))]++;
                }
                found = true;
                for (int j = 0; j < 10; j++) {
                    if(occurrences[j] > 1){
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Число, состоящее из разных цифр: " + numbers[i]);
                }
            }
            i++;
        }
        if (!found){
            System.out.println("Нет числа, состоящего из разных цифр");
        }
    }
}
