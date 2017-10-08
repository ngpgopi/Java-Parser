package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.tag.Tag;

/**
 * JAXB-friendly version of the Person.
 */
public class XmlAdaptedPerson {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String phone;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String address;

    @XmlElement
    private List<XmlAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs an XmlAdaptedPerson.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedPerson() {}


    /**
     * Converts a given Person into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedPerson
     */
    public XmlAdaptedPerson(ReadOnlyPerson source) {
        name = source.getName().fullName;
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson");
        phone = source.getPhone().value;
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson");
        email = source.getEmail().value;
		TemplateClass.instrum("LineNumber: ","51", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson");
        address = source.getAddress().value;
		TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson");
        tagged = new ArrayList<>();
		TemplateClass.instrum("LineNumber: ","53", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson", "VariableName: ","tagged", "VariableName: ","ArrayList");
        for (Tag tag : source.getTags()) {
            tagged.add(new XmlAdaptedTag(tag));
			TemplateClass.instrum("LineNumber: ","55", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedPerson", "Class: ","XmlAdaptedPerson");
        }
    }

    /**
     * Converts this jaxb-friendly adapted person object into the model's Person object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","List", "VariableName: ","Tag", "VariableName: ","personTags", "VariableName: ","ArrayList");
        for (XmlAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
			TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson");
        }
        final Name name = new Name(this.name);
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","Name", "VariableName: ","name", "VariableName: ","Name", "VariableName: ","name");
        final Phone phone = new Phone(this.phone);
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","Phone", "VariableName: ","phone", "VariableName: ","Phone", "VariableName: ","phone");
        final Email email = new Email(this.email);
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","Email", "VariableName: ","email", "VariableName: ","Email", "VariableName: ","email");
        final Address address = new Address(this.address);
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","Address", "VariableName: ","address", "VariableName: ","Address", "VariableName: ","address");
        final Set<Tag> tags = new HashSet<>(personTags);
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toModelType", "Class: ","XmlAdaptedPerson", "VariableName: ","Set", "VariableName: ","Tag", "VariableName: ","tags", "VariableName: ","HashSet", "VariableName: ","personTags");
        return new Person(name, phone, email, address, tags);
    }
}
