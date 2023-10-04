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

    /**
     * Check if withdraw amount is valid.
     * @param amount withdraw amount
     */
    public void doWithdrawing(double amount) throws InsufficientFundsException,
            InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > this.balance) {
            throw new InsufficientFundsException(amount);
        } else {
            this.balance -= amount;
        }
    }

    /**
     * Check if deposit amount is valid.
     * @param amount deposit amount
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            this.balance += amount;
        }
    }

    /**
     * Get transaction history string.
     * @return transaction history string
     */
    public String getTransactionHistory() {
        StringBuilder transactionHistory = new StringBuilder();
        transactionHistory.append(String.format(
                "Lịch sử giao dịch của tài khoản %d:",
                this.accountNumber)
        );
        for (Transaction transaction : transactionList) {
            transactionHistory.append("\n");
            transactionHistory.append(transaction.getTransactionSummary());
        }
        return transactionHistory.toString();
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    /**
     * Check if 2 accounts are the same based on account number.
     * @param o object
     * @return boolean if 2 accounts are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Account) {
            Account another = (Account) o;
            return this.accountNumber == another.getAccountNumber();
        }
        return false;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}
