package Week16.Banking_System;

public class SavingsAccount extends Account {
    public SavingsAccount() {
        super();
    }

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw from savings account.
     *
     * @param amount amount
     */
    public void withdraw(double amount) {
        try {
            if (amount > 1000.0) {
                throw new IllegalArgumentException("Illegal amount");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            if (this.balance < 5000.0) {
                throw new InsufficientFundsException();
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return;
        }

        double initialBalance = this.balance;
        try {
            doWithdrawing(amount);
        } catch (InvalidFundingAmountException
                 | InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return;
        }

        this.transactionList.add(new Transaction(
                Transaction.TYPE_WITHDRAW_SAVINGS,
                amount,
                initialBalance,
                this.balance)
        );
    }

    /**
     * Deposit from savings account.
     *
     * @param amount amount
     */
    public void deposit(double amount) {
        double initialBalance = this.balance;
        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
            return;
        }

        this.transactionList.add(new Transaction(
                Transaction.TYPE_DEPOSIT_SAVINGS,
                amount,
                initialBalance,
                this.balance)
        );
    }
}
