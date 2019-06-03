package kz.eduard.gift.entity;

public enum Taste {
    STRAWBERRY("Strawberry"), CARAMEL("Caramel"), CHOCOLATE("Chocolate"), VANILLA("Vanilla"), NUT("Nut");

    private String name;

    Taste(String name){
        this.name = name;
    }
}
