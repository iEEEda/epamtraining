package kz.eduard.gift.action;

import kz.eduard.gift.entity.AbstractSweets;
import kz.eduard.gift.exception.SugarLevelException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FindBySugarLevel {
    public static List<AbstractSweets> findSweetBySugarLevel (List<AbstractSweets> sweetsList, BigDecimal startOfSugarLevel,
                                                        BigDecimal endOfSugarLevel) throws SugarLevelException {
        List<AbstractSweets> sweetsOfNeededSugarLevel = new ArrayList<>();
        for (int i = 0; i < sweetsList.size(); i++) {
            BigDecimal differenceFromStart;
            BigDecimal differenceFromEnd;
            differenceFromStart = sweetsList.get(i).getSugarLevel().subtract(startOfSugarLevel);
            differenceFromEnd = endOfSugarLevel.subtract(sweetsList.get(i).getSugarLevel());
            if(differenceFromStart.toString().charAt(0) != '-' && differenceFromEnd.toString().charAt(0) != '-'){
                sweetsOfNeededSugarLevel.add(sweetsList.get(i));
            }
        }
        return sweetsOfNeededSugarLevel;
    }
}
