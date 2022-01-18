package Card;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {
    private Card client;
    private Card clientClone;

    @Before
    public void setUp() {
        client = new CreditCard("VASILIY", "2000");
        clientClone = new CreditCard("VASILIY", "2000");
    }

    @After
    public void tearDown() {
        client = null;
        clientClone = null;
    }

    @Test
    public void testGetCardBalance() {
        BigDecimal expected = client.getCardBalance();
        BigDecimal actual = new BigDecimal("2000");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCardBalance_NO_NULL() {
        BigDecimal expected = client.getCardBalance();
        Assert.assertNotNull(expected);
    }

    @Test
    public void testAddCardBalance() {
        BigDecimal money = new BigDecimal("2000");
        client.addCardBalance(money);
        BigDecimal expected = client.getCardBalance();
        BigDecimal actual = clientClone.accountBalance.add(money);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddCardBalance_NO_NULL() {
        BigDecimal money = new BigDecimal("2000");
        client.addCardBalance(money);
        BigDecimal expected = client.getCardBalance();
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetCardBalanceByExchangeRate() {
        String exchangeRate = "1.56";
        BigDecimal expected = client.getCardBalanceByExchangeRate(exchangeRate);
        BigDecimal actual = client.accountBalance.multiply(new BigDecimal(exchangeRate));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCardBalanceByExchangeRate_NO_NULL() {
        String exchangeRate = "1.56";
        BigDecimal expected = client.getCardBalanceByExchangeRate(exchangeRate);
        Assert.assertNotNull(expected);
    }

    @Test
    public void testWithdrawFromCardBalance() throws InsufficientFundsException {
        BigDecimal withdraw = new BigDecimal("5000");
        client.withdrawFromCardBalance(withdraw);
        BigDecimal expected = client.accountBalance;
        BigDecimal actual = clientClone.accountBalance.subtract(withdraw);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawFromCardBalance_NO_NULL() throws InsufficientFundsException {
        BigDecimal withdraw = new BigDecimal("5000");
        client.withdrawFromCardBalance(withdraw);
        BigDecimal expected = client.accountBalance;
        Assert.assertNotNull(expected);
    }
}