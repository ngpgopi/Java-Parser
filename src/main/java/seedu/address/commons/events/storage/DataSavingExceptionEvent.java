package seedu.address.commons.events.storage;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;

/**
 * Indicates an exception during a file saving
 */
public class DataSavingExceptionEvent extends BaseEvent {

    public final Exception exception;

    public DataSavingExceptionEvent(Exception exception) {
        this.exception = exception;
		TemplateClass.instrum("LineNumber: ","13", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","DataSavingExceptionEvent", "Class: ","DataSavingExceptionEvent", "VariableName: ","exception", "VariableName: ","exception");
    }

    @Override
    public String toString() {
        return exception.toString();
    }

}
