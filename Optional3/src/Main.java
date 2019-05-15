import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Введите целое число от 1 до 12: ");
            number = scanner.nextInt();
        } while (number < 1 || number > 12);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        System.out.println(months[number - 1]);
    }
}
