package seedu.address.logic.parser;

import seedu.address.TemplateClass;
import seedu.address.logic.commands.*;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parseCommand", "Class: ","AddressBookParser");
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
		TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","parseCommand", "Class: ","AddressBookParser");

        final String commandWord = matcher.group("commandWord");
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parseCommand", "Class: ","AddressBookParser");
        final String arguments = matcher.group("arguments");
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parseCommand", "Class: ","AddressBookParser");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:{
            return new AddCommandParser().parse(arguments);}

        case EditCommand.COMMAND_WORD:{
            return new EditCommandParser().parse(arguments);}

        case SelectCommand.COMMAND_WORD:{
            return new SelectCommandParser().parse(arguments);}

        case DeleteCommand.COMMAND_WORD:{
            return new DeleteCommandParser().parse(arguments);}

        case ClearCommand.COMMAND_WORD:{
            return new ClearCommand();}

        case FindCommand.COMMAND_WORD:{
            return new FindCommandParser().parse(arguments);}

        case ListCommand.COMMAND_WORD:{
            return new ListCommand();}

        case HistoryCommand.COMMAND_WORD:{
            return new HistoryCommand();}

        case ExitCommand.COMMAND_WORD:{
            return new ExitCommand();}

        case HelpCommand.COMMAND_WORD:{
            return new HelpCommand();}

        case UndoCommand.COMMAND_WORD:{
            return new UndoCommand();}

        case RedoCommand.COMMAND_WORD:{
            return new RedoCommand();}

        default:{
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
    }}

