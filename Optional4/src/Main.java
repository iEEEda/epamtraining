import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int size;
        do {
            System.out.println("Введите положительное число: ");
            size = scanner.nextInt();
        } while (size < 0);
        int[][] matrix = new int[size][size];
        int range;
        do {
            System.out.println("Укажите границу чисел в матрице: ");
            range = scanner.nextInt();
        } while (range < 0);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(2*range) - range;
            }
        }
        System.out.println("Изначальная матрица: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //task 4:
        int[][] newMatrix = new int[size - 1][size - 1];
        int row = 0;
        int column = 0;
        int max = matrix[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        System.out.println("Самое большое число: " + max);
        System.out.println("Его координаты: " + row + ", " + column);
        for (int i = 0, ni = 0; i < size && ni < size - 1; i++, ni++) {
            if(i == row && row != size - 1){
                i++;
            } else if (i == row && row == size - 1){
                continue;
            }
            for (int j = 0, nj = 0; j < size && nj < size - 1; j++, nj++) {
                if(j == column && column != size - 1){
                    j++;
                } else if (j == column && column == size - 1){
                    continue;
                }
                newMatrix[ni][nj] = matrix[i][j];
            }
        }
        System.out.println("Измененная матрица: ");
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
