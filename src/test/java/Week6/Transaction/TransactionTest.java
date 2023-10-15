package Week6.Transaction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TransactionTest {

    @Test
    public void testConstructorValid() {
        Transaction transaction = new Transaction(Transaction.DEPOSIT, 100, 200);
        double delta = 0.00000001;

        assertEquals(Transaction.DEPOSIT, transaction.getOperation());
        assertEquals(100, transaction.getAmount(), delta);
        assertEquals(200, transaction.getBalance(), delta);
    }

    @Test
    public void testConstructorInvalidOperation() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Transaction("invalid", 100, 200)
        );
        String expected = "Invalid operation: invalid";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testConstructorInvalidAmount() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Transaction(Transaction.DEPOSIT, -100, 200)
        );
        String expected = "Invalid amount: -100.0";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testConstructorInvalidBalance() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Transaction(Transaction.DEPOSIT, 100, -200)
        );
        String expected = "Invalid balance: -200.0";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testGettersAndSettersValid() {
        Transaction transaction = new Transaction(Transaction.DEPOSIT, 100, 200);
        double delta = 0.00000001;

        transaction.setOperation(Transaction.WITHDRAW);
        transaction.setAmount(50);
        transaction.setBalance(150);

        assertEquals(Transaction.WITHDRAW, transaction.getOperation());
        assertEquals(50, transaction.getAmount(), delta);
        assertEquals(150, transaction.getBalance(), delta);
    }

    @Test
    public void testSetOperationInvalid() {
        Transaction transaction = new Transaction(Transaction.DEPOSIT, 100, 200);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> transaction.setOperation("invalid")
        );
        String expected = "Invalid operation: invalid";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testSetAmountInvalid() {
        Transaction transaction = new Transaction(Transaction.DEPOSIT, 100, 200);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> transaction.setAmount(-100)
        );
        String expected = "Invalid amount: -100.0";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void testSetBalanceInvalid() {
        Transaction transaction = new Transaction(Transaction.DEPOSIT, 100, 200);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> transaction.setBalance(-200)
        );
        String expected = "Invalid balance: -200.0";
        assertEquals(expected, thrown.getMessage());
    }
}
