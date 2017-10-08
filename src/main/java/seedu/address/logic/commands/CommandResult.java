package seedu.address.logic.commands;

import seedu.address.TemplateClass;

import static java.util.Objects.requireNonNull;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    public final String feedbackToUser;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
		TemplateClass.instrum("LineNumber: ","13", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","CommandResult", "Class: ","CommandResult");
    }

}
