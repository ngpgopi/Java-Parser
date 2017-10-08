package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email {

    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    public final String value;

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email) throws IllegalValueException {
        requireNonNull(email);
		TemplateClass.instrum("LineNumber: ","25", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Email", "Class: ","Email");
        String trimmedEmail = email.trim();
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","Email", "Class: ","Email");
        if (!isValidEmail(trimmedEmail)) {
            throw new IllegalValueException(MESSAGE_EMAIL_CONSTRAINTS);
        }
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","Email", "Class: ","Email");
        this.value = trimmedEmail;
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Email", "Class: ","Email", "VariableName: ","value", "VariableName: ","trimmedEmail");
    }

    /**
     * Returns if a given string is a valid person email.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(EMAIL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
