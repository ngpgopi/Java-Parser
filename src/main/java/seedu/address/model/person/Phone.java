package seedu.address.model.person;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {


    public static final String MESSAGE_PHONE_CONSTRAINTS =
            "Phone numbers can only contain numbers, and should be at least 3 digits long";
    public static final String PHONE_VALIDATION_REGEX = "\\d{3,}";
    public final String value;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Phone(String phone) throws IllegalValueException {
        requireNonNull(phone);
		TemplateClass.instrum("LineNumber: ","25", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Phone", "Class: ","Phone");
        String trimmedPhone = phone.trim();
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","Phone", "Class: ","Phone");
        if (!isValidPhone(trimmedPhone)) {
            throw new IllegalValueException(MESSAGE_PHONE_CONSTRAINTS);
        }
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","Phone", "Class: ","Phone");
        this.value = trimmedPhone;
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Phone", "Class: ","Phone", "VariableName: ","value", "VariableName: ","trimmedPhone");
    }

    /**
     * Returns true if a given string is a valid person phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(PHONE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
