package kz.eduard.palmetto.entity;

import java.time.LocalTime;

public class Order{

    private static int numberOfClients = 0;
    private final int ID;
    private Pizza[] pizzas ;
    private Client client;
    private LocalTime time;


    public Order(Client client, Pizza... pizzas) {
        ID = ++numberOfClients;
        this.pizzas = pizzas;
        this.client = client;
        time = LocalTime.now();
    }

    public String timeOfOrder(){
        return time.toString();
    }

    public int getID() {
        return ID;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public Client getClient() {
        return client;
    }
}