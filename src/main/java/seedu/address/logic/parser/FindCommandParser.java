package seedu.address.logic.parser;

import seedu.address.TemplateClass;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;

import java.util.Arrays;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
		TemplateClass.instrum("LineNumber: ","22", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","FindCommandParser");
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","parse", "Class: ","FindCommandParser");

        String[] nameKeywords = trimmedArgs.split("\\s+");
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","FindCommandParser");

        return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
