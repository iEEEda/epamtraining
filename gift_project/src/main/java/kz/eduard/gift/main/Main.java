package kz.eduard.gift.main;

import kz.eduard.gift.entity.Candy;
import kz.eduard.gift.entity.Gift;
import kz.eduard.gift.entity.Taste;
import kz.eduard.gift.entity.Waffle;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Gift gift = new Gift();
        gift.addSweets(new Candy(new BigDecimal("1.25"), new BigDecimal("0.32"), Taste.CARAMEL));
        gift.addSweets(new Candy(new BigDecimal("1.55"), new BigDecimal("0.43"), Taste.NUT));
        gift.addSweets(new Waffle(new BigDecimal("5.6"), new BigDecimal("0.12"), Taste.VANILLA));

        gift.getWeigthOfGift();
        gift.sortSweetsByWeight();
        gift.findSweetsBySugarLevel(new BigDecimal("0.33"), new BigDecimal("0.5"));

    }

}
