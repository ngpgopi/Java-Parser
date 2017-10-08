package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Lists all the commands entered by user from the start of app launch.
 */
public class HistoryCommand extends Command {

    public static final String COMMAND_WORD = "history";
    public static final String MESSAGE_SUCCESS = "Entered commands (from most recent to earliest):\n%1$s";
    public static final String MESSAGE_NO_HISTORY = "You have not yet entered any commands.";

    @Override
    public CommandResult execute() {
        List<String> previousCommands = history.getHistory();
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","execute", "Class: ","HistoryCommand");

        if (previousCommands.isEmpty()) {
            return new CommandResult(MESSAGE_NO_HISTORY);
        }
		TemplateClass.instrum("LineNumber: ","25", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","execute", "Class: ","HistoryCommand");

        Collections.reverse(previousCommands);
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","HistoryCommand");
        return new CommandResult(String.format(MESSAGE_SUCCESS, String.join("\n", previousCommands)));
    }

    @Override
    public void setData(Model model, CommandHistory history, UndoRedoStack undoRedoStack) {
        requireNonNull(history);
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","HistoryCommand");
        this.history = history;
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","HistoryCommand", "VariableName: ","history", "VariableName: ","history");
    }
}
