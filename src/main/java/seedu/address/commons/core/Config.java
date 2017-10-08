package seedu.address.commons.core;

import seedu.address.TemplateClass;

import java.util.Objects;
import java.util.logging.Level;

/**
 * Config values used by the app
 */
public class Config {

    public static final String DEFAULT_CONFIG_FILE = "config.json";

    // Config values customizable through config file
    private String appTitle = "Address App";
    private Level logLevel = Level.INFO;
    private String userPrefsFilePath = "preferences.json";

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAppTitle", "Class: ","Config", "VariableName: ","appTitle", "VariableName: ","appTitle");
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setLogLevel", "Class: ","Config", "VariableName: ","logLevel", "VariableName: ","logLevel");
    }

    public String getUserPrefsFilePath() {
        return userPrefsFilePath;
    }

    public void setUserPrefsFilePath(String userPrefsFilePath) {
        this.userPrefsFilePath = userPrefsFilePath;
		TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setUserPrefsFilePath", "Class: ","Config", "VariableName: ","userPrefsFilePath", "VariableName: ","userPrefsFilePath");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Config", "VariableName: ","other");
        if (!(other instanceof Config)) { //this handles null as well.
            return false;
        }
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Config", "VariableName: ","other", "VariableName: ","Config");

        Config o = (Config) other;
		TemplateClass.instrum("LineNumber: ","51", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","Config", "VariableName: ","Config", "VariableName: ","o", "VariableName: ","Config", "VariableName: ","other");

        return Objects.equals(appTitle, o.appTitle)
                && Objects.equals(logLevel, o.logLevel)
                && Objects.equals(userPrefsFilePath, o.userPrefsFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appTitle, logLevel, userPrefsFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toString", "Class: ","Config", "VariableName: ","StringBuilder", "VariableName: ","sb", "VariableName: ","StringBuilder");
        sb.append("App title : " + appTitle);
		TemplateClass.instrum("LineNumber: ","66", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","Config");
        sb.append("\nCurrent log level : " + logLevel);
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","Config");
        sb.append("\nPreference file Location : " + userPrefsFilePath);
		TemplateClass.instrum("LineNumber: ","68", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","Config");
        return sb.toString();
    }

}
