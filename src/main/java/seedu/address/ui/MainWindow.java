package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.TemplateClass;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.ExitAppRequestEvent;
import seedu.address.commons.events.ui.ShowHelpRequestEvent;
import seedu.address.commons.util.FxViewUtil;
import seedu.address.logic.Logic;
import seedu.address.model.UserPrefs;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Region> {

    private static final String ICON = "/images/address_book_32.png";
    private static final String FXML = "MainWindow.fxml";
    private static final int MIN_HEIGHT = 600;
    private static final int MIN_WIDTH = 450;

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private BrowserPanel browserPanel;
    private PersonListPanel personListPanel;
    private Config config;
    private UserPrefs prefs;

    @FXML
    private StackPane browserPlaceholder;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private StackPane personListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusbarPlaceholder;

    public MainWindow(Stage primaryStage, Config config, UserPrefs prefs, Logic logic) {
        super(FXML);

        // Set dependencies
        this.primaryStage = primaryStage;
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow", "VariableName: ","primaryStage", "VariableName: ","primaryStage");
        this.logic = logic;
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow", "VariableName: ","logic", "VariableName: ","logic");
        this.config = config;
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow", "VariableName: ","config", "VariableName: ","config");
        this.prefs = prefs;
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow", "VariableName: ","prefs", "VariableName: ","prefs");

        // Configure the UI
        setTitle(config.getAppTitle());
		TemplateClass.instrum("LineNumber: ","76", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        setIcon(ICON);
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        setWindowMinSize();
		TemplateClass.instrum("LineNumber: ","78", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        setWindowDefaultSize(prefs);
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        Scene scene = new Scene(getRoot());
		TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        primaryStage.setScene(scene);
		TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");

        setAccelerators();
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
        registerAsAnEventHandler(this);
		TemplateClass.instrum("LineNumber: ","84", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","MainWindow", "Class: ","MainWindow");
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void setAccelerators() {
        setAccelerator(helpMenuItem, KeyCombination.valueOf("F1"));
		TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAccelerators", "Class: ","MainWindow");
    }

    /**
     * Sets the accelerator of a MenuItem.
     * @param keyCombination the KeyCombination value of the accelerator
     */
    private void setAccelerator(MenuItem menuItem, KeyCombination keyCombination) {
        menuItem.setAccelerator(keyCombination);
		TemplateClass.instrum("LineNumber: ","100", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAccelerator", "Class: ","MainWindow");

        /*
         * TODO: the code below can be removed once the bug reported here
         * https://bugs.openjdk.java.net/browse/JDK-8131666
         * is fixed in later version of SDK.
         *
         * According to the bug report, TextInputControl (TextField, TextArea) will
         * consume function-key events. Because CommandBox contains a TextField, and
         * ResultDisplay contains a TextArea, thus some accelerators (e.g F1) will
         * not work when the focus is in them because the key event is consumed by
         * the TextInputControl(s).
         *
         * For now, we add following event filter to capture such key events and open
         * help window purposely so to support accelerators even when focus is
         * in CommandBox or ResultDisplay.
         */
        getRoot().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getTarget() instanceof TextInputControl && keyCombination.match(event)) {
                menuItem.getOnAction().handle(new ActionEvent());
				TemplateClass.instrum("LineNumber: ","119", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAccelerator", "Class: ","MainWindow");
                event.consume();
				TemplateClass.instrum("LineNumber: ","120", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAccelerator", "Class: ","MainWindow");
            }
			TemplateClass.instrum("LineNumber: ","118", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setAccelerator", "Class: ","MainWindow");
        });
		TemplateClass.instrum("LineNumber: ","117", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setAccelerator", "Class: ","MainWindow");
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        browserPanel = new BrowserPanel();
		TemplateClass.instrum("LineNumber: ","129", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow", "VariableName: ","browserPanel", "VariableName: ","BrowserPanel");
        browserPlaceholder.getChildren().add(browserPanel.getRoot());
		TemplateClass.instrum("LineNumber: ","130", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");

        personListPanel = new PersonListPanel(logic.getFilteredPersonList());
		TemplateClass.instrum("LineNumber: ","132", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");
        personListPanelPlaceholder.getChildren().add(personListPanel.getRoot());
		TemplateClass.instrum("LineNumber: ","133", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");

        ResultDisplay resultDisplay = new ResultDisplay();
		TemplateClass.instrum("LineNumber: ","135", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","fillInnerParts", "Class: ","MainWindow", "VariableName: ","ResultDisplay", "VariableName: ","resultDisplay", "VariableName: ","ResultDisplay");
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());
		TemplateClass.instrum("LineNumber: ","136", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");

        StatusBarFooter statusBarFooter = new StatusBarFooter(prefs.getAddressBookFilePath());
		TemplateClass.instrum("LineNumber: ","138", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");
        statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());
		TemplateClass.instrum("LineNumber: ","139", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");

        CommandBox commandBox = new CommandBox(logic);
		TemplateClass.instrum("LineNumber: ","141", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","fillInnerParts", "Class: ","MainWindow", "VariableName: ","CommandBox", "VariableName: ","commandBox", "VariableName: ","CommandBox", "VariableName: ","logic");
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
		TemplateClass.instrum("LineNumber: ","142", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","fillInnerParts", "Class: ","MainWindow");
    }

    void hide() {
        primaryStage.hide();
		TemplateClass.instrum("LineNumber: ","146", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","hide", "Class: ","MainWindow");
    }

    private void setTitle(String appTitle) {
        primaryStage.setTitle(appTitle);
		TemplateClass.instrum("LineNumber: ","150", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setTitle", "Class: ","MainWindow");
    }

    /**
     * Sets the given image as the icon of the main window.
     * @param iconSource e.g. {@code "/images/help_icon.png"}
     */
    private void setIcon(String iconSource) {
        FxViewUtil.setStageIcon(primaryStage, iconSource);
		TemplateClass.instrum("LineNumber: ","158", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setIcon", "Class: ","MainWindow");
    }

    /**
     * Sets the default size based on user preferences.
     */
    private void setWindowDefaultSize(UserPrefs prefs) {
        primaryStage.setHeight(prefs.getGuiSettings().getWindowHeight());
		TemplateClass.instrum("LineNumber: ","165", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowDefaultSize", "Class: ","MainWindow");
        primaryStage.setWidth(prefs.getGuiSettings().getWindowWidth());
		TemplateClass.instrum("LineNumber: ","166", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowDefaultSize", "Class: ","MainWindow");
        if (prefs.getGuiSettings().getWindowCoordinates() != null) {
            primaryStage.setX(prefs.getGuiSettings().getWindowCoordinates().getX());
			TemplateClass.instrum("LineNumber: ","168", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowDefaultSize", "Class: ","MainWindow");
            primaryStage.setY(prefs.getGuiSettings().getWindowCoordinates().getY());
			TemplateClass.instrum("LineNumber: ","169", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowDefaultSize", "Class: ","MainWindow");
        }
		TemplateClass.instrum("LineNumber: ","167", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setWindowDefaultSize", "Class: ","MainWindow");
    }

    private void setWindowMinSize() {
        primaryStage.setMinHeight(MIN_HEIGHT);
		TemplateClass.instrum("LineNumber: ","174", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowMinSize", "Class: ","MainWindow");
        primaryStage.setMinWidth(MIN_WIDTH);
		TemplateClass.instrum("LineNumber: ","175", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setWindowMinSize", "Class: ","MainWindow");
    }

    /**
     * Returns the current size and the position of the main Window.
     */
    GuiSettings getCurrentGuiSetting() {
        return new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
    }

    /**
     * Opens the help window.
     */
    @FXML
    public void handleHelp() {
        HelpWindow helpWindow = new HelpWindow();
		TemplateClass.instrum("LineNumber: ","191", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","handleHelp", "Class: ","MainWindow", "VariableName: ","HelpWindow", "VariableName: ","helpWindow", "VariableName: ","HelpWindow");
        helpWindow.show();
		TemplateClass.instrum("LineNumber: ","192", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleHelp", "Class: ","MainWindow");
    }

    void show() {
        primaryStage.show();
		TemplateClass.instrum("LineNumber: ","196", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","show", "Class: ","MainWindow");
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        raise(new ExitAppRequestEvent());
		TemplateClass.instrum("LineNumber: ","204", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleExit", "Class: ","MainWindow");
    }

    public PersonListPanel getPersonListPanel() {
        return this.personListPanel;
    }

    void releaseResources() {
        browserPanel.freeResources();
		TemplateClass.instrum("LineNumber: ","212", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","releaseResources", "Class: ","MainWindow");
    }

    @Subscribe
    private void handleShowHelpEvent(ShowHelpRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","217", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleShowHelpEvent", "Class: ","MainWindow");
        handleHelp();
		TemplateClass.instrum("LineNumber: ","218", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleShowHelpEvent", "Class: ","MainWindow");
    }
}
