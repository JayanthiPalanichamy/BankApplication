import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankApplicationTest {

    BankApplication bankApplication;
    int balance = 100;

    @Before
    public void setUp() {
        bankApplication = new BankApplication(balance);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnZeroWhenTheBalanceIsZero() {
        BankApplication bankApplication1 = new BankApplication(0);
        assertEquals(0, bankApplication1.getBalance());
    }

    @Test
    public void shouldReturnHundredWhenTheBalanceIsHundred() {
        assertEquals(100, bankApplication.getBalance());
    }

    @Test
    public void shouldThrowExceptionWhenBalanceIsInitializedNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Balance cannot be negative");

        new BankApplication(-100);
    }

    @Test
    public void shouldAddZeroToCurrentBalanceWhenCreditAmountIsZero() {
        int initialBalance = bankApplication.getBalance();
        bankApplication.credit(0);
        assertEquals(initialBalance, bankApplication.getBalance());
    }

    @Test
    public void shouldAddHundredToCurrentBalanceWhenCreditAmountIsHundred() {
        int initialBalance = bankApplication.getBalance();
        bankApplication.credit(100);
        assertEquals(initialBalance+100, bankApplication.getBalance());
    }

    @Test
    public void shouldReturnFalseIfCreditAmountIsNegative() {
        assertFalse(bankApplication.credit(-100));
    }

    @Test
    public void shouldSubtractZeroIfWithdrawalAmountIsZero() {
        int initialBalance = bankApplication.getBalance();
        bankApplication.withdraw(0);
        assertEquals(initialBalance, bankApplication.getBalance());
    }

    @Test
    public void shouldReturnZeroIfWithdrawalAmountIsHundred() {
        int initialBalance = bankApplication.getBalance();
        bankApplication.withdraw(100);
        assertEquals(0, bankApplication.getBalance());
    }

    @Test
    public void shouldSubtractTwentyWhenWithdrawalAmountIsTwenty() {
        int initialBalance = bankApplication.getBalance();
        bankApplication.withdraw(20);
        assertEquals(initialBalance-20, bankApplication.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenWithdrawalAmountIsTwoHundred() {
        assertFalse(bankApplication.withdraw(200));
    }

    @Test
    public void shouldReturnFalseWhenWithdrawAmountIsNegative() {
        assertFalse(bankApplication.withdraw(-80));
    }
}
