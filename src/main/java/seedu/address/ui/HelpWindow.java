package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.FxViewUtil;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Region> {

    public static final String USERGUIDE_FILE_PATH = "/docs/UserGuide.html";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String ICON = "/images/help_icon.png";
    private static final String FXML = "HelpWindow.fxml";
    private static final String TITLE = "Help";

    @FXML
    private WebView browser;

    private final Stage dialogStage;

    public HelpWindow() {
        super(FXML);
        Scene scene = new Scene(getRoot());
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");
        //Null passed as the parent stage to make it non-modal.
        dialogStage = createDialogStage(TITLE, null, scene);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");
        dialogStage.setMaximized(true); //TODO: set a more appropriate initial size
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");
        FxViewUtil.setStageIcon(dialogStage, ICON);
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");

        String userGuideUrl = getClass().getResource(USERGUIDE_FILE_PATH).toString();
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");
        browser.getEngine().load(userGuideUrl);
		TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","HelpWindow", "Class: ","HelpWindow");
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
		TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","show", "Class: ","HelpWindow");
        dialogStage.showAndWait();
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","show", "Class: ","HelpWindow");
    }
}
