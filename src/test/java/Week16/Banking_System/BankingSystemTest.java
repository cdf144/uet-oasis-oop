package Week16.Banking_System;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class BankingSystemTest {
    @Test
    public void BankTest() {
        Bank bank = new Bank();

        File file;
        String filename = "src"
                + File.separator + "test"
                + File.separator + "java"
                + File.separator + "Week16"
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

        bank.readCustomerList(fileInputStream);

        String expected = "Số CMND: 123456788. Họ tên: Hoàng Văn C.\n"
                + "Số CMND: 123456787. Họ tên: Lê Hoàng B.\n"
                + "Số CMND: 123456790. Họ tên: Nguyễn Thị A.";
        assertEquals(expected, bank.getCustomersInfoByNameOrder());

        expected = "Số CMND: 123456787. Họ tên: Lê Hoàng B.\n"
                + "Số CMND: 123456788. Họ tên: Hoàng Văn C.\n"
                + "Số CMND: 123456790. Họ tên: Nguyễn Thị A.";
        assertEquals(expected, bank.getCustomersInfoByIdOrder());
    }
}
