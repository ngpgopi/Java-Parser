package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.FileUtil;
import seedu.address.model.ReadOnlyAddressBook;

/**
 * A class to access AddressBook data stored as an xml file on the hard disk.
 */
public class XmlAddressBookStorage implements AddressBookStorage {

    private static final Logger logger = LogsCenter.getLogger(XmlAddressBookStorage.class);

    private String filePath;

    public XmlAddressBookStorage(String filePath) {
        this.filePath = filePath;
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAddressBookStorage", "Class: ","XmlAddressBookStorage", "VariableName: ","filePath", "VariableName: ","filePath");
    }

    public String getAddressBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(filePath);
    }

    /**
     * Similar to {@link #readAddressBook()}
     * @param filePath location of the data. Cannot be null
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyAddressBook> readAddressBook(String filePath) throws DataConversionException,
                                                                                 FileNotFoundException {
        requireNonNull(filePath);
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readAddressBook", "Class: ","XmlAddressBookStorage");

        File addressBookFile = new File(filePath);
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","readAddressBook", "Class: ","XmlAddressBookStorage", "VariableName: ","File", "VariableName: ","addressBookFile", "VariableName: ","File", "VariableName: ","filePath");

        if (!addressBookFile.exists()) {
            logger.info("AddressBook file "  + addressBookFile + " not found");
			TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readAddressBook", "Class: ","XmlAddressBookStorage");
            return Optional.empty();
        }
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","readAddressBook", "Class: ","XmlAddressBookStorage");

        ReadOnlyAddressBook addressBookOptional = XmlFileStorage.loadDataFromSaveFile(new File(filePath));
		TemplateClass.instrum("LineNumber: ","54", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","readAddressBook", "Class: ","XmlAddressBookStorage");

        return Optional.of(addressBookOptional);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, filePath);
		TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage");
    }

    /**
     * Similar to {@link #saveAddressBook(ReadOnlyAddressBook)}
     * @param filePath location of the data. Cannot be null
     */
    public void saveAddressBook(ReadOnlyAddressBook addressBook, String filePath) throws IOException {
        requireNonNull(addressBook);
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage");
        requireNonNull(filePath);
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage");

        File file = new File(filePath);
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage", "VariableName: ","File", "VariableName: ","file", "VariableName: ","File", "VariableName: ","filePath");
        FileUtil.createIfMissing(file);
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage");
        XmlFileStorage.saveDataToFile(file, new XmlSerializableAddressBook(addressBook));
		TemplateClass.instrum("LineNumber: ","74", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveAddressBook", "Class: ","XmlAddressBookStorage");
    }

}
