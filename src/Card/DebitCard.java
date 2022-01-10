package Card;

import java.math.BigDecimal;

public class DebitCard extends Card {

    // debit card implements class Card

    DebitCard(String cardholder) {
        super(cardholder);
    }

    DebitCard(String cardholder, String accountBalance) {
        super(cardholder, accountBalance);
    }

    @Override
    void withdrawFromCardBalance(BigDecimal withdraw) throws InsufficientFundsException {
        if (accountBalance.compareTo(withdraw) >= 0) accountBalance = accountBalance.subtract(withdraw);
        else {
            throw new InsufficientFundsException("Недостаточно средств!");
        }
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "cardHolder='" + cardHolder + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

}
