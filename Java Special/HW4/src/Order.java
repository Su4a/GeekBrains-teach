import exception.WrongOrder;

public class Order {
    private static int countOrder;
    private final Buyer buyer;
    private final Product product;

    private Order(Buyer buyer, Product product) {
        this.buyer = buyer;
        this.product = product;
    }

    public static Order addOrder(Buyer buyer, Product product) {
        if (buyer == null) throw  new WrongOrder("Пользователь не передан");
        if (product == null) throw new WrongOrder("Продукт не передан");
        countOrder++;
        return new Order(buyer, product);
    }

    public static int getCountOrder() {
        return countOrder;
    }
}
