package Card;

import java.math.BigDecimal;

public class CreditCard extends Card {
    CreditCard(String cardholder) {
        super(cardholder);
    }

    CreditCard(String cardholder, String accountBalance) {
        super(cardholder, accountBalance);
    }

    @Override
    void withdrawFromCardBalance(BigDecimal withdraw) {
        accountBalance = accountBalance.subtract(withdraw);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardHolder='" + cardHolder + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
