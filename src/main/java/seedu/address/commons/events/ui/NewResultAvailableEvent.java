package seedu.address.commons.events.ui;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;

/**
 * Indicates that a new result is available.
 */
public class NewResultAvailableEvent extends BaseEvent {

    public final String message;

    public NewResultAvailableEvent(String message) {
        this.message = message;
		TemplateClass.instrum("LineNumber: ","13", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","NewResultAvailableEvent", "Class: ","NewResultAvailableEvent", "VariableName: ","message", "VariableName: ","message");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
