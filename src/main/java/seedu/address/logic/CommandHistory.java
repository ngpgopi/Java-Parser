package seedu.address.logic;

import seedu.address.TemplateClass;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Stores the history of commands executed.
 */
public class CommandHistory {
    private LinkedList<String> userInputHistory;

    public CommandHistory() {
        userInputHistory = new LinkedList<>();
		TemplateClass.instrum("LineNumber: ","15", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","CommandHistory", "Class: ","CommandHistory", "VariableName: ","userInputHistory", "VariableName: ","LinkedList");
    }

    /**
     * Appends {@code userInput} to the list of user input entered.
     */
    public void add(String userInput) {
        requireNonNull(userInput);
		TemplateClass.instrum("LineNumber: ","22", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","add", "Class: ","CommandHistory");
        userInputHistory.add(userInput);
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","add", "Class: ","CommandHistory");
    }

    /**
     * Returns a defensive copy of {@code userInputHistory}.
     */
    public List<String> getHistory() {
        return new LinkedList<>(userInputHistory);
    }
}
