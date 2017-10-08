package seedu.address.commons.events.ui;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;
import seedu.address.ui.PersonCard;

/**
 * Represents a selection change in the Person List Panel
 */
public class PersonPanelSelectionChangedEvent extends BaseEvent {


    private final PersonCard newSelection;

    public PersonPanelSelectionChangedEvent(PersonCard newSelection) {
        this.newSelection = newSelection;
		TemplateClass.instrum("LineNumber: ","15", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonPanelSelectionChangedEvent", "Class: ","PersonPanelSelectionChangedEvent", "VariableName: ","newSelection", "VariableName: ","newSelection");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public PersonCard getNewSelection() {
        return newSelection;
    }
}
