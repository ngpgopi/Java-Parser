package seedu.address.commons.core;

import com.google.common.eventbus.EventBus;
import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;

import java.util.logging.Logger;

/**
 * Manages the event dispatching of the app.
 */
public class EventsCenter {
    private static final Logger logger = LogsCenter.getLogger(EventsCenter.class);
    private static EventsCenter instance;
    private final EventBus eventBus;

    private EventsCenter() {
        eventBus = new EventBus();
		TemplateClass.instrum("LineNumber: ","18", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","EventsCenter", "Class: ","EventsCenter", "VariableName: ","eventBus", "VariableName: ","EventBus");
    }

    public static EventsCenter getInstance() {
        if (instance == null) {
            instance = new EventsCenter();
			TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getInstance", "Class: ","EventsCenter", "VariableName: ","instance", "VariableName: ","EventsCenter");
        }
		TemplateClass.instrum("LineNumber: ","22", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","getInstance", "Class: ","EventsCenter", "VariableName: ","instance");
        return instance;
    }

    public static void clearSubscribers() {
        instance = null;
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","clearSubscribers", "Class: ","EventsCenter", "VariableName: ","instance");
    }

    public void registerHandler(Object handler) {
        eventBus.register(handler);
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","registerHandler", "Class: ","EventsCenter");
    }

    /**
     * Posts an event to the event bus.
     */
    public <E extends BaseEvent> EventsCenter post(E event) {
        logger.info("------[Event Posted] " + event.getClass().getCanonicalName() + ": " + event.toString());
		TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","post", "Class: ","EventsCenter");
        eventBus.post(event);
		TemplateClass.instrum("LineNumber: ","41", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","post", "Class: ","EventsCenter");
        return this;
    }

}
