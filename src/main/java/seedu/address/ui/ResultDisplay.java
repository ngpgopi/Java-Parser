package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.NewResultAvailableEvent;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final Logger logger = LogsCenter.getLogger(ResultDisplay.class);
    private static final String FXML = "ResultDisplay.fxml";

    private final StringProperty displayed = new SimpleStringProperty("");

    @FXML
    private TextArea resultDisplay;

    public ResultDisplay() {
        super(FXML);
        resultDisplay.textProperty().bind(displayed);
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ResultDisplay", "Class: ","ResultDisplay");
        registerAsAnEventHandler(this);
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ResultDisplay", "Class: ","ResultDisplay");
    }

    @Subscribe
    private void handleNewResultAvailableEvent(NewResultAvailableEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleNewResultAvailableEvent", "Class: ","ResultDisplay");
        Platform.runLater(() -> displayed.setValue(event.message));
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleNewResultAvailableEvent", "Class: ","ResultDisplay");
    }

}
