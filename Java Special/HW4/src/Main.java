import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(Order.addOrder(new Buyer("Alex"), new Product("����")));
        orders.add(Order.addOrder(new Buyer("Meha"), new Product("�������")));
        System.out.println("����� �������: " + Order.getCountOrder());
    }
}