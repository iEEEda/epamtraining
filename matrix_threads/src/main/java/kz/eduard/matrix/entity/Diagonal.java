package kz.eduard.matrix.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class Diagonal extends Cell {

    private final static Logger LOGGER = LogManager.getLogger(Diagonal.class);
    private static AtomicBoolean changed = new AtomicBoolean(false);
    private static Lock lock = Matrix.getLock();
    private int number;

    @Override
    public void setNumber(int number){
        if(!changed.get()){
            lock.lock();
            try {
                this.number = number;
                changed.set(true);
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean getChanged(){
        return changed.get();
    }

    @Override
    public int getNumber(){
        return number;
    }
}
