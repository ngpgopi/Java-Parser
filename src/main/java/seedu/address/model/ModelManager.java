package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.TemplateClass;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.model.AddressBookChangedEvent;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

/**
 * Represents the in-memory model of the address book data.
 * All changes to any model should be synchronized.
 */
public class ModelManager extends ComponentManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final FilteredList<ReadOnlyPerson> filteredPersons;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, UserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, userPrefs);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ModelManager", "Class: ","ModelManager");

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ModelManager", "Class: ","ModelManager");

        this.addressBook = new AddressBook(addressBook);
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ModelManager", "Class: ","ModelManager", "VariableName: ","addressBook", "VariableName: ","AddressBook", "VariableName: ","addressBook");
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
		TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ModelManager", "Class: ","ModelManager");
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs());
    }

    @Override
    public void resetData(ReadOnlyAddressBook newData) {
        addressBook.resetData(newData);
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","resetData", "Class: ","ModelManager");
        indicateAddressBookChanged();
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","resetData", "Class: ","ModelManager");
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    /** Raises an event to indicate the model has changed */
    private void indicateAddressBookChanged() {
        raise(new AddressBookChangedEvent(addressBook));
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","indicateAddressBookChanged", "Class: ","ModelManager");
    }

    @Override
    public synchronized void deletePerson(ReadOnlyPerson target) throws PersonNotFoundException {
        addressBook.removePerson(target);
		TemplateClass.instrum("LineNumber: ","64", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","deletePerson", "Class: ","ModelManager");
        indicateAddressBookChanged();
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","deletePerson", "Class: ","ModelManager");
    }

    @Override
    public synchronized void addPerson(ReadOnlyPerson person) throws DuplicatePersonException {
        addressBook.addPerson(person);
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addPerson", "Class: ","ModelManager");
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addPerson", "Class: ","ModelManager");
        indicateAddressBookChanged();
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addPerson", "Class: ","ModelManager");
    }

    @Override
    public void updatePerson(ReadOnlyPerson target, ReadOnlyPerson editedPerson)
            throws DuplicatePersonException, PersonNotFoundException {
        requireAllNonNull(target, editedPerson);
		TemplateClass.instrum("LineNumber: ","78", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","ModelManager");

        addressBook.updatePerson(target, editedPerson);
		TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","ModelManager");
        indicateAddressBookChanged();
		TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","ModelManager");
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code ReadOnlyPerson} backed by the internal list of
     * {@code addressBook}
     */
    @Override
    public ObservableList<ReadOnlyPerson> getFilteredPersonList() {
        return FXCollections.unmodifiableObservableList(filteredPersons);
    }

    @Override
    public void updateFilteredPersonList(Predicate<ReadOnlyPerson> predicate) {
        requireNonNull(predicate);
		TemplateClass.instrum("LineNumber: ","97", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateFilteredPersonList", "Class: ","ModelManager");
        filteredPersons.setPredicate(predicate);
		TemplateClass.instrum("LineNumber: ","98", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateFilteredPersonList", "Class: ","ModelManager");
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","104", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","ModelManager", "VariableName: ","obj");

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","ModelManager", "VariableName: ","obj", "VariableName: ","ModelManager");

        // state check
        ModelManager other = (ModelManager) obj;
		TemplateClass.instrum("LineNumber: ","114", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","ModelManager", "VariableName: ","ModelManager", "VariableName: ","other", "VariableName: ","ModelManager", "VariableName: ","obj");
        return addressBook.equals(other.addressBook)
                && filteredPersons.equals(other.filteredPersons);
    }

}
