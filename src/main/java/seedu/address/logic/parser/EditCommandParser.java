package seedu.address.logic.parser;

import seedu.address.TemplateClass;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","EditCommandParser", "VariableName: ","ArgumentMultimap", "VariableName: ","argMultimap");

        Index index;
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","EditCommandParser", "VariableName: ","Index", "VariableName: ","index");

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
			TemplateClass.instrum("LineNumber: ","41", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }

        EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();
		TemplateClass.instrum("LineNumber: ","46", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","parse", "Class: ","EditCommandParser", "VariableName: ","EditPersonDescriptor", "VariableName: ","editPersonDescriptor", "VariableName: ","EditPersonDescriptor");
        try {
            ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME)).ifPresent(editPersonDescriptor::setName);
			TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
            ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE)).ifPresent(editPersonDescriptor::setPhone);
			TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
            ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL)).ifPresent(editPersonDescriptor::setEmail);
			TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
            ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS)).ifPresent(editPersonDescriptor::setAddress);
			TemplateClass.instrum("LineNumber: ","51", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
            parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);
			TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","parse", "Class: ","EditCommandParser");
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","parse", "Class: ","EditCommandParser");

        return new EditCommand(index, editPersonDescriptor);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws IllegalValueException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
