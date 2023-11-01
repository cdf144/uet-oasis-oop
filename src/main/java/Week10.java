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
            "^\\s*((abstract|public|private|protected|static|final)\\s+)+"
                    + "[\\w<>\\[\\]]+\\s+(\\w+)\\s*"
                    + "\\(([^)]*)\\)",
            Pattern.MULTILINE
    );

    private static final Pattern PACKAGE_PATTERN = Pattern.compile(
            ""
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

//    public static void main(String[] args) throws IOException {
//        StringBuilder content = new StringBuilder();
//        File file;
//        String filename = "src"
//                + File.separator + "main"
//                + File.separator + "java"
//                + File.separator + "test.txt";
//        String workingDir = System.getProperty("user.dir");
//        file = new File(workingDir, filename);
//
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        String line = reader.readLine();
//        while (line != null) {
//            line = reader.readLine();
//            content.append(line).append("\n");
//        }
//
//        System.out.println(getAllFunctions(content.toString()));
//    }
}
