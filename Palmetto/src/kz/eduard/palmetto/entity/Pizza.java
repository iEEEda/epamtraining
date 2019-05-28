package kz.eduard.palmetto.entity;

import kz.eduard.palmetto.validator.NameValidator;

public class Pizza {

    private static final double NOT_CALZONE = 1;
    private static final double CALZONE = 1.5;
    private static final byte MAX_INGREDIENTS = 7;

    private boolean isCalzone;
    private Ingredient[] ingredients = new Ingredient[MAX_INGREDIENTS];
    private String name;
    private byte indexInOrder;
    private byte amount;

    public Pizza(String name, boolean isCalzone, int amount, Client client, int indexInOrder){
        NameValidator validator = new NameValidator();
        this.name = validator.validateName(name) ? name : client.getName() + "_" + indexInOrder;
        this.isCalzone = isCalzone;
        this.amount = (byte)amount;
        this.indexInOrder = (byte)indexInOrder;
    }

    public boolean isCalzone() {
        return isCalzone;
    }

    public void setCalzone(boolean calzone) {
        isCalzone = calzone;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAmount() {
        return amount;
    }

    public void setAmount(byte amount) {
        this.amount = amount;
    }

    public String addIngredient(Ingredient ingredient){
        if(ingredients[MAX_INGREDIENTS - 1] != null){
            return "The pizza is already full";
        } else {
            for (int i = 0; i < ingredients.length; i++) {
                if (ingredients[i] == null) {
                    ingredients[i] = ingredient;
                    return "Ingredient is added";
                } else if(ingredients[i] != null && ingredients[i] == ingredient) {
                    return "Check the order again";
                }
            }
            return "Something went wrong";
        }
    }

    public String deleteIngredient(Ingredient ingredient){
        if (this.ingredients[0] == null) {
            return "Pizza has no ingredients";
        } else {
            for (int i = 0; i < ingredients.length; i++) {
                if (ingredients[i] == ingredient) {
                    for (int j = i + 1; j < ingredients.length; j++) {
                        ingredients[j - 1] = ingredients[j];
                    }
                    ingredients[MAX_INGREDIENTS - 1] = null;
                    return "Ingredient is deleted";
                }
            }
            return "No such ingredient in pizza";
        }
    }
}
