package Week11.Banking_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
  private List<Customer> customerList;

  public Bank() {
    this.customerList = new ArrayList<>();
  }

  /**
   * Check if customer list is empty.
   *
   * @return boolean isNotEmpty
   */
  public boolean isNotEmpty() {
    if (this.customerList == null) {
      this.customerList = new ArrayList<>();
    }
    return !this.customerList.isEmpty();
  }

  /**
   * Read from inputStream.
   *
   * @param inputStream input stream
   */
  public void readCustomerList(InputStream inputStream) {
    BufferedReader bufferedReader
            = new BufferedReader(new InputStreamReader(inputStream));
    String readLine;
    try {
      readLine = bufferedReader.readLine();
    } catch (IOException e) {
      return;
    }
    while (readLine != null) {
      String[] partsCustomer = readLine.split(" ");
      StringBuilder customerName = new StringBuilder();
      long customerId = 0;
      for (String part : partsCustomer) {
        char firstChar = part.charAt(0);
        if (!Character.isDigit(firstChar)) {
          if (Objects.equals(customerName.toString(), "")) {
            customerName.append(part);
          } else {
            customerName.append(" ").append(part);
          }
        } else {
          customerId = Long.parseLong(part);
        }
      }
      Customer newCustomer = new Customer(customerId, customerName.toString());
      try {
        readLine = bufferedReader.readLine();
      } catch (IOException e) {
        return;
      }
      while (readLine != null
              && Character.isDigit(readLine.charAt(0))) {
        String[] partsAccount = readLine.split(" ");
        long accountId = Long.parseLong(partsAccount[0]);
        String operation = partsAccount[1];
        double balance = Double.parseDouble(partsAccount[2]);
        try {
          if (Objects.equals(operation, Account.CHECKING)) {
            newCustomer.addAccount(new CheckingAccount(accountId, balance));
          } else if (Objects.equals(operation, Account.SAVINGS)) {
            newCustomer.addAccount(new SavingsAccount(accountId, balance));
          } else {
            throw new IllegalArgumentException();
          }
        } catch (IllegalArgumentException e) {
          return;
        }
        try {
          readLine = bufferedReader.readLine();
        } catch (IOException e) {
          return;
        }
      }
      int i = 0;
      while (i < customerList.size()) {
        if (customerList.get(i).getIdNumber()
                == customerId) {
          for (int j = 0;
               j < newCustomer.getAccountList().size(); j++) {
            customerList.get(i)
                    .addAccount(newCustomer.getAccountList().get(j));
          }
          break;
        }
        i++;
      }
      if (i == customerList.size()) {
        this.customerList.add(newCustomer);
      }
    }
  }

  public List<Customer> getCustomerList() {
    return this.customerList;
  }

  /**
   * Get customer info by order of ID.
   *
   * @return customer list string
   */
  public String getCustomersInfoByIdOrder() {
    if (this.isNotEmpty()) {
      StringBuilder customersInfoByIdOrder = new StringBuilder();
      customerList.sort(new IdComparator());
      for (Customer customer : customerList) {
        if (customersInfoByIdOrder.length() == 0) {
          customersInfoByIdOrder.append(customer.getCustomerInfo());
        } else {
          customersInfoByIdOrder.append("\n")
                  .append(customer.getCustomerInfo());
        }
      }
      return customersInfoByIdOrder.toString();
    } else {
      return "";
    }
  }

  /**
   * Get customer info by order of Name.
   *
   * @return customer list string
   */
  public String getCustomersInfoByNameOrder() {
    if (this.isNotEmpty()) {
      StringBuilder customersInfoByIdOrder = new StringBuilder();
      customerList.sort(new NameComparator());
      for (Customer customer : customerList) {
        if (customersInfoByIdOrder.length() == 0) {
          customersInfoByIdOrder.append(customer.getCustomerInfo());
        } else {
          customersInfoByIdOrder.append("\n")
                  .append(customer.getCustomerInfo());
        }
      }
      return customersInfoByIdOrder.toString();
    } else {
      return "";
    }
  }
}
