package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.model.AddressBook;

import static java.util.Objects.requireNonNull;

/**
 * Clears the address book.
 */
public class ClearCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult executeUndoableCommand() {
        requireNonNull(model);
		TemplateClass.instrum("LineNumber: ","18", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","executeUndoableCommand", "Class: ","ClearCommand");
        model.resetData(new AddressBook());
		TemplateClass.instrum("LineNumber: ","19", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","executeUndoableCommand", "Class: ","ClearCommand");
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
