package Card;

import org.junit.*;

import java.math.BigDecimal;

public class ATMTest {
    private Card client;
    private Card clientClone;
    private ATM atm;
    private Card clientDebit;
    private ATM atm2;

    @Before
    public void setUp() {
        client = new CreditCard("VASILIY", "2000");
        clientClone = new CreditCard("VASILIY", "2000");
        clientDebit = new DebitCard("MICKEY", "2000");
        atm = new ATM(client);
        atm2 = new ATM(clientDebit);
    }

    @After
    public void tearDown() {
        client = null;
        clientClone = null;
        atm = null;
        clientDebit = null;
        atm2 = null;
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

    @Test(expected = InsufficientFundsException.class)      // this test isn't working
    public void withdrawOperation_InsufficientFundsException() {
        BigDecimal money = new BigDecimal("5000");
            atm2.withdrawOperation(money);
        }

    @Test
    public void withdrawOperation_NO_NULL() {
        BigDecimal money = new BigDecimal("2000");
        atm.withdrawOperation(money);
        BigDecimal expected = client.accountBalance;
        Assert.assertNotNull(expected);
    }
}