package seedu.address.commons.events.model;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;
import seedu.address.model.ReadOnlyAddressBook;

/** Indicates the AddressBook in the model has changed*/
public class AddressBookChangedEvent extends BaseEvent {

    public final ReadOnlyAddressBook data;

    public AddressBookChangedEvent(ReadOnlyAddressBook data) {
        this.data = data;
		TemplateClass.instrum("LineNumber: ","12", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","AddressBookChangedEvent", "Class: ","AddressBookChangedEvent", "VariableName: ","data", "VariableName: ","data");
    }

    @Override
    public String toString() {
        return "number of persons " + data.getPersonList().size() + ", number of tags " + data.getTagList().size();
    }
}
