package seedu.address.logic;

import javafx.collections.ObservableList;
import seedu.address.TemplateClass;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.person.ReadOnlyPerson;

import java.util.logging.Logger;

/**
 * The main LogicManager of the app.
 */
public class LogicManager extends ComponentManager implements Logic {
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final CommandHistory history;
    private final AddressBookParser addressBookParser;
    private final UndoRedoStack undoRedoStack;

    public LogicManager(Model model) {
        this.model = model;
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","LogicManager", "Class: ","LogicManager", "VariableName: ","model", "VariableName: ","model");
        this.history = new CommandHistory();
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","LogicManager", "Class: ","LogicManager", "VariableName: ","history", "VariableName: ","CommandHistory");
        this.addressBookParser = new AddressBookParser();
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","LogicManager", "Class: ","LogicManager", "VariableName: ","addressBookParser", "VariableName: ","AddressBookParser");
        this.undoRedoStack = new UndoRedoStack();
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","LogicManager", "Class: ","LogicManager", "VariableName: ","undoRedoStack", "VariableName: ","UndoRedoStack");
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","LogicManager");
        try {
            Command command = addressBookParser.parseCommand(commandText);
			TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","execute", "Class: ","LogicManager");
            command.setData(model, history, undoRedoStack);
			TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","LogicManager");
            CommandResult result = command.execute();
			TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","execute", "Class: ","LogicManager");
            undoRedoStack.push(command);
			TemplateClass.instrum("LineNumber: ","41", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","LogicManager");
            return result;
        } finally {
            history.add(commandText);
			TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","execute", "Class: ","LogicManager");
        }
    }

    @Override
    public ObservableList<ReadOnlyPerson> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public ListElementPointer getHistorySnapshot() {
        return new ListElementPointer(history.getHistory());
    }
}
