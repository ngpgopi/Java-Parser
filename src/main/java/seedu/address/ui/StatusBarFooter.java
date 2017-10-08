package seedu.address.ui;

import java.time.Clock;
import java.util.Date;
import java.util.logging.Logger;

import org.controlsfx.control.StatusBar;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.model.AddressBookChangedEvent;

/**
 * A ui for the status bar that is displayed at the footer of the application.
 */
public class StatusBarFooter extends UiPart<Region> {

    public static final String SYNC_STATUS_INITIAL = "Not updated yet in this session";
    public static final String SYNC_STATUS_UPDATED = "Last Updated: %s";

    /**
     * Used to generate time stamps.
     *
     * TODO: change clock to an instance variable.
     * We leave it as a static variable because manual dependency injection
     * will require passing down the clock reference all the way from MainApp,
     * but it should be easier once we have factories/DI frameworks.
     */
    private static Clock clock = Clock.systemDefaultZone();

    private static final Logger logger = LogsCenter.getLogger(StatusBarFooter.class);

    private static final String FXML = "StatusBarFooter.fxml";

    @FXML
    private StatusBar syncStatus;
    @FXML
    private StatusBar saveLocationStatus;


    public StatusBarFooter(String saveLocation) {
        super(FXML);
        setSyncStatus(SYNC_STATUS_INITIAL);
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","StatusBarFooter", "Class: ","StatusBarFooter");
        setSaveLocation("./" + saveLocation);
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","StatusBarFooter", "Class: ","StatusBarFooter");
        registerAsAnEventHandler(this);
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","StatusBarFooter", "Class: ","StatusBarFooter");
    }

    /**
     * Sets the clock used to determine the current time.
     */
    public static void setClock(Clock clock) {
        StatusBarFooter.clock = clock;
		TemplateClass.instrum("LineNumber: ","56", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setClock", "Class: ","StatusBarFooter", "VariableName: ","StatusBarFooter", "VariableName: ","clock", "VariableName: ","clock");
    }

    /**
     * Returns the clock currently in use.
     */
    public static Clock getClock() {
        return clock;
    }

    private void setSaveLocation(String location) {
        Platform.runLater(() -> this.saveLocationStatus.setText(location));
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setSaveLocation", "Class: ","StatusBarFooter");
    }

    private void setSyncStatus(String status) {
        Platform.runLater(() -> this.syncStatus.setText(status));
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setSyncStatus", "Class: ","StatusBarFooter");
    }

    @Subscribe
    public void handleAddressBookChangedEvent(AddressBookChangedEvent abce) {
        long now = clock.millis();
		TemplateClass.instrum("LineNumber: ","76", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StatusBarFooter");
        String lastUpdated = new Date(now).toString();
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StatusBarFooter");
        logger.info(LogsCenter.getEventHandlingLogMessage(abce, "Setting last updated status to " + lastUpdated));
		TemplateClass.instrum("LineNumber: ","78", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StatusBarFooter");
        setSyncStatus(String.format(SYNC_STATUS_UPDATED, lastUpdated));
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleAddressBookChangedEvent", "Class: ","StatusBarFooter");
    }
}
