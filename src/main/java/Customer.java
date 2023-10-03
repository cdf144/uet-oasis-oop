import Week9.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

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

    public String getCustomerInfo() {
        StringBuilder customerInfo = new StringBuilder();
        customerInfo.append(String.format("%s %d",
                this.fullName,
                this.idNumber)
        );
        for (Account account : accountList) {

        }
        return customerInfo.toString();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        for (Account accountCompare : this.accountList) {
            if (Objects.equals(accountCompare, account)) {
                this.accountList.remove(accountCompare);
                break;
            }
        }
    }
}
