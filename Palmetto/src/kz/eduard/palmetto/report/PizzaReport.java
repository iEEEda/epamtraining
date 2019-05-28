package kz.eduard.palmetto.report;

import kz.eduard.palmetto.entity.Ingredient;
import kz.eduard.palmetto.entity.Order;
import kz.eduard.palmetto.entity.Pizza;

public class PizzaReport {
    public void  printCheck(Order order){
        System.out.println("********************************");
        System.out.printf("Заказ: %05d%n", order.getID());
        System.out.printf("Клиент: %s%n", order.getClient().getName());
        float orderPrice = 0.0f;
        for (Pizza pizza : order.getPizzas()) {
            System.out.printf("Название: %s%n", pizza.getName());
            System.out.println("--------------------------------");
            System.out.printf("Pizza Base %s %11s%n", (pizza.isCalzone() ? "(Calzone)": "         "), (pizza.isCalzone() ? "1.5 €": "1.0 €"));
            float pizzaPrice = (pizza.isCalzone() ? 1.5f : 1.0f);
            for (Ingredient ingredient : pizza.getIngredients()){
                if(ingredient != null) {
                    System.out.printf("%-16s %13.2f%s%n", ingredient.getName(),ingredient.getPrice(), " €");
                    pizzaPrice += ingredient.getPrice();
                }
            }
            System.out.println("--------------------------------");
            System.out.printf("Всего: %23.2f%s%n", pizzaPrice, " €");
            System.out.printf("Кол-во: %24d%n", pizza.getAmount());
            System.out.println("--------------------------------");
            orderPrice += pizzaPrice * pizza.getAmount();
        }
        System.out.printf("Общая сумма: %17.2f%s%n", orderPrice, " €");
        System.out.println("********************************");
    }

    public String pizzaInfo(Order order, Pizza pizza){
        if(order == null || pizza == null) {
            throw new IllegalArgumentException();
        } else {
            return "[" + order.getID() + ":" + order.getClient().getName() + ":" + pizza.getName() + ":" + pizza.getAmount() + "]";
        }
    }
}
