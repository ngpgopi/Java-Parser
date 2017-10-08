package seedu.address.ui;

import java.util.logging.Logger;

import org.fxmisc.easybind.EasyBind;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<PersonCard> personListView;

    public PersonListPanel(ObservableList<ReadOnlyPerson> personList) {
        super(FXML);
        setConnections(personList);
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonListPanel", "Class: ","PersonListPanel");
        registerAsAnEventHandler(this);
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","PersonListPanel", "Class: ","PersonListPanel");
    }

    private void setConnections(ObservableList<ReadOnlyPerson> personList) {
        ObservableList<PersonCard> mappedList = EasyBind.map(
                personList, (person) -> new PersonCard(person, personList.indexOf(person) + 1));
		TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","setConnections", "Class: ","PersonListPanel");
        personListView.setItems(mappedList);
		TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setConnections", "Class: ","PersonListPanel");
        personListView.setCellFactory(listView -> new PersonListViewCell());
		TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setConnections", "Class: ","PersonListPanel");
        setEventHandlerForSelectionChangeEvent();
		TemplateClass.instrum("LineNumber: ","41", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setConnections", "Class: ","PersonListPanel");
    }

    private void setEventHandlerForSelectionChangeEvent() {
        personListView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        logger.fine("Selection in person list panel changed to : '" + newValue + "'");
						TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setEventHandlerForSelectionChangeEvent", "Class: ","PersonListPanel");
                        raise(new PersonPanelSelectionChangedEvent(newValue));
						TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setEventHandlerForSelectionChangeEvent", "Class: ","PersonListPanel");
                    }
					TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","setEventHandlerForSelectionChangeEvent", "Class: ","PersonListPanel", "VariableName: ","newValue");
                });
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","setEventHandlerForSelectionChangeEvent", "Class: ","PersonListPanel");
    }

    /**
     * Scrolls to the {@code PersonCard} at the {@code index} and selects it.
     */
    private void scrollTo(int index) {
        Platform.runLater(() -> {
            personListView.scrollTo(index);
			TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","scrollTo", "Class: ","PersonListPanel");
            personListView.getSelectionModel().clearAndSelect(index);
			TemplateClass.instrum("LineNumber: ","60", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","scrollTo", "Class: ","PersonListPanel");
        });
		TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","scrollTo", "Class: ","PersonListPanel");
    }

    @Subscribe
    private void handleJumpToListRequestEvent(JumpToListRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","66", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleJumpToListRequestEvent", "Class: ","PersonListPanel");
        scrollTo(event.targetIndex);
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleJumpToListRequestEvent", "Class: ","PersonListPanel");
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<PersonCard> {

        @Override
        protected void updateItem(PersonCard person, boolean empty) {
            super.updateItem(person, empty);
			TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateItem", "Class: ","PersonListViewCell", "VariableName: ","updateItem", "VariableName: ","person", "VariableName: ","empty");

            if (empty || person == null) {
                setGraphic(null);
				TemplateClass.instrum("LineNumber: ","80", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateItem", "Class: ","PersonListViewCell");
                setText(null);
				TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateItem", "Class: ","PersonListViewCell");
            } else {
                setGraphic(person.getRoot());
				TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","updateItem", "Class: ","PersonListViewCell");
            }
			TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","updateItem", "Class: ","PersonListViewCell", "VariableName: ","empty", "VariableName: ","person");
        }
    }

}
