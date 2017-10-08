package seedu.address.commons.core;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;

/**
 * Base class for *Manager classes
 *
 * Registers the class' event handlers in eventsCenter
 */
public abstract class ComponentManager {
    protected EventsCenter eventsCenter;

    /**
     * Uses default {@link EventsCenter}
     */
    public ComponentManager() {
        this(EventsCenter.getInstance());
    }

    public ComponentManager(EventsCenter eventsCenter) {
        this.eventsCenter = eventsCenter;
		TemplateClass.instrum("LineNumber: ","21", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ComponentManager", "Class: ","ComponentManager", "VariableName: ","eventsCenter", "VariableName: ","eventsCenter");
        eventsCenter.registerHandler(this);
		TemplateClass.instrum("LineNumber: ","22", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ComponentManager", "Class: ","ComponentManager");
    }

    protected void raise(BaseEvent event) {
        eventsCenter.post(event);
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","raise", "Class: ","ComponentManager");
    }
}
