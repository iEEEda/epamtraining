package kz.eduard.gift.action;

import kz.eduard.gift.entity.AbstractSweets;
import kz.eduard.gift.entity.WeightComparator;

import java.util.List;

public class SortByWeight implements Sort{

    @Override
    public void sort(List<AbstractSweets> listOfSweets) {
        List<AbstractSweets> tempList = listOfSweets;
        tempList.sort(new WeightComparator());
        listOfSweets = tempList;
    }
}
