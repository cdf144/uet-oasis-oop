package Week14.Input_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Utils {
    /**
     * Read String content from file.
     *
     * @param path Path to file to be read
     * @return Content String
     * @throws IOException Thrown when FileReader throws a
     *                     FileNotFoundException
     */
    public static String readContentFromFile(String path) throws IOException {
        StringBuilder stringContent = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringContent.append(line);
        }

        bufferedReader.close();

        return stringContent.toString();
    }

    /**
     * Write String content to file.
     *
     * @param content String content to be written to file
     * @param path    Path to file to be written to
     * @throws IOException Thrown when FileWriter throws a
     *                     FileNotFoundException
     */
    public static void writeContentToFile(String content, String path) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));

        fileWriter.write(content);

        fileWriter.close();
    }

    /**
     * Append String content to file.
     *
     * @param content String content to be appended to file
     * @param path    Path to file to be appended to
     * @throws IOException Thrown when FileWriter throws a
     *                     FileNotFoundException
     */
    public static void appendContentToFile(String content, String path) throws IOException {
        String stringContent = readContentFromFile(path) + "\n" + content;
        BufferedWriter fileWriterAppend = new BufferedWriter(new FileWriter(path));

        fileWriterAppend.write(stringContent);

        fileWriterAppend.close();
    }

    /**
     * Find file in folder that has the name queried.
     *
     * @param folderPath Path String to searching folder
     * @param fileName   File name query
     */
    public static File findFileByName(String folderPath, String fileName) {
        File searchFolder = new File(folderPath);
        List<File> filesInFolder = new ArrayList<>(
                Arrays.asList(Objects.requireNonNull(searchFolder.listFiles()))
        );
        if (!filesInFolder.isEmpty()) {
            for (File file : filesInFolder) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }
}
