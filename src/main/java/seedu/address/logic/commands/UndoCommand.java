package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Undo the previous {@code UndoableCommand}.
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_SUCCESS = "Undo success!";
    public static final String MESSAGE_FAILURE = "No more commands to undo!";

    @Override
    public CommandResult execute() throws CommandException {
        requireAllNonNull(model, undoRedoStack);
		TemplateClass.instrum("LineNumber: ","21", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","UndoCommand");

        if (!undoRedoStack.canUndo()) {
            throw new CommandException(MESSAGE_FAILURE);
        }
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","execute", "Class: ","UndoCommand");

        undoRedoStack.popUndo().undo();
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","UndoCommand");
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public void setData(Model model, CommandHistory commandHistory, UndoRedoStack undoRedoStack) {
        this.model = model;
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","UndoCommand", "VariableName: ","model", "VariableName: ","model");
        this.undoRedoStack = undoRedoStack;
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setData", "Class: ","UndoCommand", "VariableName: ","undoRedoStack", "VariableName: ","undoRedoStack");
    }
}
