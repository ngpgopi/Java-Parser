package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.TemplateClass;
import seedu.address.model.person.Person;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .equals comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniquePersonList persons;
    private final UniqueTagList tags;

    /*
     * The 'unusual' code block below is an non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();
        tags = new UniqueTagList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons and Tags in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","AddressBook", "Class: ","AddressBook");
    }

    //// list overwrite operations

    public void setPersons(List<? extends ReadOnlyPerson> persons) throws DuplicatePersonException {
        this.persons.setPersons(persons);
		TemplateClass.instrum("LineNumber: ","55", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setPersons", "Class: ","AddressBook");
    }

    public void setTags(Set<Tag> tags) {
        this.tags.setTags(tags);
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setTags", "Class: ","AddressBook");
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);
        try {
            setPersons(newData.getPersonList());
        } catch (DuplicatePersonException e) {
            assert false : "AddressBooks should not have duplicate persons";
        }

        setTags(new HashSet<>(newData.getTagList()));
        syncMasterTagListWith(persons);
    }

    //// person-level operations

    /**
     * Adds a person to the address book.
     * Also checks the new person's tags and updates {@link #tags} with any new tags found,
     * and updates the Tag objects in the person to point to those in {@link #tags}.
     *
     * @throws DuplicatePersonException if an equivalent person already exists.
     */
    public void addPerson(ReadOnlyPerson p) throws DuplicatePersonException {
        Person newPerson = new Person(p);
		TemplateClass.instrum("LineNumber: ","87", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","addPerson", "Class: ","AddressBook", "VariableName: ","Person", "VariableName: ","newPerson", "VariableName: ","Person", "VariableName: ","p");
        syncMasterTagListWith(newPerson);
		TemplateClass.instrum("LineNumber: ","88", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addPerson", "Class: ","AddressBook");
        // TODO: the tags master list will be updated even though the below line fails.
        // This can cause the tags master list to have additional tags that are not tagged to any person
        // in the person list.
        persons.add(newPerson);
		TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addPerson", "Class: ","AddressBook");
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedReadOnlyPerson}.
     * {@code AddressBook}'s tag list will be updated with the tags of {@code editedReadOnlyPerson}.
     *
     * @throws DuplicatePersonException if updating the person's details causes the person to be equivalent to
     *      another existing person in the list.
     * @throws PersonNotFoundException if {@code target} could not be found in the list.
     *
     * @see #syncMasterTagListWith(Person)
     */
    public void updatePerson(ReadOnlyPerson target, ReadOnlyPerson editedReadOnlyPerson)
            throws DuplicatePersonException, PersonNotFoundException {
        requireNonNull(editedReadOnlyPerson);
		TemplateClass.instrum("LineNumber: ","107", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","AddressBook");

        Person editedPerson = new Person(editedReadOnlyPerson);
		TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","updatePerson", "Class: ","AddressBook", "VariableName: ","Person", "VariableName: ","editedPerson", "VariableName: ","Person", "VariableName: ","editedReadOnlyPerson");
        syncMasterTagListWith(editedPerson);
		TemplateClass.instrum("LineNumber: ","110", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","AddressBook");
        // TODO: the tags master list will be updated even though the below line fails.
        // This can cause the tags master list to have additional tags that are not tagged to any person
        // in the person list.
        persons.setPerson(target, editedPerson);
		TemplateClass.instrum("LineNumber: ","114", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updatePerson", "Class: ","AddressBook");
    }

    /**
     * Ensures that every tag in this person:
     *  - exists in the master list {@link #tags}
     *  - points to a Tag object in the master list
     */
    private void syncMasterTagListWith(Person person) {
        final UniqueTagList personTags = new UniqueTagList(person.getTags());
		TemplateClass.instrum("LineNumber: ","123", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");
        tags.mergeFrom(personTags);
		TemplateClass.instrum("LineNumber: ","124", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");

        // Create map with values = tag object references in the master list
        // used for checking person tag references
        final Map<Tag, Tag> masterTagObjects = new HashMap<>();
		TemplateClass.instrum("LineNumber: ","128", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook", "VariableName: ","Map", "VariableName: ","Tag", "VariableName: ","Tag", "VariableName: ","masterTagObjects", "VariableName: ","HashMap");
        tags.forEach(tag -> masterTagObjects.put(tag, tag));
		TemplateClass.instrum("LineNumber: ","129", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");

        // Rebuild the list of person tags to point to the relevant tags in the master tag list.
        final Set<Tag> correctTagReferences = new HashSet<>();
		TemplateClass.instrum("LineNumber: ","132", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook", "VariableName: ","Set", "VariableName: ","Tag", "VariableName: ","correctTagReferences", "VariableName: ","HashSet");
        personTags.forEach(tag -> correctTagReferences.add(masterTagObjects.get(tag)));
		TemplateClass.instrum("LineNumber: ","133", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");
        person.setTags(correctTagReferences);
		TemplateClass.instrum("LineNumber: ","134", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");
    }

    /**
     * Ensures that every tag in these persons:
     *  - exists in the master list {@link #tags}
     *  - points to a Tag object in the master list
     *  @see #syncMasterTagListWith(Person)
     */
    private void syncMasterTagListWith(UniquePersonList persons) {
        persons.forEach(this::syncMasterTagListWith);
		TemplateClass.instrum("LineNumber: ","144", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","syncMasterTagListWith", "Class: ","AddressBook");
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * @throws PersonNotFoundException if the {@code key} is not in this {@code AddressBook}.
     */
    public boolean removePerson(ReadOnlyPerson key) throws PersonNotFoundException {
        if (persons.remove(key)) {
            return true;
        }
        else {
            throw new PersonNotFoundException();
        }
    }

    //// tag-level operations

    public void addTag(Tag t) throws UniqueTagList.DuplicateTagException {
        tags.add(t);
		TemplateClass.instrum("LineNumber: ","162", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addTag", "Class: ","AddressBook");
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asObservableList().size() + " persons, " + tags.asObservableList().size() +  " tags";
        // TODO: refine later
    }

    @Override
    public ObservableList<ReadOnlyPerson> getPersonList() {
        return persons.asObservableList();
    }

    @Override
    public ObservableList<Tag> getTagList() {
        return tags.asObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && this.persons.equals(((AddressBook) other).persons)
                && this.tags.equalsOrderInsensitive(((AddressBook) other).tags));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(persons, tags);
    }
}
