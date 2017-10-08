package gopiTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import seedu.address.model.person.Address;

public class AddressTest {

    @Test
    public void isValidAddress() {
        // invalid addresses
        assertFalse(Address.isValidAddress("")); // empty string
        assertFalse(Address.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(Address.isValidAddress("2342 W Harrison Street"));
        assertTrue(Address.isValidAddress("/")); // one character
        assertTrue(Address.isValidAddress("2342 W Harrison Street Unit-3 Chicago IL, 60612")); // long address
    }
}
