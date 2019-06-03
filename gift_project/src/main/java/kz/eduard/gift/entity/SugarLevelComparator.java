package kz.eduard.gift.entity;

import java.util.Comparator;

public class SugarLevelComparator implements Comparator<AbstractSweets> {
    @Override
    public int compare(AbstractSweets o1, AbstractSweets o2) {
        return o1.sugarLevel.compareTo(o2.sugarLevel);
    }
}
