package seedu.address.model.person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fxmisc.easybind.EasyBind;
import seedu.address.TemplateClass;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

import java.util.Iterator;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * A list of persons that enforces uniqueness between its elements and does not allow nulls.
 *
 * Supports a minimal set of list operations.
 *
 * @see Person#equals(Object)
 * @see CollectionUtil#elementsAreUnique(Collection)
 */
public class UniquePersonList implements Iterable<Person> {

    private final ObservableList<Person> internalList = FXCollections.observableArrayList();
    // used by asObservableList()
    private final ObservableList<ReadOnlyPerson> mappedList = EasyBind.map(internalList, (person) -> person);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(ReadOnlyPerson toCheck) {
        requireNonNull(toCheck);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","contains", "Class: ","UniquePersonList");
        return internalList.contains(toCheck);
    }

    /**
     * Adds a person to the list.
     *
     * @throws DuplicatePersonException if the person to add is a duplicate of an existing person in the list.
     */
    public void add(ReadOnlyPerson toAdd) throws DuplicatePersonException {
        requireNonNull(toAdd);
		TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","add", "Class: ","UniquePersonList");
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","add", "Class: ","UniquePersonList");
        internalList.add(new Person(toAdd));
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","add", "Class: ","UniquePersonList");
    }

    /**
     * Replaces the person {@code target} in the list with {@code editedPerson}.
     *
     * @throws DuplicatePersonException if the replacement is equivalent to another existing person in the list.
     * @throws PersonNotFoundException if {@code target} could not be found in the list.
     */
    public void setPerson(ReadOnlyPerson target, ReadOnlyPerson editedPerson)
            throws DuplicatePersonException, PersonNotFoundException {
        requireNonNull(editedPerson);
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPerson", "Class: ","UniquePersonList");

        int index = internalList.indexOf(target);
		TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","setPerson", "Class: ","UniquePersonList");
        if (index == -1) {
            throw new PersonNotFoundException();
        }
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setPerson", "Class: ","UniquePersonList", "VariableName: ","index");

        if (!target.equals(editedPerson) && internalList.contains(editedPerson)) {
            throw new DuplicatePersonException();
        }
		TemplateClass.instrum("LineNumber: ","66", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setPerson", "Class: ","UniquePersonList");

        internalList.set(index, new Person(editedPerson));
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPerson", "Class: ","UniquePersonList");
    }

    /**
     * Removes the equivalent person from the list.
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     */
    public boolean remove(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        requireNonNull(toRemove);
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","remove", "Class: ","UniquePersonList");
        final boolean personFoundAndDeleted = internalList.remove(toRemove);
		TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","remove", "Class: ","UniquePersonList");
        if (!personFoundAndDeleted) {
            throw new PersonNotFoundException();
        }
		TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","remove", "Class: ","UniquePersonList", "VariableName: ","personFoundAndDeleted");
        return personFoundAndDeleted;
    }

    public void setPersons(UniquePersonList replacement) {
        this.internalList.setAll(replacement.internalList);
		TemplateClass.instrum("LineNumber: ","88", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPersons", "Class: ","UniquePersonList");
    }

    public void setPersons(List<? extends ReadOnlyPerson> persons) throws DuplicatePersonException {
        final UniquePersonList replacement = new UniquePersonList();
		TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","setPersons", "Class: ","UniquePersonList", "VariableName: ","UniquePersonList", "VariableName: ","replacement", "VariableName: ","UniquePersonList");
        for (final ReadOnlyPerson person : persons) {
            replacement.add(new Person(person));
			TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPersons", "Class: ","UniquePersonList");
        }
        setPersons(replacement);
		TemplateClass.instrum("LineNumber: ","96", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPersons", "Class: ","UniquePersonList");
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<ReadOnlyPerson> asObservableList() {
        return FXCollections.unmodifiableObservableList(mappedList);
    }

    @Override
    public Iterator<Person> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePersonList // instanceof handles nulls
                        && this.internalList.equals(((UniquePersonList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}
