package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String ADDRESS_VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address) throws IllegalValueException {
        requireNonNull(address);
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Address", "Class: ","Address");
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","Address", "Class: ","Address");
        this.value = address;
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Address", "Class: ","Address", "VariableName: ","value", "VariableName: ","address");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
