import exception.WrongOrder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            orders.add(Order.addOrder(new Buyer("Alex"), new Product("Крем")));
        } catch (WrongOrder e) {
            System.err.println("Покупку совершить не удалось");
        }
        try {
            orders.add(Order.addOrder(new Buyer("Meha"), new Product("Дюрасел")));
        } catch (WrongOrder e) {
            System.err.println("Покупку совершить не удалось");
        }
        System.out.println("Число покупок: " + Order.getCountOrder());
    }
}