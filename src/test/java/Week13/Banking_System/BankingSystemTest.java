package Week13.Banking_System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BankingSystemTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        File file;
        String filename = "src"
                + File.separator + "test"
                + File.separator + "java"
                + File.separator + "Week13"
                + File.separator + "Banking_System"
                + File.separator + "input.txt";

        String workingDir = System.getProperty("user.dir");
        file = new File(workingDir, filename);

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
            return;
        }
        try {
            bank.readCustomerList(fileInputStream);
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        System.out.println(bank.getCustomersInfoByNameOrder());
        System.out.println();
        System.out.println(bank.getCustomersInfoByIdOrder());
    }
}
