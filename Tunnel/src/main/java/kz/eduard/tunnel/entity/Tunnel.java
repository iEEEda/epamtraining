package kz.eduard.tunnel.entity;

import kz.eduard.tunnel.action.RideTroughTheTunnel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel {

    private final static Logger LOGGER = LogManager.getLogger(Tunnel.class);

    private int tunnelId;
    private static final int MAX_WAITING_TIME = 15;
    private AtomicBoolean isFree = new AtomicBoolean();
    private int lengthOfTunnelM;
    private ReentrantLock lock = TunnelListSingleton.getLock();

    public Tunnel(int tunnelId, int lengthOfTunnelM){
        isFree.set(true);
        this.tunnelId = tunnelId;
        this.lengthOfTunnelM = lengthOfTunnelM;
    }

    public void rideThroughTunnel(Train train)throws InterruptedException{
        lock.lock();
        if (isFree.get()) {
            isFree.set(false);
            RideTroughTheTunnel ride = new RideTroughTheTunnel();
            try {
                int secondsOfRide = ride.rideTroughTheTunnel(this, train);
                TimeUnit.SECONDS.sleep(secondsOfRide);
            } catch (InterruptedException ex) {
                LOGGER.error(ex);
            } finally {
                isFree.set(true);
                lock.unlock();
            }
        } else {
            lock.tryLock(MAX_WAITING_TIME, TimeUnit.SECONDS);
        }
    }

    public int getTunnelId() {
        return tunnelId;
    }

    public int getLengthOfTunnelM(){
        return lengthOfTunnelM;
    }
}
