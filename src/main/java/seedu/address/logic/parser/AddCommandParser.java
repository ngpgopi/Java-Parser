package seedu.address.logic.parser;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.Set;
import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser", "VariableName: ","ArgumentMultimap", "VariableName: ","argMultimap");

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","parse", "Class: ","AddCommandParser");

        try {
            Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME)).get();
			TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser");
            Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE)).get();
			TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser");
            Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL)).get();
			TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser");
            Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS)).get();
			TemplateClass.instrum("LineNumber: ","46", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser");
            Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
			TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser");

            ReadOnlyPerson person = new Person(name, phone, email, address, tagList);
			TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","AddCommandParser", "VariableName: ","ReadOnlyPerson", "VariableName: ","person", "VariableName: ","Person", "VariableName: ","name", "VariableName: ","phone", "VariableName: ","email", "VariableName: ","address", "VariableName: ","tagList");

            return new AddCommand(person);
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
