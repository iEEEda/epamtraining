package kz.eduard.matrix.action;

import kz.eduard.matrix.entity.Cell;
import kz.eduard.matrix.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MatrixInitializer {

    private static final Logger LOGGER = LogManager.getLogger(MatrixInitializer.class);

    public List<Integer> getNumbers(String path) {
        StringBuilder text = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(path);
            int c = fileReader.read();
            while (c != -1) {
                text.append((char) c);
                c = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e);

        } catch (IOException e) {
            LOGGER.error(e);
        }
        List<Integer> numbers = TextToNumbers.convertTextToNumbers(text.toString());
        return numbers;
    }

    public Matrix initializeMatrix(String path){
        List<Integer> numbers = getNumbers(path);
        int size = numbers.get(0);
        Cell cells[][] = new Cell[size][size];
        return Matrix.getInstance(cells, size);
    }

    public int getNumberOfThreads(String path){
        List<Integer> numbers = getNumbers(path);
        return numbers.get(1);
    }
}
