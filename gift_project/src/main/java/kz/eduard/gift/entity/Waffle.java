package kz.eduard.gift.entity;

import java.math.BigDecimal;

public class Waffle extends AbstractSweets {

    private BigDecimal weight;
    private BigDecimal sugerLevel;
    private Taste taste;

    public Waffle(BigDecimal weight, BigDecimal sugarLevel, Taste taste){
        this.sugerLevel = sugarLevel;
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
        return sugerLevel;
    }

    public void setSugerLevel(BigDecimal sugerLevel) {
        this.sugerLevel = sugerLevel;
    }
}
