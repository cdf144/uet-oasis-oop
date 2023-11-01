import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTest {
    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "^(?:\\s{4})*(?:(?:abstract|public|private|protected|static|final)\\s)*"
            + "(class|interface|enum)\\s([^<\\s]+)"
            + "([^{]+)?\\{",
            Pattern.MULTILINE
    );

    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        File file;
        String filename = "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "PathUtils.txt";
        String workingDir = System.getProperty("user.dir");
        file = new File(workingDir, filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            line = reader.readLine();
            content.append(line).append("\n");
        }

        Matcher matcher = CLASS_PATTERN.matcher(content);
        while (matcher.find()) {
            String type = matcher.group(1);
            String className = matcher.group(2);
            System.out.println(type + " " + className);
        }
    }
}
