package seedu.address.ui;

import java.net.URL;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.web.WebView;
import seedu.address.MainApp;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * The Browser Panel of the App.
 */
public class BrowserPanel extends UiPart<Region> {

    public static final String DEFAULT_PAGE = "default.html";
    public static final String GOOGLE_SEARCH_URL_PREFIX = "https://www.google.com.sg/search?safe=off&q=";
    public static final String GOOGLE_SEARCH_URL_SUFFIX = "&cad=h";

    private static final String FXML = "BrowserPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    @FXML
    private WebView browser;

    public BrowserPanel() {
        super(FXML);

        // To prevent triggering events for typing inside the loaded Web page.
        getRoot().setOnKeyPressed(Event::consume);
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","BrowserPanel", "Class: ","BrowserPanel");

        loadDefaultPage();
		TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","BrowserPanel", "Class: ","BrowserPanel");
        registerAsAnEventHandler(this);
		TemplateClass.instrum("LineNumber: ","41", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","BrowserPanel", "Class: ","BrowserPanel");
    }

    private void loadPersonPage(ReadOnlyPerson person) {
        loadPage(GOOGLE_SEARCH_URL_PREFIX + person.getName().fullName.replaceAll(" ", "+")
                + GOOGLE_SEARCH_URL_SUFFIX);
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","loadPersonPage", "Class: ","BrowserPanel");
    }

    public void loadPage(String url) {
        Platform.runLater(() -> browser.getEngine().load(url));
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","loadPage", "Class: ","BrowserPanel");
    }

    /**
     * Loads a default HTML file with a background that matches the general theme.
     */
    private void loadDefaultPage() {
        URL defaultPage = MainApp.class.getResource(FXML_FILE_FOLDER + DEFAULT_PAGE);
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","loadDefaultPage", "Class: ","BrowserPanel");
        loadPage(defaultPage.toExternalForm());
		TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","loadDefaultPage", "Class: ","BrowserPanel");
    }

    /**
     * Frees resources allocated to the browser.
     */
    public void freeResources() {
        browser = null;
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","freeResources", "Class: ","BrowserPanel", "VariableName: ","browser");
    }

    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handlePersonPanelSelectionChangedEvent", "Class: ","BrowserPanel");
        loadPersonPage(event.getNewSelection().person);
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handlePersonPanelSelectionChangedEvent", "Class: ","BrowserPanel");
    }
}
