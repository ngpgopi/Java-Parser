package seedu.address.storage;

import javax.xml.bind.annotation.XmlValue;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.Tag;

/**
 * JAXB-friendly adapted version of the Tag.
 */
public class XmlAdaptedTag {

    @XmlValue
    private String tagName;

    /**
     * Constructs an XmlAdaptedTag.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedTag() {}

    /**
     * Converts a given Tag into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created
     */
    public XmlAdaptedTag(Tag source) {
        tagName = source.tagName;
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","XmlAdaptedTag", "Class: ","XmlAdaptedTag", "VariableName: ","tagName", "VariableName: ","source", "VariableName: ","tagName");
    }

    /**
     * Converts this jaxb-friendly adapted tag object into the model's Tag object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Tag toModelType() throws IllegalValueException {
        return new Tag(tagName);
    }

}
