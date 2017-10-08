package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Redo the previously undone command.
 */
public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";
    public static final String MESSAGE_SUCCESS = "Redo success!";
    public static final String MESSAGE_FAILURE = "No more commands to redo!";

    @Override
    public CommandResult execute() throws CommandException {
        requireAllNonNull(model, undoRedoStack);
		TemplateClass.instrum("LineNumber: ","21", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","RedoCommand");

        if (!undoRedoStack.canRedo()) {
            throw new CommandException(MESSAGE_FAILURE);
        }
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","execute", "Class: ","RedoCommand");

        undoRedoStack.popRedo().redo();
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","RedoCommand");
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public void setData(Model model, CommandHistory commandHistory, UndoRedoStack undoRedoStack) {
        this.model = model;
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","RedoCommand", "VariableName: ","model", "VariableName: ","model");
        this.undoRedoStack = undoRedoStack;
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","RedoCommand", "VariableName: ","undoRedoStack", "VariableName: ","undoRedoStack");
    }
}
