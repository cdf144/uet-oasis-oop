package Week6.Transaction;

public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Constructor of Transaction with 3 variables.
     *
     * @param operation type of operation
     * @param amount    amount of transaciton
     * @param balance   account balance
     */
    public Transaction(String operation, double amount, double balance) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        } else {
            this.operation = operation;
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        } else {
            this.amount = amount;
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Invalid balance: " + balance);
        } else {
            this.balance = balance;
        }
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        } else {
            this.operation = operation;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        } else {
            this.amount = amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Invalid balance: " + balance);
        } else {
            this.balance = balance;
        }
    }
}
