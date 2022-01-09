package Card;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ATMTest {
    private Card client;
    private Card clientClone;
    private ATM atm;

    @Before
    public void setUp() {
        client = new CreditCard("VASILIY", "2000");
        clientClone = new CreditCard("VASILIY", "2000");
        atm = new ATM(client);
    }

    @After
    public void tearDown() {
        client = null;
        clientClone = null;
        atm = null;
    }

    @Test
    public void depositOperation() {
        BigDecimal money = new BigDecimal("2000");
        atm.depositOperation(money);
        BigDecimal expected = client.accountBalance;
        BigDecimal actual = clientClone.accountBalance.add(money);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void depositOperation_NO_NULL() {
        BigDecimal money = new BigDecimal("2000");
        atm.depositOperation(money);
        BigDecimal expected = client.accountBalance;
        Assert.assertNotNull(expected);
    }

    @Test
    public void withdrawOperation() {
        BigDecimal money = new BigDecimal("2000");
        atm.withdrawOperation(money);
        BigDecimal expected = client.accountBalance;
        BigDecimal actual = clientClone.accountBalance.subtract(money);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdrawOperation_NO_NULL() {
        BigDecimal money = new BigDecimal("2000");
        atm.withdrawOperation(money);
        BigDecimal expected = client.accountBalance;
        Assert.assertNotNull(expected);
    }

    // no unit test for withdrawOperation() if throw InsufficientFundsException
    // cause don't understand how
}