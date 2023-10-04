package Week11.Banking_System;

public class CheckingAccount extends Account {
  public CheckingAccount() {
    super();
  }

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  /**
   * Withdraw from checking account.
   *
   * @param amount amount
   */
  public void withdraw(double amount) {
    double initialBalance = this.balance;
    try {
      doWithdrawing(amount);
    } catch (InvalidFundingAmountException
             | InsufficientFundsException e) {
      System.out.println(e.getMessage());
      return;
    }
    this.transactionList.add(new Transaction(
            Transaction.TYPE_WITHDRAW_CHECKING,
            amount,
            initialBalance,
            this.balance
    ));
  }

  /**
   * Deposit from checking account.
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
            Transaction.TYPE_DEPOSIT_CHECKING,
            amount,
            initialBalance,
            this.balance
    ));
  }
}
