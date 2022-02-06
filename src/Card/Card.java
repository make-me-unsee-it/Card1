package Card;

import Card.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;

abstract public class Card {
    protected String cardHolder;
    public BigDecimal accountBalance;

    // this class is abstract

    Card(String cardHolder) {
        this.cardHolder = cardHolder;
        this.accountBalance = BigDecimal.ZERO;
    }

    Card(String cardHolder, String accountBalance) {
        this.cardHolder = cardHolder;
        this.accountBalance = new BigDecimal(accountBalance);
    }

    public BigDecimal getCardBalance() {
        return accountBalance;
    }

    public void addCardBalance(BigDecimal add) {
        accountBalance = accountBalance.add(add);
    }

    public abstract void withdrawFromCardBalance(BigDecimal withdraw) throws InsufficientFundsException;

    public BigDecimal getCardBalanceByExchangeRate(String exchangeRate) {
        return accountBalance.multiply(new BigDecimal(exchangeRate));
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardHolder='" + cardHolder + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return cardHolder.equals(card.cardHolder) && accountBalance.equals(card.accountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardHolder, accountBalance);
    }
}
