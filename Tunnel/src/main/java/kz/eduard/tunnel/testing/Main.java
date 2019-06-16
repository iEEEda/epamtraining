package kz.eduard.tunnel.testing;

import kz.eduard.tunnel.entity.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        List<Train> trains = new ArrayList<Train>();
        trains.add(new Train(1, 20));
        trains.add(new Train(2, 25));
        trains.add(new Train(3, 30));
        for (Train train: trains) {
            train.start();
        }
    }

}
