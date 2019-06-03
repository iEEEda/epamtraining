package kz.eduard.gift.entity;

import kz.eduard.gift.action.FindBySugarLevel;
import kz.eduard.gift.action.SortBySugarLevel;
import kz.eduard.gift.action.SortByWeight;
import kz.eduard.gift.action.WeightCalculator;
import kz.eduard.gift.exception.SugarLevelException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gift {

    private List<AbstractSweets> sweetsInGift;
    private BigDecimal weigthOfGift;

    public Gift(){
        sweetsInGift = new ArrayList<AbstractSweets>();
        weigthOfGift = new BigDecimal("0");
    }

    public Gift(List<AbstractSweets> sweetsList){
        sweetsInGift = sweetsList;
        WeightCalculator.calculateWeightOfSweets(sweetsList);
    }

    public String addSweets(AbstractSweets sweets){
        sweetsInGift.add(sweets);
        weigthOfGift.add(sweets.getWeight());
        return "The sweets are added";
    }

    public String deleteSweets(AbstractSweets sweets) {
        if(sweetsInGift.size() == 0){
            return "The gift is empty";
        } else if (!sweetsInGift.contains(sweets)) {
            return "No such sweets in the gift";
        } else {
            return "The sweet is added";
        }
    }

    public BigDecimal getWeigthOfGift(){
        return weigthOfGift;
    }

    public AbstractSweets getSweets(int index){
        return sweetsInGift.get(index);
    }

    public List<AbstractSweets> sortSweetsByWeight(){
        SortByWeight sort = new SortByWeight();
        sort.sort(sweetsInGift);
        return Collections.unmodifiableList(sweetsInGift);
    }

    public List<AbstractSweets> sortSweetsBySugarLevel(){
        SortBySugarLevel sort = new SortBySugarLevel();
        sort.sort(sweetsInGift);
        return Collections.unmodifiableList(sweetsInGift);
    }

    public List<AbstractSweets> findSweetsBySugarLevel(BigDecimal start, BigDecimal end){
        List<AbstractSweets> neededSweets = new ArrayList<AbstractSweets>();
        try {
            neededSweets = FindBySugarLevel.findSweetBySugarLevel(sweetsInGift, start, end);
        } catch (SugarLevelException ex) {

        } finally {
            return neededSweets;
        }
    }
}
