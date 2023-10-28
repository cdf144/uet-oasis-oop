package Week13.Banking_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private long idNumber;
    private String fullName;
    private final List<Account> accountList;

    /**
     * Customer constructor 1.
     */
    public Customer() {
        this.idNumber = 0;
        this.fullName = "";
        this.accountList = new ArrayList<>();
    }

    /**
     * Customer constructor 2.
     *
     * @param idNumber id number
     * @param fullName full name
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.accountList = new ArrayList<>();
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Get customer info.
     *
     * @return Customer info string
     */
    public String getCustomerInfo() {
        return String.format(
                "Số CMND: %d." + " Họ tên: %s.",
                this.idNumber,
                this.fullName
        );
    }

    /**
     * Add account.
     *
     * @param account account
     */
    public void addAccount(Account account) {
        for (Account accountCompare : accountList) {
            if (accountCompare.equals(account)) {
                accountCompare = account;
                return;
            }
        }
        accountList.add(account);
    }

    /**
     * Remove account from customer account list.
     *
     * @param account account to remove
     */
    public void removeAccount(Account account) {
        for (Account accountCompare : this.accountList) {
            if (Objects.equals(accountCompare, account)) {
                this.accountList.remove(accountCompare);
                break;
            }
        }
    }
}
