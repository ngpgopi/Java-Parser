package seedu.address.logic.commands;

import seedu.address.TemplateClass;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";


    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
		TemplateClass.instrum("LineNumber: ","17", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","ListCommand");
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
