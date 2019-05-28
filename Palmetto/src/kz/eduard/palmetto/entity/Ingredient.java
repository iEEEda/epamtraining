package kz.eduard.palmetto.entity;

public enum Ingredient {
    TOMATO_PASTE(1.0f, "Tomato paste"), CHEESE(1.0f, "Cheese"), SALAMI(1.5f, "Salami"),
    BACON(1.2f, "Bacon"), GARLIC(0.3f, "Garlic"), CORN(0.7f, "Corn"),
    PEPPERONI(0.6f, "Pepperoni"), OLIVES(0.5f, "Olives");

    private float price;
    private String name;

    Ingredient(float price, String name){
        this.price = price;
        this.name = name;
    }
    public float getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }
}
