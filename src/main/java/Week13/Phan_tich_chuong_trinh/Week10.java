package Week13.Phan_tich_chuong_trinh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {
    private static final Pattern PACKAGE_PATTERN = Pattern.compile(
            "^package\\s+(.*);$",
            Pattern.MULTILINE
    );

    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "^import\\s+(?:static\\s+)?((?:\\w+\\.)+(\\w+));$",
            Pattern.MULTILINE
    );

    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "^(?:\\s{2})*(?:(?:abstract|public|private|protected|static|final)\\s+)*"
                    + "(class|interface|enum)\\s+([^<\\s]+)([^{]+)?\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Pattern STATIC_METHOD_PATTERN = Pattern.compile(
            "^(?<!\\s{0,20}/\\*\\n)" // Negative lookbehind
                    + "(?:\\s{2})+(?:(?:public|private|protected)\\s+)*"
                    + "static\\s+(?:final\\s+)?[\\w<>,.?\\[\\]\\s]+\\s+(\\w+)"
                    + "\\s*\\(([\\w<>,.?\\[\\]\\s]*)\\)\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Map<String, String> dataTypeMap = new HashMap<>();

    /**
     * Convert from normal data type string to full type.
     * @param dataType data type string
     * @return full type string
     */
    private static String toFullType(String dataType) {
        if (dataTypeMap.containsKey(dataType)) {
            return dataTypeMap.get(dataType);
        } else if (dataType.matches("[A-Z]\\w+")) {
            return "java.lang." + dataType;
        } else if (dataType.contains("<")) {
            String[] parts = dataType.split("<");
            parts[0] = toFullType(parts[0]);
            parts[1] = toFullType(parts[1].replace(">", ""));

            return String.format(
                    "%s<%s>",
                    parts[0],
                    parts[1]
            );
        } else {
            return dataType;
        }
    }

    /**
     * Get all static method signatures from a Java program.
     * @param fileContent Java program file content
     * @return List of all static method signatures from a Java program.
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> allMethods = new ArrayList<>();

        String packageName = "";
        Matcher matcher = PACKAGE_PATTERN.matcher(fileContent);
        if (matcher.find()) {
            packageName = matcher.group(1);
        }

        matcher = IMPORT_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String fullImport = matcher.group(1);
            String nameImport = matcher.group(2);
            dataTypeMap.put(nameImport, fullImport);
        }

        matcher = CLASS_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String className = matcher.group(2);
            dataTypeMap.put(className, packageName + "." + className);
        }

        matcher = STATIC_METHOD_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String methodName = matcher.group(1);

            String allParams = matcher.group(2);
            StringBuilder allTypes = new StringBuilder();
            allTypes.append("(");

            if (!allParams.isEmpty()) {
                allParams = allParams.replaceAll("\\.{3}", "");
                allParams = allParams.replace("\n", "").trim();

                String[] params = allParams.split(", ");
                for (int i = 0; i < params.length; i++) {
                    params[i] = toFullType(params[i].split(" ")[0]);
                }

                for (String param : params) {
                    allTypes.append(param).append(",");
                }

                allTypes.deleteCharAt(allTypes.length() - 1);
            }

            allTypes.append(")");
            allMethods.add(methodName + allTypes.toString());
        }

        return allMethods;
    }
}
