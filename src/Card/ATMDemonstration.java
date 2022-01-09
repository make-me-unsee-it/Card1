package Card;

import java.math.BigDecimal;

public class ATMDemonstration {
    public static void main(String[] args) {
        Card client1 = new CreditCard("VASILIY", "2000");
        Card client2 = new DebitCard("MICHAIL", "2000");

        ATM newATM = new ATM(client1);
        newATM.depositOperation(new BigDecimal("5000"));
        System.out.println(client1);

        ATM newATM2 = new ATM(client2);
        newATM2.withdrawOperation(new BigDecimal("5000"));
    }
}

