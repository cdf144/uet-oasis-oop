package Week6.Transaction;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AccountTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(printStream);
    }

    @Test
    public void testDeposit() {
        Account account = new Account();

        account.addTransaction(100, Transaction.DEPOSIT);

        double delta = 0.00000001;

        assertEquals(100, account.getBalance(), delta);
        assertEquals(1, account.getTransactionList().size());
        assertEquals(Transaction.DEPOSIT, account.getTransactionList().get(0).getOperation());
        assertEquals(100, account.getTransactionList().get(0).getAmount(), delta);
        assertEquals(100, account.getTransactionList().get(0).getBalance(), delta);
    }

    @Test
    public void testWithdraw() {
        Account account = new Account();
        account.addTransaction(100, Transaction.DEPOSIT);

        account.addTransaction(50, Transaction.WITHDRAW);

        double delta = 0.00000001;

        assertEquals(50, account.getBalance(), delta);
        assertEquals(2, account.getTransactionList().size());
        assertEquals(Transaction.WITHDRAW, account.getTransactionList().get(1).getOperation());
        assertEquals(50, account.getTransactionList().get(1).getAmount(), delta);
        assertEquals(50, account.getTransactionList().get(1).getBalance(), delta);
    }

    @Test
    public void setBalanceInvalid() {
        Account account = new Account();
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> account.setBalance(-200)
        );
        String expected = "Invalid balance: -200.0";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testInvalidDeposit() {
        Account account = new Account();

        account.addTransaction(-100, Transaction.DEPOSIT);

        double delta = 0.00000001;

        assertEquals(0, account.getBalance(), delta);
        assertEquals(0, account.getTransactionList().size());
    }

    @Test
    public void testInvalidWithdraw() {
        Account account = new Account();

        account.addTransaction(100, Transaction.WITHDRAW);

        double delta = 0.00000001;

        assertEquals(0, account.getBalance(), delta);
        assertEquals(0, account.getTransactionList().size());
    }

    @Test
    public void testInsufficientBalance() {
        Account account = new Account();
        account.addTransaction(100, Transaction.DEPOSIT);

        account.addTransaction(150, Transaction.WITHDRAW);

        double delta = 0.00000001;

        assertEquals(100, account.getBalance(), delta);
        assertEquals(1, account.getTransactionList().size());
    }

    @Test
    public void testInvalidOperation() {
        Account account = new Account();

        account.addTransaction(100, "invalid");

        double delta = 0.00000001;

        assertEquals(0, account.getBalance(), delta);
        assertEquals(0, account.getTransactionList().size());
    }

    @Test
    public void testPrintTransaction() {
        Account account = new Account();

        account.addTransaction(100, Transaction.DEPOSIT);
        account.addTransaction(50, Transaction.WITHDRAW);

        String expectedOutput =
                "Giao dich 1: Nap tien $100.00. So du luc nay: $100.00." +
                System.lineSeparator() +
                "Giao dich 2: Rut tien $50.00. So du luc nay: $50.00." +
                System.lineSeparator();
        /*
        Windows uses \r\n (CRLF) as newline character, if you set the newline
        character of expectedOutput to be just \n (LF) then the test will fail.
        For reference, GNU/Linux uses \n (LF), and MacOS uses \r (CR)
         */

        account.printTransaction();
        assertEquals(expectedOutput, outputStream.toString());
    }
}
