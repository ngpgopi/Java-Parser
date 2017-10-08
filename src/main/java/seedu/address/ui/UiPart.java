package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seedu.address.MainApp;
import seedu.address.TemplateClass;
import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.BaseEvent;

/**
 * Represents a distinct part of the UI. e.g. Windows, dialogs, panels, status bars, etc.
 * It contains a scene graph with a root node of type {@code T}.
 */
public abstract class UiPart<T> {

    /** Resource folder where FXML files are stored. */
    public static final String FXML_FILE_FOLDER = "/view/";

    private FXMLLoader fxmlLoader;

    /**
     * Constructs a UiPart with the specified FXML file URL.
     * The FXML file must not specify the {@code fx:controller} attribute.
     */
    public UiPart(URL fxmlFileUrl) {
        requireNonNull(fxmlFileUrl);
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiPart", "Class: ","UiPart");
        fxmlLoader = new FXMLLoader(fxmlFileUrl);
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiPart", "Class: ","UiPart", "VariableName: ","fxmlLoader", "VariableName: ","FXMLLoader", "VariableName: ","fxmlFileUrl");
        fxmlLoader.setController(this);
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiPart", "Class: ","UiPart");
        try {
            fxmlLoader.load();
			TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UiPart", "Class: ","UiPart");
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Constructs a UiPart using the specified FXML file within {@link #FXML_FILE_FOLDER}.
     * @see #UiPart(URL)
     */
    public UiPart(String fxmlFileName) {
        this(fxmlFileName != null ? MainApp.class.getResource(FXML_FILE_FOLDER + fxmlFileName) : null);
    }

    /**
     * Returns the root object of the scene graph of this UiPart.
     */
    public T getRoot() {
        return fxmlLoader.getRoot();
    }

    /**
     * Raises the event via {@link EventsCenter#post(BaseEvent)}
     * @param event
     */
    protected void raise(BaseEvent event) {
        EventsCenter.getInstance().post(event);
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","raise", "Class: ","UiPart");
    }

    /**
     * Registers the object as an event handler at the {@link EventsCenter}
     * @param handler usually {@code this}
     */
    protected void registerAsAnEventHandler(Object handler) {
        EventsCenter.getInstance().registerHandler(handler);
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","registerAsAnEventHandler", "Class: ","UiPart");
    }

    /**
     * Creates a modal dialog.
     * @param title Title of the dialog.
     * @param parentStage The owner stage of the dialog.
     * @param scene The scene that will contain the dialog.
     * @return the created dialog, not yet made visible.
     */
    protected Stage createDialogStage(String title, Stage parentStage, Scene scene) {
        Stage dialogStage = new Stage();
		TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","createDialogStage", "Class: ","UiPart", "VariableName: ","Stage", "VariableName: ","dialogStage", "VariableName: ","Stage");
        dialogStage.setTitle(title);
		TemplateClass.instrum("LineNumber: ","82", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createDialogStage", "Class: ","UiPart");
        dialogStage.initModality(Modality.WINDOW_MODAL);
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createDialogStage", "Class: ","UiPart");
        dialogStage.initOwner(parentStage);
		TemplateClass.instrum("LineNumber: ","84", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createDialogStage", "Class: ","UiPart");
        dialogStage.setScene(scene);
		TemplateClass.instrum("LineNumber: ","85", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createDialogStage", "Class: ","UiPart");
        return dialogStage;
    }

}
