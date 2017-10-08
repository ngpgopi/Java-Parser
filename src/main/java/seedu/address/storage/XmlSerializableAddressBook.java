package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.tag.Tag;

/**
 * An Immutable AddressBook that is serializable to XML format
 */
@XmlRootElement(name = "addressbook")
public class XmlSerializableAddressBook implements ReadOnlyAddressBook {

    @XmlElement
    private List<XmlAdaptedPerson> persons;
    @XmlElement
    private List<XmlAdaptedTag> tags;

    /**
     * Creates an empty XmlSerializableAddressBook.
     * This empty constructor is required for marshalling.
     */
    public XmlSerializableAddressBook() {
        persons = new ArrayList<>();
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlSerializableAddressBook", "Class: ","XmlSerializableAddressBook", "VariableName: ","persons", "VariableName: ","ArrayList");
        tags = new ArrayList<>();
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlSerializableAddressBook", "Class: ","XmlSerializableAddressBook", "VariableName: ","tags", "VariableName: ","ArrayList");
    }

    /**
     * Conversion
     */
    public XmlSerializableAddressBook(ReadOnlyAddressBook src) {
        this();
        persons.addAll(src.getPersonList().stream().map(XmlAdaptedPerson::new).collect(Collectors.toList()));
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlSerializableAddressBook", "Class: ","XmlSerializableAddressBook");
        tags.addAll(src.getTagList().stream().map(XmlAdaptedTag::new).collect(Collectors.toList()));
		TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlSerializableAddressBook", "Class: ","XmlSerializableAddressBook");
    }

    @Override
    public ObservableList<ReadOnlyPerson> getPersonList() {
        final ObservableList<ReadOnlyPerson> persons = this.persons.stream().map(p -> {
            try {
                return p.toModelType();
            } catch (IllegalValueException e) {
                e.printStackTrace();
				TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getPersonList", "Class: ","XmlSerializableAddressBook");
                //TODO: better error handling
                return null;
            }
        }).collect(Collectors.toCollection(FXCollections::observableArrayList));
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getPersonList", "Class: ","XmlSerializableAddressBook");
        return FXCollections.unmodifiableObservableList(persons);
    }

    @Override
    public ObservableList<Tag> getTagList() {
        final ObservableList<Tag> tags = this.tags.stream().map(t -> {
            try {
                return t.toModelType();
            } catch (IllegalValueException e) {
                e.printStackTrace();
				TemplateClass.instrum("LineNumber: ","66", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getTagList", "Class: ","XmlSerializableAddressBook");
                //TODO: better error handling
                return null;
            }
        }).collect(Collectors.toCollection(FXCollections::observableArrayList));
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getTagList", "Class: ","XmlSerializableAddressBook");
        return FXCollections.unmodifiableObservableList(tags);
    }

}
