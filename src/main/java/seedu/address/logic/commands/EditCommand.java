package seedu.address.logic.commands;

import seedu.address.TemplateClass;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.*;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tag.Tag;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final Index index;
    private final EditPersonDescriptor editPersonDescriptor;

    /**
     * @param index of the person in the filtered person list to edit
     * @param editPersonDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditPersonDescriptor editPersonDescriptor) {
        requireNonNull(index);
		TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditCommand", "Class: ","EditCommand");
        requireNonNull(editPersonDescriptor);
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditCommand", "Class: ","EditCommand");

        this.index = index;
		TemplateClass.instrum("LineNumber: ","64", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditCommand", "Class: ","EditCommand", "VariableName: ","index", "VariableName: ","index");
        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditCommand", "Class: ","EditCommand", "VariableName: ","editPersonDescriptor", "VariableName: ","EditPersonDescriptor", "VariableName: ","editPersonDescriptor");
    }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        List<ReadOnlyPerson> lastShownList = model.getFilteredPersonList();
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");

        ReadOnlyPerson personToEdit = lastShownList.get(index.getZeroBased());
		TemplateClass.instrum("LineNumber: ","76", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");
        Person editedPerson = createEditedPerson(personToEdit, editPersonDescriptor);
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");

        try {
            model.updatePerson(personToEdit, editedPerson);
			TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");
        } catch (DuplicatePersonException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        } catch (PersonNotFoundException pnfe) {
            throw new AssertionError("The target person cannot be missing");
        }
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
		TemplateClass.instrum("LineNumber: ","86", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","executeUndoableCommand", "Class: ","EditCommand");
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, editedPerson));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static Person createEditedPerson(ReadOnlyPerson personToEdit,
                                             EditPersonDescriptor editPersonDescriptor) {
        assert personToEdit != null;

        Name updatedName = editPersonDescriptor.getName().orElse(personToEdit.getName());
        Phone updatedPhone = editPersonDescriptor.getPhone().orElse(personToEdit.getPhone());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(personToEdit.getEmail());
        Address updatedAddress = editPersonDescriptor.getAddress().orElse(personToEdit.getAddress());
        Set<Tag> updatedTags = editPersonDescriptor.getTags().orElse(personToEdit.getTags());

        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedTags);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","110", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","EditCommand", "VariableName: ","other");

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","115", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","EditCommand", "VariableName: ","other", "VariableName: ","EditCommand");

        // state check
        EditCommand e = (EditCommand) other;
		TemplateClass.instrum("LineNumber: ","120", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","EditCommand", "VariableName: ","EditCommand", "VariableName: ","e", "VariableName: ","EditCommand", "VariableName: ","other");
        return index.equals(e.index)
                && editPersonDescriptor.equals(e.editPersonDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private Phone phone;
        private Email email;
        private Address address;
        private Set<Tag> tags;

        public EditPersonDescriptor() {}

        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            this.name = toCopy.name;
			TemplateClass.instrum("LineNumber: ","139", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditPersonDescriptor", "Class: ","EditPersonDescriptor", "VariableName: ","name", "VariableName: ","toCopy", "VariableName: ","name");
            this.phone = toCopy.phone;
			TemplateClass.instrum("LineNumber: ","140", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditPersonDescriptor", "Class: ","EditPersonDescriptor", "VariableName: ","phone", "VariableName: ","toCopy", "VariableName: ","phone");
            this.email = toCopy.email;
			TemplateClass.instrum("LineNumber: ","141", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditPersonDescriptor", "Class: ","EditPersonDescriptor", "VariableName: ","email", "VariableName: ","toCopy", "VariableName: ","email");
            this.address = toCopy.address;
			TemplateClass.instrum("LineNumber: ","142", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditPersonDescriptor", "Class: ","EditPersonDescriptor", "VariableName: ","address", "VariableName: ","toCopy", "VariableName: ","address");
            this.tags = toCopy.tags;
			TemplateClass.instrum("LineNumber: ","143", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EditPersonDescriptor", "Class: ","EditPersonDescriptor", "VariableName: ","tags", "VariableName: ","toCopy", "VariableName: ","tags");
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(this.name, this.phone, this.email, this.address, this.tags);
        }

        public void setName(Name name) {
            this.name = name;
			TemplateClass.instrum("LineNumber: ","154", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setName", "Class: ","EditPersonDescriptor", "VariableName: ","name", "VariableName: ","name");
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
			TemplateClass.instrum("LineNumber: ","162", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPhone", "Class: ","EditPersonDescriptor", "VariableName: ","phone", "VariableName: ","phone");
        }

        public Optional<Phone> getPhone() {
            return Optional.ofNullable(phone);
        }

        public void setEmail(Email email) {
            this.email = email;
			TemplateClass.instrum("LineNumber: ","170", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setEmail", "Class: ","EditPersonDescriptor", "VariableName: ","email", "VariableName: ","email");
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setAddress(Address address) {
            this.address = address;
			TemplateClass.instrum("LineNumber: ","178", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAddress", "Class: ","EditPersonDescriptor", "VariableName: ","address", "VariableName: ","address");
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setTags(Set<Tag> tags) {
            this.tags = tags;
			TemplateClass.instrum("LineNumber: ","186", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setTags", "Class: ","EditPersonDescriptor", "VariableName: ","tags", "VariableName: ","tags");
        }

        public Optional<Set<Tag>> getTags() {
            return Optional.ofNullable(tags);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }
			TemplateClass.instrum("LineNumber: ","196", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","EditPersonDescriptor", "VariableName: ","other");

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }
			TemplateClass.instrum("LineNumber: ","201", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","EditPersonDescriptor", "VariableName: ","other", "VariableName: ","EditPersonDescriptor");

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;
			TemplateClass.instrum("LineNumber: ","206", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","EditPersonDescriptor", "VariableName: ","EditPersonDescriptor", "VariableName: ","e", "VariableName: ","EditPersonDescriptor", "VariableName: ","other");

            return getName().equals(e.getName())
                    && getPhone().equals(e.getPhone())
                    && getEmail().equals(e.getEmail())
                    && getAddress().equals(e.getAddress())
                    && getTags().equals(e.getTags());
        }
    }
}
