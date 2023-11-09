package Week16.Banking_System;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
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
        Scanner sc = new Scanner(inputStream);
        String readLine;

        if (sc.hasNextLine()) {
            readLine = sc.nextLine();
        } else {
            return;
        }
        // Loop for reading Customer info
        while (sc.hasNextLine()) {
            assert readLine != null;
            String[] partsCustomer = readLine.split(" ");
            StringBuilder customerName = new StringBuilder();
            long customerId = 0;

            for (String part : partsCustomer) {
                char firstChar = part.charAt(0);
                if (!Character.isDigit(firstChar)) {
                    if (customerName.toString().isEmpty()) {
                        customerName.append(part);
                    } else {
                        customerName.append(" ").append(part);
                    }
                } else {
                    customerId = Long.parseLong(part);
                }
            }

            Customer newCustomer = new Customer(customerId, customerName.toString());
            // Loop for reading the Customer's Account(s)
            while (
                    sc.hasNextLine()
                    && (readLine = sc.nextLine()) != null
                    && Character.isDigit(readLine.charAt(0))
            ) {
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
                    System.err.println(e.toString());
                    return;
                }
            }

            // Check if Customer already exists in CustomerList
            // If so, add the Account(s) to the existing Customer
            int i = 0;
            while (i < customerList.size()) {
                if (customerList.get(i).getIdNumber() == customerId) {
                    for (Account account : newCustomer.getAccountList()) {
                        customerList.get(i).addAccount(account);
                    }
                    break;
                }
                i++;
            }

            // If Customer does not exist in CustomerList
            // Add the Customer along with their account(s)
            if (i == customerList.size()) {
                customerList.add(newCustomer);
            }
        }
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
                    customersInfoByIdOrder.append("\n").append(customer.getCustomerInfo());
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
            StringBuilder customersInfoByNameOrder = new StringBuilder();
            customerList.sort(new NameComparator());
            for (Customer customer : customerList) {
                if (customersInfoByNameOrder.length() == 0) {
                    customersInfoByNameOrder.append(customer.getCustomerInfo());
                } else {
                    customersInfoByNameOrder.append("\n").append(customer.getCustomerInfo());
                }
            }
            return customersInfoByNameOrder.toString();
        } else {
            return "";
        }
    }
}
