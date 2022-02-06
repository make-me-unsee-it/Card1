package Card;

import Card.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;

public class ATM {
    protected Card currentCard;

    public ATM(Card currentCard) {
        this.currentCard = currentCard;
    }

    public ATM() {
    }

    public void depositOperation(BigDecimal add) {
        currentCard.addCardBalance(add);
    }

    public void withdrawOperation(BigDecimal withdraw) {
        try {
            currentCard.withdrawFromCardBalance(withdraw);
        } catch (InsufficientFundsException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ATM{" +
                "currentCard=" + currentCard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATM atm)) return false;
        return currentCard.equals(atm.currentCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentCard);
    }
}
