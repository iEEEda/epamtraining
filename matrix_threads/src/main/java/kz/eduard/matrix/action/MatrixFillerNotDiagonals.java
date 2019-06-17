package kz.eduard.matrix.action;

import kz.eduard.matrix.entity.Cell;
import kz.eduard.matrix.entity.Matrix;
import kz.eduard.matrix.exception.MatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MatrixFillerNotDiagonals implements MatrixFiller{

    private static final Logger LOGGER = LogManager.getLogger(MatrixFillerNotDiagonals.class);

    @Override
    public void fillMatrix(Matrix matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                if(i != j) {
                    try {
                        matrix.setEmptyCell(i, j, random.nextInt(98) + 1);
                    } catch (MatrixException ex) {
                        LOGGER.error(ex);
                    }
                } else {
                    try {
                        matrix.setEmptyCell(i, j, 0);
                    } catch (MatrixException ex) {
                        LOGGER.error(ex);
                    }
                }
            }
        }
    }
}
