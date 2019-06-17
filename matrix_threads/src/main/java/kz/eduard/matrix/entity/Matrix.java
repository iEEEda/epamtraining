package kz.eduard.matrix.entity;

import kz.eduard.matrix.exception.MatrixException;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {

    private static Matrix instance = null;
    private static Lock lock = new ReentrantLock(true);
    private static AtomicBoolean created = new AtomicBoolean(false);
    private Cell matrix[][];
    private int size;

    private Matrix(Cell cells[][], int size){
        matrix = cells;
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public static Lock getLock() {
        return lock;
    }

    public static Matrix getInstance(Cell cells[][], int size){
        if (!created.get()) {
            lock.lock();
            try {
                if(instance == null) {
                    instance = new Matrix(cells, size);
                    created.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public boolean isEmpty(int x, int y) throws MatrixException {
        return matrix[x][y].getEmpty();
    }

    public void setCell(int x, int y, int number) throws MatrixException {
        matrix[x][y].setNumber(number);
    }

    public void setEmptyCell(int x, int y, int number) throws MatrixException {
        matrix[x][y] = new Cell(number);
    }

    public boolean setDiagonal(int x, int number) throws MatrixException {
        lock.lock();
        try {
            if (!matrix[x][x].getClass().equals(Diagonal.class)) {
                matrix[x][x] = new Diagonal();
                matrix[x][x].setNumber(number);
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    public Cell getCell(int x, int y) throws MatrixException{
        return matrix[x][y];
    }
}