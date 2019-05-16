public class Order{

    static int numberOfClients = 00000;
    private final int ID;
    private Pizza[] pizzas;
    private int client;


    public Order(Pizza[] pizzas, int client){
        ID = numberOfClients++;
        this.pizzas = pizzas;
        this.client = client;
    }

    public int getClient(){
        return this.client;
    }

    public String toString(){
        System.out.println("********************************");
        System.out.println("Заказ: " + ID);
        System.out.println("Клиент: " + client);
        for (Pizza pizza : pizzas) {
            System.out.println("Название: " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println();
        }
        System.out.println("Название: " + );
    }
}