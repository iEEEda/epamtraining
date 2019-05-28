package kz.eduard.palmetto.main;

import kz.eduard.palmetto.entity.Client;
import kz.eduard.palmetto.entity.Ingredient;
import kz.eduard.palmetto.entity.Order;
import kz.eduard.palmetto.entity.Pizza;
import kz.eduard.palmetto.report.PizzaReport;

public class PalmettoMain {
    public static void main(String[] args) {
        Client aida = new Client(7717);

        Pizza margarita = new Pizza("Margarita", true, 2, aida, 1);
        margarita.addIngredient(Ingredient.TOMATO_PASTE);
        margarita.addIngredient(Ingredient.PEPPERONI);
        margarita.addIngredient(Ingredient.GARLIC);
        margarita.addIngredient(Ingredient.BACON);
        Pizza pepperoniOro = new Pizza("PepperoniOro", true, 3, aida, 2);
        pepperoniOro.addIngredient(Ingredient.PEPPERONI);
        pepperoniOro.addIngredient(Ingredient.TOMATO_PASTE);
        pepperoniOro.addIngredient(Ingredient.CHEESE);
        pepperoniOro.addIngredient(Ingredient.SALAMI);
        pepperoniOro.addIngredient(Ingredient.OLIVES);

        Order order = new Order(aida, margarita, pepperoniOro);

        System.out.print("Order #" + order.getID() + " was created at ");
        System.out.println(order.timeOfOrder());

        Client anotherClient = new Client(4372);
        Pizza basePZZ = new Pizza("BasePZZ", false, 10, anotherClient, 1);

        Order nextOrder = new Order(anotherClient, basePZZ);

        Pizza basePZZ2 = new Pizza("BasePZZ", false, 2, anotherClient, 1);

        Order thirdOrder = new Order(anotherClient, basePZZ2);

        PizzaReport check = new PizzaReport();
        check.printCheck(order);
        System.out.println();
        check.printCheck(nextOrder);
        System.out.println();
        check.printCheck(thirdOrder);
    }
}
