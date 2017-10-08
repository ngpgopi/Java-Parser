package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Represents a command which can be undone and redone.
 */
public abstract class UndoableCommand extends Command {
    private ReadOnlyAddressBook previousAddressBook;

    protected abstract CommandResult executeUndoableCommand() throws CommandException;

    /**
     * Stores the current state of {@code model#addressBook}.
     */
    private void saveAddressBookSnapshot() {
        requireNonNull(model);
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBookSnapshot", "Class: ","UndoableCommand");
        this.previousAddressBook = new AddressBook(model.getAddressBook());
		TemplateClass.instrum("LineNumber: ","24", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBookSnapshot", "Class: ","UndoableCommand");
    }

    /**
     * Reverts the AddressBook to the state before this command
     * was executed and updates the filtered person list to
     * show all persons.
     */
    protected final void undo() {
        requireAllNonNull(model, previousAddressBook);
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","undo", "Class: ","UndoableCommand");
        model.resetData(previousAddressBook);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","undo", "Class: ","UndoableCommand");
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","undo", "Class: ","UndoableCommand");
    }

    /**
     * Executes the command and updates the filtered person
     * list to show all persons.
     */
    protected final void redo() {
        requireNonNull(model);
		TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","redo", "Class: ","UndoableCommand");
        try {
            executeUndoableCommand();
			TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","redo", "Class: ","UndoableCommand");
        } catch (CommandException ce) {
            throw new AssertionError("The command has been successfully executed previously; "
                    + "it should not fail now");
        }
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","redo", "Class: ","UndoableCommand");
    }

    @Override
    public final CommandResult execute() throws CommandException {
        saveAddressBookSnapshot();
		TemplateClass.instrum("LineNumber: ","55", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","UndoableCommand");
        return executeUndoableCommand();
    }
}
