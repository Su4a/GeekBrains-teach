import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(Order.addOrder(new Buyer("Alex"), new Product("Крем")));
        orders.add(Order.addOrder(new Buyer("Meha"), new Product("Дюрасел")));
        System.out.println("Число покупок: " + Order.getCountOrder());
    }
}