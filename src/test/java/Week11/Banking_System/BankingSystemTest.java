package Week11.Banking_System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BankingSystemTest {
    public static void main(String[] args) throws FileNotFoundException {
        Bank bank = new Bank();
        File file = new File("C:\\Users\\Darkroom\\IdeaProjects\\java-oop\\src\\test\\java\\Week11\\Banking_System\\input.txt");

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return;
        }
        bank.readCustomerList(fileInputStream);
        System.out.println(bank.getCustomersInfoByNameOrder());
    }
}
