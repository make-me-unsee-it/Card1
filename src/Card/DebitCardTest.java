package Card;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardTest {
    private Card client;
    private Card clientClone;

    @Before
    public void setUp() {
        client = new DebitCard("MICHAIL", "2000");
        clientClone = new DebitCard("MICHAIL", "2000");
    }

    @After
    public void tearDown() {
        client = null;
        clientClone = null;
    }

    @Test
    public void getCardBalance() {
        BigDecimal expected = client.getCardBalance();
        BigDecimal actual = new BigDecimal("2000");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardBalance_NO_NULL() {
        BigDecimal expected = client.getCardBalance();
        Assert.assertNotNull(expected);
    }

    @Test
    public void addCardBalance() {
        BigDecimal money = new BigDecimal("2000");
        client.addCardBalance(money);
        BigDecimal expected = client.getCardBalance();
        BigDecimal actual = clientClone.accountBalance.add(money);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardBalance_NO_NULL() {
        BigDecimal money = new BigDecimal("2000");
        client.addCardBalance(money);
        BigDecimal expected = client.getCardBalance();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getCardBalanceByExchangeRate() {
        String exchangeRate = "1.56";
        BigDecimal expected = client.getCardBalanceByExchangeRate(exchangeRate);
        BigDecimal actual = client.accountBalance.multiply(new BigDecimal(exchangeRate));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardBalanceByExchangeRate_NO_NULL() {
        String exchangeRate = "1.56";
        BigDecimal expected = client.getCardBalanceByExchangeRate(exchangeRate);
        Assert.assertNotNull(expected);
    }

    @Test
    public void withdrawFromCardBalance() throws InsufficientFundsException {
        BigDecimal withdraw = new BigDecimal("1000");
        client.withdrawFromCardBalance(withdraw);
        BigDecimal expected = client.accountBalance;
        BigDecimal actual = clientClone.accountBalance.subtract(withdraw);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdrawFromCardBalance_NO_NULL() throws InsufficientFundsException {
        BigDecimal withdraw = new BigDecimal("1000");
        client.withdrawFromCardBalance(withdraw);
        BigDecimal expected = client.accountBalance;
        Assert.assertNotNull(expected);
    }

    // no unit test for withdrawFromCardBalance() if throw InsufficientFundsException
    // cause don't understand how
}