package kz.eduard.tunnel.action;

import kz.eduard.tunnel.entity.Train;
import kz.eduard.tunnel.entity.Tunnel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RideTroughTheTunnel {

    private final static Logger LOGGER = LogManager.getLogger(RideTroughTheTunnel.class);

    public int rideTroughTheTunnel(Tunnel tunnel, Train train){

        int lengthOfTunnel = tunnel.getLengthOfTunnelM();
        int speedOfTrain = train.getSpeedMpS();
        int lengthOfTrain = train.getLengthOfTrainM();
        return (lengthOfTunnel + lengthOfTrain)/speedOfTrain;

    }

}
