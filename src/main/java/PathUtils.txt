package com.nordstrom.common.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/**
 * This utility class provides a {@link #getNextPath(Path, String, String) getNextPath} method to acquire the next file
 * path in sequence for the specified base name and extension in the indicated target folder.  If the target folder
 * already contains at least one file that matches the specified base name and extension, the algorithm used to select
 * the next path will always return a path whose index is one more than the highest index that currently exists. (If a
 * single file with no index is found, its implied index is 0.)
 * <br><br>
 * <b>Example usage of {@code getNextPath}</b>
 * <pre>
 *     ...
 *
 *     /*
 *      * This example gets the next path in sequence for base name `artifact`
 *      * and extension `txt` in the TestNG output directory.
 *      *
 *      * For purposes of this example, the output directory already contains
 *      * the following files: `artifact.txt`, `artifact-3.txt`
 *      *&#47;
 *
 *     Path collectionPath = Paths.get(testContext.getOutputDirectory());
 *     // =&gt; C:\git\my-project\test-output\Default suite
 *
 *     Path artifactPath;
 *     try {
 *         artifactPath = PathUtils.getNextPath(collectionPath, "artifact", "txt");
 *         // =&gt; C:\git\my-project\test-output\Default suite\artifact-4.txt
 *     } catch (IOException e) {
 *         provider.getLogger().info("Unable to get output path; no artifact was captured", e);
 *         return;
 *     }
 *
 *     ...
 * </pre>
 */
public final class PathUtils {

    private PathUtils() {
        throw new AssertionError("PathUtils is a static utility class that cannot be instantiated");
    }

    private static final String SUREFIRE_PATH = "surefire-reports";
    private static final String FAILSAFE_PATH = "failsafe-reports";

    /**
     * This enumeration contains methods to help build proxy subclass names and select reports directories.
     */
    public enum ReportsDirectory {

        SUREFIRE_1("(Test)(.*)", SUREFIRE_PATH),
        SUREFIRE_2("(.*)(Test)", SUREFIRE_PATH),
        SUREFIRE_3("(.*)(Tests)", SUREFIRE_PATH),
        SUREFIRE_4("(.*)(TestCase)", SUREFIRE_PATH),
        FAILSAFE_1("(IT)(.*)", FAILSAFE_PATH),
        FAILSAFE_2("(.*)(IT)", FAILSAFE_PATH),
        FAILSAFE_3("(.*)(ITCase)", FAILSAFE_PATH),
        ARTIFACT(".*", "artifact-capture");

        private String regex;
        private String folder;

        ReportsDirectory(String regex, String folder) {
            this.regex = regex;
            this.folder = folder;
        }

        /**
         * Get the regular expression that matches class names for this constant.
         *
         * @return class-matching regular expression string
         */
        public String getRegEx() {
            return regex;
        }

        /**
         * Get the name of the folder associated with this constant.
         *
         * @return class-related folder name
         */
        public String getFolder() {
            return folder;
        }

        /**
         * Get the resolved Maven-derived path associated with this constant.
         *
         * @param subdirs optional sub-path
         * @return Maven folder path
         */
        public Path getPath(String... subdirs) {
            return getTargetPath().resolve(Paths.get(folder, subdirs));
        }

        /**
         * Get the reports directory constant for the specified test class object.
         *
         * @param obj test class object
         * @return reports directory constant
         */
        public static ReportsDirectory fromObject(Object obj) {
            String name = obj.getClass().getSimpleName();
            for (ReportsDirectory constant : values()) {
                if (name.matches(constant.regex)) {
                    return constant;
                }
            }
            throw new IllegalStateException("Someone removed the 'default' pattern from this enumeration");
        }

        /**
         * Get reports directory path for the specified test class object.
         *
         * @param obj test class object
         * @return reports directory path
         */
        public static Path getPathForObject(Object obj) {
            String[] subdirs = {};
            if (obj instanceof PathModifier) {
            	String message = String.format("Null path modifier returned by: %s", obj.getClass().getName());
                subdirs = Objects.requireNonNull(((PathModifier) obj).getSubPath(), message);
            }
            return fromObject(obj).getPath(subdirs);
        }

