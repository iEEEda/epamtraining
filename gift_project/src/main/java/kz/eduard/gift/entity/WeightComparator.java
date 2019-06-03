package kz.eduard.gift.entity;

import java.util.Comparator;

public class WeightComparator implements Comparator<AbstractSweets> {

    @Override
    public int compare(AbstractSweets o1, AbstractSweets o2) {
        return o1.weight.compareTo(o2.weight);
    }

}
