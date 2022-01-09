package Card;

public class InsufficientFundsException extends Throwable {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
