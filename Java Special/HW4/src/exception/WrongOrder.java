package exception;

public class WrongOrder extends RuntimeException{
    public WrongOrder(String message) {
        super(message);
    }
}
