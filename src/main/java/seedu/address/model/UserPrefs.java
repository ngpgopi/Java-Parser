package seedu.address.model;

import java.util.Objects;

import seedu.address.TemplateClass;
import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs {

    private GuiSettings guiSettings;
    private String addressBookFilePath = "data/addressbook.xml";
    private String addressBookName = "MyAddressBook";

    public UserPrefs() {
        this.setGuiSettings(500, 500, 0, 0);
		TemplateClass.instrum("LineNumber: ","17", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UserPrefs", "Class: ","UserPrefs");
    }

    public GuiSettings getGuiSettings() {
        return guiSettings == null ? new GuiSettings() : guiSettings;
    }

    public void updateLastUsedGuiSetting(GuiSettings guiSettings) {
        this.guiSettings = guiSettings;
		TemplateClass.instrum("LineNumber: ","25", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateLastUsedGuiSetting", "Class: ","UserPrefs", "VariableName: ","guiSettings", "VariableName: ","guiSettings");
    }

    public void setGuiSettings(double width, double height, int x, int y) {
        guiSettings = new GuiSettings(width, height, x, y);
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setGuiSettings", "Class: ","UserPrefs", "VariableName: ","guiSettings", "VariableName: ","GuiSettings", "VariableName: ","width", "VariableName: ","height", "VariableName: ","x", "VariableName: ","y");
    }

    public String getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(String addressBookFilePath) {
        this.addressBookFilePath = addressBookFilePath;
		TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAddressBookFilePath", "Class: ","UserPrefs", "VariableName: ","addressBookFilePath", "VariableName: ","addressBookFilePath");
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAddressBookName", "Class: ","UserPrefs", "VariableName: ","addressBookName", "VariableName: ","addressBookName");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","UserPrefs", "VariableName: ","other");
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }
		TemplateClass.instrum("LineNumber: ","53", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","UserPrefs", "VariableName: ","other", "VariableName: ","UserPrefs");

        UserPrefs o = (UserPrefs) other;
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","UserPrefs", "VariableName: ","UserPrefs", "VariableName: ","o", "VariableName: ","UserPrefs", "VariableName: ","other");

        return Objects.equals(guiSettings, o.guiSettings)
                && Objects.equals(addressBookFilePath, o.addressBookFilePath)
                && Objects.equals(addressBookName, o.addressBookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath, addressBookName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toString", "Class: ","UserPrefs", "VariableName: ","StringBuilder", "VariableName: ","sb", "VariableName: ","StringBuilder");
        sb.append("Gui Settings : " + guiSettings.toString());
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","UserPrefs");
        sb.append("\nLocal data file location : " + addressBookFilePath);
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","UserPrefs");
        sb.append("\nAddressBook name : " + addressBookName);
		TemplateClass.instrum("LineNumber: ","74", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","UserPrefs");
        return sb.toString();
    }

}
