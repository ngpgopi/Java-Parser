package seedu.address.ui;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.TemplateClass;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final ReadOnlyPerson person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;

    public PersonCard(ReadOnlyPerson person, int displayedIndex) {
        super(FXML);
        this.person = person;
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonCard", "Class: ","PersonCard", "VariableName: ","person", "VariableName: ","person");
        id.setText(displayedIndex + ". ");
		TemplateClass.instrum("LineNumber: ","46", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonCard", "Class: ","PersonCard");
        initTags(person);
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonCard", "Class: ","PersonCard");
        bindListeners(person);
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonCard", "Class: ","PersonCard");
    }

    /**
     * Binds the individual UI elements to observe their respective {@code Person} properties
     * so that they will be notified of any changes.
     */
    private void bindListeners(ReadOnlyPerson person) {
        name.textProperty().bind(Bindings.convert(person.nameProperty()));
		TemplateClass.instrum("LineNumber: ","56", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
        phone.textProperty().bind(Bindings.convert(person.phoneProperty()));
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
        address.textProperty().bind(Bindings.convert(person.addressProperty()));
		TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
        email.textProperty().bind(Bindings.convert(person.emailProperty()));
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
        person.tagProperty().addListener((observable, oldValue, newValue) -> {
            tags.getChildren().clear();
			TemplateClass.instrum("LineNumber: ","61", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
            person.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
			TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
        });
		TemplateClass.instrum("LineNumber: ","60", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","bindListeners", "Class: ","PersonCard");
    }

    private void initTags(ReadOnlyPerson person) {
        person.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initTags", "Class: ","PersonCard");
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","PersonCard", "VariableName: ","other");

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","78", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","PersonCard", "VariableName: ","other", "VariableName: ","PersonCard");

        // state check
        PersonCard card = (PersonCard) other;
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","PersonCard", "VariableName: ","PersonCard", "VariableName: ","card", "VariableName: ","PersonCard", "VariableName: ","other");
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
