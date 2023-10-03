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
     * Read from inputStream
     * @param inputStream input stream
     * @throws IOException when readLine fails
     */
    public void readCustomerList(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = "";
        while ((readLine = bufferedReader.readLine()) != null) {
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
            Customer newCustomer = new Customer(customerId, customerName.toString()));
            while ((readLine = bufferedReader.readLine()) != null
                    && Character.isDigit(readLine.charAt(0))) {
                String[] partsAccount = readLine.split(" ");
                long accountId = Long.parseLong(partsAccount[0]);
                String operation = partsAccount[1];
                double amount = Double.parseDouble(partsAccount[2]);
                newCustomer.addAccount(new Account());
            }
        }
    }
}
