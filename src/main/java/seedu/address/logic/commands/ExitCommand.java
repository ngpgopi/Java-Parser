package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.ExitAppRequestEvent;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute() {
        EventsCenter.getInstance().post(new ExitAppRequestEvent());
		TemplateClass.instrum("LineNumber: ","17", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","ExitCommand");
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT);
    }

}