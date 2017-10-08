package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import seedu.address.MainApp;
import seedu.address.TemplateClass;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.storage.DataSavingExceptionEvent;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.Logic;
import seedu.address.model.UserPrefs;

/**
 * The manager of the UI component.
 */
public class UiManager extends ComponentManager implements Ui {

    public static final String ALERT_DIALOG_PANE_FIELD_ID = "alertDialogPane";

    public static final String FILE_OPS_ERROR_DIALOG_STAGE_TITLE = "File Op Error";
    public static final String FILE_OPS_ERROR_DIALOG_HEADER_MESSAGE = "Could not save data";
    public static final String FILE_OPS_ERROR_DIALOG_CONTENT_MESSAGE = "Could not save data to file";

    private static final Logger logger = LogsCenter.getLogger(UiManager.class);
    private static final String ICON_APPLICATION = "/images/address_book_32.png";

    private Logic logic;
    private Config config;
    private UserPrefs prefs;
    private MainWindow mainWindow;

    public UiManager(Logic logic, Config config, UserPrefs prefs) {
        super();
        this.logic = logic;
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiManager", "Class: ","UiManager", "VariableName: ","logic", "VariableName: ","logic");
        this.config = config;
		TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiManager", "Class: ","UiManager", "VariableName: ","config", "VariableName: ","config");
        this.prefs = prefs;
		TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiManager", "Class: ","UiManager", "VariableName: ","prefs", "VariableName: ","prefs");
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting UI...");
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");
        primaryStage.setTitle(config.getAppTitle());
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");

        //Set the application icon.
        primaryStage.getIcons().add(getImage(ICON_APPLICATION));
		TemplateClass.instrum("LineNumber: ","53", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");

        try {
            mainWindow = new MainWindow(primaryStage, config, prefs, logic);
			TemplateClass.instrum("LineNumber: ","56", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager", "VariableName: ","mainWindow", "VariableName: ","MainWindow", "VariableName: ","primaryStage", "VariableName: ","config", "VariableName: ","prefs", "VariableName: ","logic");
            mainWindow.show(); //This should be called before creating other UI parts
			TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");
            mainWindow.fillInnerParts();
			TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");

        } catch (Throwable e) {
            logger.severe(StringUtil.getDetails(e));
			TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");
            showFatalErrorDialogAndShutdown("Fatal error during initializing", e);
			TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","UiManager");
        }
    }

    @Override
    public void stop() {
        prefs.updateLastUsedGuiSetting(mainWindow.getCurrentGuiSetting());
		TemplateClass.instrum("LineNumber: ","68", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","UiManager");
        mainWindow.hide();
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","UiManager");
        mainWindow.releaseResources();
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","UiManager");
    }

    private void showFileOperationAlertAndWait(String description, String details, Throwable cause) {
        final String content = details + ":\n" + cause.toString();
		TemplateClass.instrum("LineNumber: ","74", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","showFileOperationAlertAndWait", "Class: ","UiManager");
        showAlertDialogAndWait(AlertType.ERROR, FILE_OPS_ERROR_DIALOG_STAGE_TITLE, description, content);
		TemplateClass.instrum("LineNumber: ","75", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showFileOperationAlertAndWait", "Class: ","UiManager");
    }

    private Image getImage(String imagePath) {
        return new Image(MainApp.class.getResourceAsStream(imagePath));
    }

    void showAlertDialogAndWait(Alert.AlertType type, String title, String headerText, String contentText) {
        showAlertDialogAndWait(mainWindow.getPrimaryStage(), type, title, headerText, contentText);
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
    }

    /**
     * Shows an alert dialog on {@code owner} with the given parameters.
     * This method only returns after the user has closed the alert dialog.
     */
    private static void showAlertDialogAndWait(Stage owner, AlertType type, String title, String headerText,
                                               String contentText) {
        final Alert alert = new Alert(type);
		TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager", "VariableName: ","Alert", "VariableName: ","alert", "VariableName: ","Alert", "VariableName: ","type");
        alert.getDialogPane().getStylesheets().add("view/DarkTheme.css");
		TemplateClass.instrum("LineNumber: ","93", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.initOwner(owner);
		TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.setTitle(title);
		TemplateClass.instrum("LineNumber: ","95", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.setHeaderText(headerText);
		TemplateClass.instrum("LineNumber: ","96", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.setContentText(contentText);
		TemplateClass.instrum("LineNumber: ","97", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.getDialogPane().setId(ALERT_DIALOG_PANE_FIELD_ID);
		TemplateClass.instrum("LineNumber: ","98", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
        alert.showAndWait();
		TemplateClass.instrum("LineNumber: ","99", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showAlertDialogAndWait", "Class: ","UiManager");
    }

    /**
     * Shows an error alert dialog with {@code title} and error message, {@code e},
     * and exits the application after the user has closed the alert dialog.
     */
    private void showFatalErrorDialogAndShutdown(String title, Throwable e) {
        logger.severe(title + " " + e.getMessage() + StringUtil.getDetails(e));
		TemplateClass.instrum("LineNumber: ","107", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showFatalErrorDialogAndShutdown", "Class: ","UiManager");
        showAlertDialogAndWait(Alert.AlertType.ERROR, title, e.getMessage(), e.toString());
		TemplateClass.instrum("LineNumber: ","108", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showFatalErrorDialogAndShutdown", "Class: ","UiManager");
        Platform.exit();
		TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showFatalErrorDialogAndShutdown", "Class: ","UiManager");
        System.exit(1);
		TemplateClass.instrum("LineNumber: ","110", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","showFatalErrorDialogAndShutdown", "Class: ","UiManager");
    }

    //==================== Event Handling Code ===============================================================

    @Subscribe
    private void handleDataSavingExceptionEvent(DataSavingExceptionEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","117", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleDataSavingExceptionEvent", "Class: ","UiManager");
        showFileOperationAlertAndWait(FILE_OPS_ERROR_DIALOG_HEADER_MESSAGE, FILE_OPS_ERROR_DIALOG_CONTENT_MESSAGE,
                event.exception);
		TemplateClass.instrum("LineNumber: ","118", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleDataSavingExceptionEvent", "Class: ","UiManager");
    }
}
