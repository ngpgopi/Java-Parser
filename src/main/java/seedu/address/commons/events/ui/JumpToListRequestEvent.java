package seedu.address.commons.events.ui;

import seedu.address.TemplateClass;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.BaseEvent;

/**
 * Indicates a request to jump to the list of persons
 */
public class JumpToListRequestEvent extends BaseEvent {

    public final int targetIndex;

    public JumpToListRequestEvent(Index targetIndex) {
        this.targetIndex = targetIndex.getZeroBased();
		TemplateClass.instrum("LineNumber: ","14", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","JumpToListRequestEvent", "Class: ","JumpToListRequestEvent");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
