package Week14.Input_Output;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UtilsTest {
    private static final String PATH = "src"
            + File.separator + "test"
            + File.separator + "java"
            + File.separator + "Week14"
            + File.separator + "Input_Output"
            + File.separator;

    @Test
    public void testReadContentFromFile() throws IOException {
        String filePath = PATH + "test-file.txt";
        String expectedContent = "This is the content of the test file.";
        writeContentToFile(expectedContent, filePath);

        String actualContent = Utils.readContentFromFile(filePath);

        assertEquals(expectedContent, actualContent);
    }

    @Test
    public void testWriteContentToFile() throws IOException {
        String filePath = PATH + "test-file.txt";
        String content = "Test content to be written.";
        Utils.writeContentToFile(content, filePath);

        String actualContent = Utils.readContentFromFile(filePath);

        assertEquals(content, actualContent);
    }

    @Test
    public void testAppendContentToFile() throws IOException {
        String filePath = PATH + "test-file.txt";
        String existingContent = "Existing content.";
        String contentToAppend = "Content to be appended.";
        writeContentToFile(existingContent, filePath);

        Utils.appendContentToFile(contentToAppend, filePath);
        Utils.appendContentToFile(contentToAppend, filePath);

        String actualContent = Utils.readContentFromFile(filePath);

        assertEquals(
                existingContent + "\n" + contentToAppend + "\n" + contentToAppend,
                actualContent
        );
    }

    @Test
    public void testFindFileByName() throws IOException {
        String fileName = "test-file.txt";
        File expectedFile = new File(PATH, fileName);
        assert expectedFile.exists() || expectedFile.createNewFile();
        File actualFile = Utils.findFileByName(PATH, fileName);

        assertEquals(expectedFile, actualFile);
    }

    @Test
    public void testFindNonExistentFileByName() {
        String fileName = "non-existent-file.txt";
        File actualFile = Utils.findFileByName(PATH, fileName);

        assertNull(actualFile);
    }

    private void writeContentToFile(String content, String filePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}

