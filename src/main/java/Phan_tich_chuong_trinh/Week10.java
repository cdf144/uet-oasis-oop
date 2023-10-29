package Phan_tich_chuong_trinh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class to parse a Java file with imports, class/interface/enum declarations,
 * and methods (with or without parameters)
 */
public class Week10 {
    // The MULTILINE flags are used to match the start and end of each line in the input string.

    /*
     * Matches any line that starts with 'import', followed by an optional 'static', followed
     * by 1 or more word charactersor dots, optionally followed by a dot and an asterisk
     * (import all) and ends with semicolon, all separated by 1 or more whitespace characters.
     */
    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "^import\\s+(static\\s+)?([\\w.]+(\\.\\*)?\\s*;)$",
            Pattern.MULTILINE
    );

    /*
     * Matches any line that starts with one or more of the keywords, separated by one or more
     * whitespace characters, followed by the return type of the method, followed by one or more
     * whitespace characters, followed by the name of the method, followed by zero or more
     * whitespace characters, followed by an opening parenthesis, followed by zero or more
     * parameters separated by commas, followed by a closing parenthesis.
     *
     * This RegEx also skips all constructors (constructors don't have return types)
     */
    private static final Pattern METHOD_PATTERN = Pattern.compile(
            "^\\s*((abstract|public|private|protected|static|final)\\s+)+"
                    + "[\\w<>\\[\\]]+\\s+(\\w+)\\s*"
                    + "\\(([^)]*)\\)",
            Pattern.MULTILINE
    );

    /**
     * Method to get a list of imports.
     *
     * @param fileContent File content String
     * @return List of imports
     */
    public static List<String> getImportList(String fileContent) {
        List<String> importList = new ArrayList<>();

        Matcher matcher = IMPORT_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            importList.add(
                    fileContent.substring(matcher.start(), matcher.end()).trim()
            );
        }

        return importList;
    }

    /**
     * Get a list of functions (methods) and its parameters' type from a Java source file.
     *
     * @param fileContent Java source file's content
     * @return List of functions (methods) and its parameters' type
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> importList = getImportList(fileContent);
        List<String> allFunctions = new ArrayList<>();

        Matcher matcher = METHOD_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String methodName = matcher.group(3); // (\\w+)
            String[] params = matcher.group(4).split(", "); // ([^)]*)
            StringBuilder paramTypes = new StringBuilder();
            String function;

            if (!params[0].isEmpty()) {
                for (String param : params) {
                    String paramType = param.split(" ")[0];
                    for (String imported : importList) {
                        if (imported.contains(paramType) && !imported.contains("static")) {
                            // Without 'import' and ending ';'
                            paramType = imported.substring(7, imported.length() - 1);
                        }
                    }
                    paramTypes.append(paramType).append(",");
                }

                function = methodName
                        + "("
                        + paramTypes.substring(0, paramTypes.length() - 1)
                        + ")";
            } else {
                function = methodName + "()";
            }

            allFunctions.add(function);
        }

        return allFunctions;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        File file;
        String filename = "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "Phan_tich_chuong_trinh"
                + File.separator + "test.txt";
        String workingDir = System.getProperty("user.dir");
        file = new File(workingDir, filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            line = reader.readLine();
            content.append(line).append("\n");
        }

        System.out.println(getAllFunctions(content.toString()));
    }
}
