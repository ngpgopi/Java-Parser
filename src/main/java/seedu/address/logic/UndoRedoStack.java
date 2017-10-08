package seedu.address.logic;

import seedu.address.TemplateClass;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.UndoableCommand;

import java.util.Stack;

/**
 * Maintains the undo-stack (the stack of commands that can be undone) and the redo-stack (the stack of
 * commands that can be undone).
 */
public class UndoRedoStack {
    private Stack<UndoableCommand> undoStack;
    private Stack<UndoableCommand> redoStack;

    public UndoRedoStack() {
        undoStack = new Stack<>();
		TemplateClass.instrum("LineNumber: ","19", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UndoRedoStack", "Class: ","UndoRedoStack", "VariableName: ","undoStack", "VariableName: ","Stack");
        redoStack = new Stack<>();
		TemplateClass.instrum("LineNumber: ","20", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","UndoRedoStack", "Class: ","UndoRedoStack", "VariableName: ","redoStack", "VariableName: ","Stack");
    }

    /**
     * Pushes {@code command} onto the undo-stack if it is of type {@code UndoableCommand}. Clears the redo-stack
     * if {@code command} is not of type {@code UndoCommand} or {@code RedoCommand}.
     */
    public void push(Command command) {
        if (!(command instanceof UndoCommand) && !(command instanceof RedoCommand)) {
            redoStack.clear();
			TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","push", "Class: ","UndoRedoStack");
        }
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","push", "Class: ","UndoRedoStack", "VariableName: ","command", "VariableName: ","UndoCommand", "VariableName: ","command", "VariableName: ","RedoCommand");

        if (!(command instanceof UndoableCommand)) {
            return;
        }
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","push", "Class: ","UndoRedoStack", "VariableName: ","command", "VariableName: ","UndoableCommand");

        undoStack.add((UndoableCommand) command);
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","push", "Class: ","UndoRedoStack");
    }

    /**
     * Pops and returns the next {@code UndoableCommand} to be undone in the stack.
     */
    public UndoableCommand popUndo() {
        UndoableCommand toUndo = undoStack.pop();
		TemplateClass.instrum("LineNumber: ","43", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","popUndo", "Class: ","UndoRedoStack");
        redoStack.push(toUndo);
		TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","popUndo", "Class: ","UndoRedoStack");
        return toUndo;
    }

    /**
     * Pops and returns the next {@code UndoableCommand} to be redone in the stack.
     */
    public UndoableCommand popRedo() {
        UndoableCommand toRedo = redoStack.pop();
		TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","popRedo", "Class: ","UndoRedoStack");
        undoStack.push(toRedo);
		TemplateClass.instrum("LineNumber: ","53", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","popRedo", "Class: ","UndoRedoStack");
        return toRedo;
    }

    /**
     * Returns true if there are more commands that can be undone.
     */
    public boolean canUndo() {
        return !undoStack.empty();
    }

    /**
     * Returns true if there are more commands that can be redone.
     */
    public boolean canRedo() {
        return !redoStack.empty();
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","74", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","UndoRedoStack", "VariableName: ","other");

        // instanceof handles nulls
        if (!(other instanceof UndoRedoStack)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","UndoRedoStack", "VariableName: ","other", "VariableName: ","UndoRedoStack");

        UndoRedoStack stack = (UndoRedoStack) other;
		TemplateClass.instrum("LineNumber: ","83", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","UndoRedoStack", "VariableName: ","UndoRedoStack", "VariableName: ","stack", "VariableName: ","UndoRedoStack", "VariableName: ","other");

        // state check
        return undoStack.equals(stack.undoStack)
                && redoStack.equals(stack.redoStack);
    }
}
