package kz.eduard.matrix.entity;

import kz.eduard.matrix.action.ThreadCount;
import kz.eduard.matrix.exception.MatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class MatrixThread extends Thread {

    private final static Logger LOGGER = LogManager.getLogger(MatrixThread.class);

    private int id;

    public MatrixThread(int id){
        this.id = id;
        ThreadCount.increment();
    }

    @Override
    public void run(){
        Matrix matrix = Matrix.getInstance(null, 0);
        int maxChanges = matrix.getSize() - ThreadCount.threadCount;
        int changedDiagonals = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            try {
                if(matrix.setDiagonal(i, id) && changedDiagonals <= maxChanges) {
                    LOGGER.info("Thread #" + id + " changed diagonal #" + i);
                    changedDiagonals++;
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (MatrixException | InterruptedException ex) {
                LOGGER.error(ex);
            }
        }
    }

}