package kz.eduard.gift.entity;

import java.math.BigDecimal;

public abstract class AbstractSweets {
    BigDecimal weight;
    BigDecimal sugarLevel;
    Taste taste;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(BigDecimal sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }
}
