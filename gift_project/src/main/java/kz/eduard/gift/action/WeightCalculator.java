package kz.eduard.gift.action;

import kz.eduard.gift.entity.AbstractSweets;

import java.math.BigDecimal;
import java.util.List;

public class WeightCalculator {
    public static BigDecimal calculateWeightOfSweets(List<AbstractSweets> sweetsList){
        if(sweetsList.size() == 0){
            return new BigDecimal("0");
        } else {
            BigDecimal weight = new BigDecimal("0");
            for (int i = 0; i < sweetsList.size(); i++) {
                weight.add(sweetsList.get(0).getWeight());
            }
            return weight;
        }
    }
}
