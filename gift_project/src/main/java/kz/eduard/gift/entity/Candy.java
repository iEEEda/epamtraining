package kz.eduard.gift.entity;

import java.math.BigDecimal;

public class Candy extends AbstractSweets {
    private BigDecimal weight;
    private BigDecimal sugarLevel;
    private Taste taste;

    public Candy(BigDecimal weight, BigDecimal sugarLevel, Taste taste){
        this.sugarLevel = sugarLevel;
        this.weight = weight;
        this.taste = taste;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getSugerLevel() {
        return sugarLevel;
    }

    public void setSugerLevel(BigDecimal sugerLevel) {
        this.sugarLevel = sugerLevel;
    }
}
