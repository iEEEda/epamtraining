package kz.eduard.tunnel.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TunnelListSingleton {

    private final static Logger LOGGER = LogManager.getLogger(TunnelListSingleton.class);

    private static ReentrantLock lock = new ReentrantLock();
    private static final int MAX_WAITING_TIME = 15;
    private final static int NUM_OF_TUNNELS = 2;
    private static TunnelListSingleton instance = null;
    private List<Tunnel> tunnels = new ArrayList<Tunnel>();


    private TunnelListSingleton(){
        tunnels.add(new Tunnel(1, 10));
        tunnels.add(new Tunnel(2, 12));
    }

    public static TunnelListSingleton getInstance(){
        lock.lock();
        try{
            if (instance == null){
                instance = new TunnelListSingleton();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public Tunnel getTunnel(){
        if(!tunnels.isEmpty()){
            try {
                lock.lock();
                Tunnel tunnel = tunnels.remove(0);
                return tunnel;
            } finally {
                lock.unlock();
            }
        } else {
            try {
                lock.tryLock(MAX_WAITING_TIME, TimeUnit.SECONDS);
            } catch (InterruptedException ex) {
                LOGGER.error(ex);
            } finally {
                lock.unlock();
            }
            return null;
        }
    }

    public void returnTunnel(Tunnel tunnel){
        try {
            lock.lock();
            tunnels.add(tunnel);
        } finally {
            lock.unlock();
        }
    }

    public static ReentrantLock getLock(){
        return lock;
    }

}
