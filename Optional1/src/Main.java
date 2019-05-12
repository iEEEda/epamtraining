import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //task 1:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свое имя: ");
        String name = scanner.nextLine();
        System.out.println("Здравствуйте, " + name);
        // task 3:
        int number;
        Random random = new Random();
        do {
            System.out.println("Введите положительное число: ");
            number = scanner.nextInt();
        } while(number <= 0);
        int[] numbers = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = random.nextInt();
        }
        for (int i = 0; i < number; i++) {
            System.out.println(numbers[i]);
        }
        System.out.print("[ ");
        for (int i = 0; i < number; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("]");
    }
}