        /**
         * Get the path for the 'target' folder of the current project.
         *
         * @return path for project 'target' folder
         */
        private static Path getTargetPath() {
            return Paths.get(getBaseDir()).resolve("target");
        }
    }

    /**
     * Get the next available path in sequence for the specified base name and extension in the specified folder.
     *
     * @param targetPath path to target directory for the next available path in sequence
     * @param baseName base name for the path sequence
     * @param extension extension for the path sequence
     * @return the next available path in sequence
     * @throws IOException if an I/O error is thrown when accessing the starting file.
     */
    public static Path getNextPath(Path targetPath, String baseName, String extension) throws IOException {
        Objects.requireNonNull(targetPath, "[targetPath] must be non-null");
        Objects.requireNonNull(baseName, "[baseName] must be non-null");
        Objects.requireNonNull(extension, "[extension] must be non-null");

        File targetFile = targetPath.toFile();
        if ( ! (targetFile.exists() && targetFile.isDirectory())) {
            throw new IllegalArgumentException("[targetPath] must specify an existing directory");
        }
        if (baseName.isEmpty()) {
            throw new IllegalArgumentException("[baseName] must specify a non-empty string");
        }
        if (extension.isEmpty()) {
            throw new IllegalArgumentException("[extension] must specify a non-empty string");
        }

        Visitor visitor = new Visitor(baseName, extension);
        Files.walkFileTree(targetPath, EnumSet.noneOf(FileVisitOption.class), 1, visitor);

        return targetPath.resolve(visitor.getNewName());
    }

    /**
     * Get project base directory.
     *
     * @return project base directory
     */
    public static String getBaseDir() {
        Path currentRelativePath = Paths.get(System.getProperty("user.dir"));
        return currentRelativePath.toAbsolutePath().toString();
    }

    private static class Visitor implements FileVisitor<Path> {

        private String baseName;
        private String extension;
        private int base, ext;
        private PathMatcher pathMatcher;
        private List<Integer> intList = new ArrayList<>();

        Visitor(String baseName, String extension) {
            this.baseName = baseName;
            this.extension = extension;
            this.base = baseName.length();
            this.ext = extension.length() + 1;
            this.pathMatcher = FileSystems.getDefault().getPathMatcher("regex:\\Q" + baseName + "\\E(-\\d+)?\\." + extension);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile() && pathMatcher.matches(file.getFileName())) {
                String name = file.getFileName().toString();
                String iStr = "0" + name.substring(base, name.length() - ext);
                iStr = iStr.replace("0-", "");
                intList.add(Integer.valueOf(iStr) + 1);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        public String getNewName() {
            String newName;

            if (intList.isEmpty()) {
                newName = baseName + "." + extension;
            } else {
                Collections.sort(intList, Collections.reverseOrder());
                newName = baseName + "-" + intList.get(0) + "." + extension;
            }

            return newName;
        }
    }

    /**
     * Prepend the specified string to the indicated array.
     *
     * @param prefix string to be prepended
     * @param strings target string array
     * @return target array prefixed with the specified string
     */
    public static String[] prepend(String prefix, String... strings) {
        int len = strings.length;
        String[] temp = new String[len + 1];
        if (len > 0) System.arraycopy(strings, 0, temp, 1, len);
        temp[0] = prefix;
        return temp;
    }

    /**
     * Append the specified string to the indicated array.
     *
     * @param suffix string to be appended
     * @param strings target string array
     * @return target array with the specified string appended
     */
    public static String[] append(String suffix, String... strings) {
        int len = strings.length;
        String[] temp = new String[len + 1];
        if (len > 0) System.arraycopy(strings, 0, temp, 0, len);
        temp[len] = suffix;
        return temp;
    }

    /**
     * Classes that implement this interface are called to supply additional elements for the path returned by
     * {@link ReportsDirectory#getPathForObject(Object)}. This enables the implementing class to partition artifacts
     * based on scenario-specific criteria.
     */
    public interface PathModifier {

        /**
         * Get scenario-specific path modifier for {@link ReportsDirectory#getPathForObject(Object)}.
         *
         * @return scenario-specific path modifier
         */
        public String[] getSubPath();

    }

}
