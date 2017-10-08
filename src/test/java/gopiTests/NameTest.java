package gopiTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import seedu.address.model.person.Name;

public class NameTest {

    @Test
    public void isValidName() {
        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("GKN*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Name.isValidName("Gopi Krishnan")); // alphabets only
        assertTrue(Name.isValidName("1255")); // numbers only
        assertTrue(Name.isValidName("Gopi the 3rd")); // alphanumeric characters
        assertTrue(Name.isValidName("GOPI KRISHNAN")); // with capital letters
        assertTrue(Name.isValidName("Gopi KRishnan NArasimha Guptha")); // long names
    }
}
