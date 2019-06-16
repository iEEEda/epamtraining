package kz.eduard.tunnel.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Train extends Thread{

    private final static Logger LOGGER = LogManager.getLogger(Train.class);

    private int trainId;
    private int speedMpS;
    private int lengthOfTrainM;

    public Train(int trainId, int speedMpS){
        this.trainId = trainId;
        this.speedMpS = speedMpS;
    }

    @Override
    public void run() {

        TunnelListSingleton tunnels = TunnelListSingleton.getInstance();

        Tunnel tunnel = null;

        try {
            tunnel = tunnels.getTunnel();

            if(tunnel != null) {
                LOGGER.info("Train number: " + trainId + " is riding through the tunnel #" + tunnel.getTunnelId());

                tunnel.rideThroughTunnel(this);
            } else {
                LOGGER.info("No free tunnels for train #" + trainId);
            }
        } catch (InterruptedException ex) {
            LOGGER.error(ex);
        } finally {
            if(tunnel != null){
                tunnels.returnTunnel(tunnel);
            }

        }
    }

    public int getSpeedMpS(){
        return speedMpS;
    }

    public int getLengthOfTrainM(){
        return lengthOfTrainM;
    }
}
