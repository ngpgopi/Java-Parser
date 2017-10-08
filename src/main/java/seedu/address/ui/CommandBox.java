package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.NewResultAvailableEvent;
import seedu.address.logic.ListElementPointer;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The UI component that is responsible for receiving user command inputs.
 */
public class CommandBox extends UiPart<Region> {

    public static final String ERROR_STYLE_CLASS = "error";
    private static final String FXML = "CommandBox.fxml";

    private final Logger logger = LogsCenter.getLogger(CommandBox.class);
    private final Logic logic;
    private ListElementPointer historySnapshot;

    @FXML
    private TextField commandTextField;

    public CommandBox(Logic logic) {
        super(FXML);
        this.logic = logic;
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","CommandBox", "Class: ","CommandBox", "VariableName: ","logic", "VariableName: ","logic");
        // calls #setStyleToDefault() whenever there is a change to the text of the command box.
        commandTextField.textProperty().addListener((unused1, unused2, unused3) -> setStyleToDefault());
		TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","CommandBox", "Class: ","CommandBox");
        historySnapshot = logic.getHistorySnapshot();
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","CommandBox", "Class: ","CommandBox");
    }

    /**
     * Handles the key press event, {@code keyEvent}.
     */
    @FXML
    private void handleKeyPress(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
        case UP:
            // As up and down buttons will alter the position of the caret,
            // consuming it causes the caret's position to remain unchanged
            keyEvent.consume();

            navigateToPreviousInput();
            break;
        case DOWN:
            keyEvent.consume();
            navigateToNextInput();
            break;
        default:
            // let JavaFx handle the keypress
        }
		TemplateClass.instrum("LineNumber: ","46", "Type: ","org.eclipse.jdt.core.dom.SwitchStatement", "Method: ","handleKeyPress", "Class: ","CommandBox");
    }

    /**
     * Updates the text field with the previous input in {@code historySnapshot},
     * if there exists a previous input in {@code historySnapshot}
     */
    private void navigateToPreviousInput() {
        assert historySnapshot != null;
        if (!historySnapshot.hasPrevious()) {
            return;
        }

        replaceText(historySnapshot.previous());
    }

    /**
     * Updates the text field with the next input in {@code historySnapshot},
     * if there exists a next input in {@code historySnapshot}
     */
    private void navigateToNextInput() {
        assert historySnapshot != null;
        if (!historySnapshot.hasNext()) {
            return;
        }

        replaceText(historySnapshot.next());
    }

    /**
     * Sets {@code CommandBox}'s text field with {@code text} and
     * positions the caret to the end of the {@code text}.
     */
    private void replaceText(String text) {
        commandTextField.setText(text);
		TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","replaceText", "Class: ","CommandBox");
        commandTextField.positionCaret(commandTextField.getText().length());
		TemplateClass.instrum("LineNumber: ","95", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","replaceText", "Class: ","CommandBox");
    }

    /**
     * Handles the Enter button pressed event.
     */
    @FXML
    private void handleCommandInputChanged() {
        try {
            CommandResult commandResult = logic.execute(commandTextField.getText());
			TemplateClass.instrum("LineNumber: ","104", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            initHistory();
			TemplateClass.instrum("LineNumber: ","105", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            historySnapshot.next();
			TemplateClass.instrum("LineNumber: ","106", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            // process result of the command
            commandTextField.setText("");
			TemplateClass.instrum("LineNumber: ","108", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            logger.info("Result: " + commandResult.feedbackToUser);
			TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            raise(new NewResultAvailableEvent(commandResult.feedbackToUser));
			TemplateClass.instrum("LineNumber: ","110", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");

        } catch (CommandException | ParseException e) {
            initHistory();
			TemplateClass.instrum("LineNumber: ","113", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            // handle command failure
            setStyleToIndicateCommandFailure();
			TemplateClass.instrum("LineNumber: ","115", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            logger.info("Invalid command: " + commandTextField.getText());
			TemplateClass.instrum("LineNumber: ","116", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
            raise(new NewResultAvailableEvent(e.getMessage()));
			TemplateClass.instrum("LineNumber: ","117", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleCommandInputChanged", "Class: ","CommandBox");
        }
    }

    /**
     * Initializes the history snapshot.
     */
    private void initHistory() {
        historySnapshot = logic.getHistorySnapshot();
		TemplateClass.instrum("LineNumber: ","125", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initHistory", "Class: ","CommandBox");
        // add an empty string to represent the most-recent end of historySnapshot, to be shown to
        // the user if she tries to navigate past the most-recent end of the historySnapshot.
        historySnapshot.add("");
		TemplateClass.instrum("LineNumber: ","128", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initHistory", "Class: ","CommandBox");
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        commandTextField.getStyleClass().remove(ERROR_STYLE_CLASS);
		TemplateClass.instrum("LineNumber: ","135", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setStyleToDefault", "Class: ","CommandBox");
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = commandTextField.getStyleClass();
		TemplateClass.instrum("LineNumber: ","142", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","setStyleToIndicateCommandFailure", "Class: ","CommandBox");

        if (styleClass.contains(ERROR_STYLE_CLASS)) {
            return;
        }
		TemplateClass.instrum("LineNumber: ","144", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setStyleToIndicateCommandFailure", "Class: ","CommandBox");

        styleClass.add(ERROR_STYLE_CLASS);
		TemplateClass.instrum("LineNumber: ","148", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setStyleToIndicateCommandFailure", "Class: ","CommandBox");
    }

}
