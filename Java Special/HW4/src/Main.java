import exception.WrongOrder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            orders.add(Order.addOrder(new Buyer("Alex"), new Product("����")));
        } catch (WrongOrder e) {
            System.err.println("������� ��������� �� �������");
        }
        try {
            orders.add(Order.addOrder(new Buyer("Meha"), new Product("�������")));
        } catch (WrongOrder e) {
            System.err.println("������� ��������� �� �������");
        }
        System.out.println("����� �������: " + Order.getCountOrder());
    }
}