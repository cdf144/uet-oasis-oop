package Week11.Banking_System;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException() {
        super();
    }

    /**
     * Throw insufficient funds exception with message.
     *
     * @param amount amount
     */
    public InsufficientFundsException(double amount) {
        super(String.format(
                "Số dư tài khoản không đủ $%.2f để thực hiện giao dịch",
                amount
        ));
    }
}
