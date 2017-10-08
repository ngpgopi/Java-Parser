package seedu.address.storage;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import seedu.address.TemplateClass;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.model.AddressBookChangedEvent;
import seedu.address.commons.events.storage.DataSavingExceptionEvent;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager extends ComponentManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private UserPrefsStorage userPrefsStorage;


    public StorageManager(AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","StorageManager", "Class: ","StorageManager", "VariableName: ","addressBookStorage", "VariableName: ","addressBookStorage");
        this.userPrefsStorage = userPrefsStorage;
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","StorageManager", "Class: ","StorageManager", "VariableName: ","userPrefsStorage", "VariableName: ","userPrefsStorage");
    }

    // ================ UserPrefs methods ==============================

    @Override
    public String getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(UserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveUserPrefs", "Class: ","StorageManager");
    }


    // ================ AddressBook methods ==============================

    @Override
    public String getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(String filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readAddressBook", "Class: ","StorageManager");
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","StorageManager");
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, String filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
		TemplateClass.instrum("LineNumber: ","76", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","StorageManager");
        addressBookStorage.saveAddressBook(addressBook, filePath);
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","StorageManager");
    }


    @Override
    @Subscribe
    public void handleAddressBookChangedEvent(AddressBookChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event, "Local data changed, saving to file"));
		TemplateClass.instrum("LineNumber: ","84", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StorageManager");
        try {
            saveAddressBook(event.data);
			TemplateClass.instrum("LineNumber: ","86", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StorageManager");
        } catch (IOException e) {
            raise(new DataSavingExceptionEvent(e));
			TemplateClass.instrum("LineNumber: ","88", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StorageManager");
        }
    }

}
