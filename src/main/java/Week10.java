import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {
    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "^import\\s+(static\\s+)?([\\w.]+(\\.\\*)?\\s*;)$",
            Pattern.MULTILINE
    );

    private static final Pattern METHOD_PATTERN = Pattern.compile(
            "^\\s*((abstract|public|private|protected)\\s+)+static\\s+(final\\s+)*"
                    + "[\\w<>\\[\\]]+\\s+(\\w+)\\s*"
                    + "\\(([^)]*)\\)",
            Pattern.MULTILINE
    );

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

    public static List<String> getAllFunctions(String fileContent) {
        List<String> importList = getImportList(fileContent);
        List<String> allFunctions = new ArrayList<>();

        Matcher matcher = METHOD_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String methodName = matcher.group(4); // (\\w+)
            String[] params = matcher.group(5).split(", "); // ([^)]*)
            StringBuilder paramTypes = new StringBuilder();
            String function;

            if (!params[0].isEmpty()) {
                for (String param : params) {
                    String paramType = param.trim().split(" ")[0];
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
