package kz.eduard.matrix.testing;

import kz.eduard.matrix.action.*;
import kz.eduard.matrix.entity.MatrixThread;
import kz.eduard.matrix.entity.Matrix;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final String PATH = "C:\\Users\\Админ\\IdeaProjects\\matrix_threads\\src\\main\\java\\kz\\eduard\\matrix\\file\\file.txt";
        MatrixInitializer initializer = new MatrixInitializer();
        Matrix matrix = initializer.initializeMatrix(PATH);
        MatrixFiller filler = new MatrixFillerNotDiagonals();
        filler.fillMatrix(matrix);

        int numberOfThreads = initializer.getNumberOfThreads(PATH);
        List<MatrixThread> threads = new ArrayList<MatrixThread>();
        for (int i = 1; i <= numberOfThreads ; i++) {
            threads.add(new MatrixThread(i));
        }
        for (MatrixThread thread : threads) {
            thread.start();
        }
    }
}
