package seedu.address.commons.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.TemplateClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a version with major, minor and patch number
 */
public class Version implements Comparable<Version> {

    public static final String VERSION_REGEX = "V(\\d+)\\.(\\d+)\\.(\\d+)(ea)?";

    private static final String EXCEPTION_STRING_NOT_VERSION = "String is not a valid Version. %s";

    private static final Pattern VERSION_PATTERN = Pattern.compile(VERSION_REGEX);

    private final int major;
    private final int minor;
    private final int patch;
    private final boolean isEarlyAccess;

    public Version(int major, int minor, int patch, boolean isEarlyAccess) {
        this.major = major;
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Version", "Class: ","Version", "VariableName: ","major", "VariableName: ","major");
        this.minor = minor;
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Version", "Class: ","Version", "VariableName: ","minor", "VariableName: ","minor");
        this.patch = patch;
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Version", "Class: ","Version", "VariableName: ","patch", "VariableName: ","patch");
        this.isEarlyAccess = isEarlyAccess;
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Version", "Class: ","Version", "VariableName: ","isEarlyAccess", "VariableName: ","isEarlyAccess");
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public boolean isEarlyAccess() {
        return isEarlyAccess;
    }

    /**
     * Parses a version number string in the format V1.2.3.
     * @param versionString version number string
     * @return a Version object
     */
    @JsonCreator
    public static Version fromString(String versionString) throws IllegalArgumentException {
        Matcher versionMatcher = VERSION_PATTERN.matcher(versionString);
		TemplateClass.instrum("LineNumber: ","55", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","fromString", "Class: ","Version");

        if (!versionMatcher.find()) {
            throw new IllegalArgumentException(String.format(EXCEPTION_STRING_NOT_VERSION, versionString));
        }
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","fromString", "Class: ","Version");

        return new Version(Integer.parseInt(versionMatcher.group(1)),
                Integer.parseInt(versionMatcher.group(2)),
                Integer.parseInt(versionMatcher.group(3)),
                versionMatcher.group(4) == null ? false : true);
    }

    @JsonValue
    public String toString() {
        return String.format("V%d.%d.%d%s", major, minor, patch, isEarlyAccess ? "ea" : "");
    }

    @Override
    public int compareTo(Version other) {
        if (this.major != other.major) {
            return this.major - other.major;
        }
		TemplateClass.instrum("LineNumber: ","74", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","compareTo", "Class: ","Version", "VariableName: ","major", "VariableName: ","other", "VariableName: ","major");
        if (this.minor != other.minor) {
            return this.minor - other.minor;
        }
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","compareTo", "Class: ","Version", "VariableName: ","minor", "VariableName: ","other", "VariableName: ","minor");
        if (this.patch != other.patch) {
            return this.patch - other.patch;
        }
		TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","compareTo", "Class: ","Version", "VariableName: ","patch", "VariableName: ","other", "VariableName: ","patch");
        if (this.isEarlyAccess == other.isEarlyAccess()) {
            return 0;
        }
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","compareTo", "Class: ","Version");
        if (this.isEarlyAccess) {
            return -1;
        }
		TemplateClass.instrum("LineNumber: ","86", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","compareTo", "Class: ","Version", "VariableName: ","isEarlyAccess");
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Version", "VariableName: ","obj");
        if (!(obj instanceof Version)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","97", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Version", "VariableName: ","obj", "VariableName: ","Version");
        final Version other = (Version) obj;
		TemplateClass.instrum("LineNumber: ","100", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","Version", "VariableName: ","Version", "VariableName: ","other", "VariableName: ","Version", "VariableName: ","obj");

        return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        String hash = String.format("%03d%03d%03d", major, minor, patch);
		TemplateClass.instrum("LineNumber: ","107", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","hashCode", "Class: ","Version");
        if (!isEarlyAccess) {
            hash = "1" + hash;
			TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","hashCode", "Class: ","Version", "VariableName: ","hash", "VariableName: ","hash");
        }
		TemplateClass.instrum("LineNumber: ","108", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","hashCode", "Class: ","Version", "VariableName: ","isEarlyAccess");
        return Integer.parseInt(hash);
    }
}
