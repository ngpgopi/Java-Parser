package seedu.address.commons.util;

import seedu.address.TemplateClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Writes and reads files
 */
public class FileUtil {

    private static final String CHARSET = "UTF-8";

    public static boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories.
     * @throws IOException if the file or directory cannot be created.
     */
    public static void createIfMissing(File file) throws IOException {
        if (!isFileExists(file)) {
            createFile(file);
			TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createIfMissing", "Class: ","FileUtil");
        }
		TemplateClass.instrum("LineNumber: ","25", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","createIfMissing", "Class: ","FileUtil");
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories
     *
     * @return true if file is created, false if file already exists
     */
    public static boolean createFile(File file) throws IOException {
        if (file.exists()) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","createFile", "Class: ","FileUtil");

        createParentDirsOfFile(file);
		TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createFile", "Class: ","FileUtil");

        return file.createNewFile();
    }

    /**
     * Creates the given directory along with its parent directories
     *
     * @param dir the directory to be created; assumed not null
     * @throws IOException if the directory or a parent directory cannot be created
     */
    public static void createDirs(File dir) throws IOException {
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Failed to make directories of " + dir.getName());
        }
		TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","createDirs", "Class: ","FileUtil");
    }

    /**
     * Creates parent directories of file if it has a parent directory
     */
    public static void createParentDirsOfFile(File file) throws IOException {
        File parentDir = file.getParentFile();
		TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","createParentDirsOfFile", "Class: ","FileUtil");

        if (parentDir != null) {
            createDirs(parentDir);
			TemplateClass.instrum("LineNumber: ","64", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createParentDirsOfFile", "Class: ","FileUtil");
        }
		TemplateClass.instrum("LineNumber: ","63", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","createParentDirsOfFile", "Class: ","FileUtil", "VariableName: ","parentDir");
    }

    /**
     * Assumes file exists
     */
    public static String readFromFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), CHARSET);
    }

    /**
     * Writes given string to a file.
     * Will create the file if it does not exist yet.
     */
    public static void writeToFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(CHARSET));
		TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","writeToFile", "Class: ","FileUtil");
    }

    /**
     * Converts a string to a platform-specific file path
     * @param pathWithForwardSlash A String representing a file path but using '/' as the separator
     * @return {@code pathWithForwardSlash} but '/' replaced with {@code File.separator}
     */
    public static String getPath(String pathWithForwardSlash) {
        checkArgument(pathWithForwardSlash.contains("/"));
		TemplateClass.instrum("LineNumber: ","89", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getPath", "Class: ","FileUtil");
        return pathWithForwardSlash.replace("/", File.separator);
    }

}
