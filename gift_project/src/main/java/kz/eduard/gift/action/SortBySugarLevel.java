package kz.eduard.gift.action;

import kz.eduard.gift.entity.AbstractSweets;
import kz.eduard.gift.entity.Gift;
import kz.eduard.gift.entity.SugarLevelComparator;

import java.util.List;

public class SortBySugarLevel implements Sort{

    @Override
    public void sort(List<AbstractSweets> listOfSweets) {
        List<AbstractSweets> tempList = listOfSweets;
        tempList.sort(new SugarLevelComparator());
        listOfSweets = tempList;
    }
}
