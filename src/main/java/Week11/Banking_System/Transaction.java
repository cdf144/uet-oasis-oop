package Week11.Banking_System;

public class Transaction {
  public static final int TYPE_DEPOSIT_CHECKING = 0;
  public static final int TYPE_WITHDRAW_CHECKING = 1;
  public static final int TYPE_DEPOSIT_SAVINGS = 2;
  public static final int TYPE_WITHDRAW_SAVINGS = 3;
  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Transaction constructor 1.
   */
  public Transaction() {
    this.type = 0;
    this.amount = 0;
    this.initialBalance = 0;
    this.finalBalance = 0;
  }

  /**
   * Transaction constructor 2.
   *
   * @param type           type
   * @param amount         amount
   * @param initialBalance initial balance
   * @param finalBalance   final balance
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /**
   * Transaction type to string.
   *
   * @param type type int
   * @return type string
   */
  private String getTransactionTypeString(int type) {
    if (type == 0) {
      return "Nạp tiền vãng lai";
    }
    if (type == 1) {
      return "Rút tiền vãng lai";
    }
    if (type == 2) {
      return "Nạp tiền tiết kiệm";
    }
    if (type == 3) {
      return "Rút tiền tiết kiệm";
    }
    return "";
  }

  /**
   * Get Transaction summary.
   *
   * @return Transaction summary
   */
  public String getTransactionSummary() {
    return String.format(
            "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. "
                    + "Số tiền: $%.2f. Số dư cuối: $%.2f.",
            getTransactionTypeString(this.type),
            this.initialBalance,
            this.amount,
            this.finalBalance
    );
  }
}
