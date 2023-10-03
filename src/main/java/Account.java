import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;

    /**
     * Account constructor 1.
     */
    public Account() {
        this.accountNumber = 0;
        this.balance = 0;
        this.transactionList = new ArrayList<>();
    }

    /**
     * Account constructor 2.
     * @param accountNumber account number
     * @param balance balance
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void doWithdrawing(double amount) {
        if (amount < 0 || amount > this.balance) {
            throw new IllegalArgumentException();
        }
    }

    public void doDepositing(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getTransactionHistory() {
        StringBuilder transactionHistory = new StringBuilder();
        transactionHistory.append(String.format(
                "Lịch sử giao dịch của tài khoản %d:",
                this.accountNumber)
        );
        for (Transaction transaction : transactionList) {
            transactionHistory.append("\n");
        }
        return transactionHistory.toString();
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
}
