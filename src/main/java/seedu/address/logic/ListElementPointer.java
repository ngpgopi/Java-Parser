package seedu.address.logic;

import seedu.address.TemplateClass;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Has a cursor that points to an element in the list, and is able to iterate through the list.
 * This is different from {@code ListIterator}, which has a cursor that points in between elements.
 * The {@code ListIterator}'s behaviour: when making alternating calls of {@code next()} and
 * {@code previous()}, the same element is returned on both calls.
 * In contrast, {@code ListElementPointer}'s behaviour: when making alternating calls of
 * {@code next()} and {@code previous()}, the next and previous elements are returned respectively.
 */
public class ListElementPointer {
    private List<String> list;
    private int index;

    /**
     * Constructs {@code ListElementPointer} which is backed by a defensive copy of {@code list}.
     * The cursor points to the last element in {@code list}.
     */
    public ListElementPointer(List<String> list) {
        this.list = list;
		TemplateClass.instrum("LineNumber: ","23", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ListElementPointer", "Class: ","ListElementPointer", "VariableName: ","list", "VariableName: ","list");
        index = this.list.size() - 1;
		TemplateClass.instrum("LineNumber: ","24", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","ListElementPointer", "Class: ","ListElementPointer");
    }

    /**
     * Appends {@code element} to the end of the list.
     */
    public void add(String element) {
        list.add(element);
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","add", "Class: ","ListElementPointer");
    }

    /**
     * Returns true if calling {@code #next()} does not throw an {@code NoSuchElementException}.
     */
    public boolean hasNext() {
        int nextIndex = index + 1;
		TemplateClass.instrum("LineNumber: ","38", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","hasNext", "Class: ","ListElementPointer", "VariableName: ","nextIndex", "VariableName: ","index");
        return isWithinBounds(nextIndex);
    }

    /**
     * Returns true if calling {@code #previous()} does not throw an {@code NoSuchElementException}.
     */
    public boolean hasPrevious() {
        int previousIndex = index - 1;
		TemplateClass.instrum("LineNumber: ","46", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","hasPrevious", "Class: ","ListElementPointer", "VariableName: ","previousIndex", "VariableName: ","index");
        return isWithinBounds(previousIndex);
    }

    /**
     * Returns true if calling {@code #current()} does not throw an {@code NoSuchElementException}.
     */
    public boolean hasCurrent() {
        return isWithinBounds(index);
    }

    private boolean isWithinBounds(int index) {
        return index >= 0 && index < list.size();
    }

    /**
     * Returns the next element in the list and advances the cursor position.
     * @throws NoSuchElementException if there is no more next element in the list.
     */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
		TemplateClass.instrum("LineNumber: ","66", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","next", "Class: ","ListElementPointer");
        return list.get(++index);
    }

    /**
     * Returns the previous element in the list and moves the cursor position backwards.
     * @throws NoSuchElementException if there is no more previous element in the list.
     */
    public String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
		TemplateClass.instrum("LineNumber: ","77", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","previous", "Class: ","ListElementPointer");
        return list.get(--index);
    }

    /**
     * Returns the current element in the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public String current() {
        if (!hasCurrent()) {
            throw new NoSuchElementException();
        }
		TemplateClass.instrum("LineNumber: ","88", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","current", "Class: ","ListElementPointer");
        return list.get(index);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","97", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","ListElementPointer", "VariableName: ","other");

        // instanceof handles nulls
        if (!(other instanceof ListElementPointer)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","102", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","ListElementPointer", "VariableName: ","other", "VariableName: ","ListElementPointer");

        // state check
        ListElementPointer iterator = (ListElementPointer) other;
		TemplateClass.instrum("LineNumber: ","107", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","ListElementPointer", "VariableName: ","ListElementPointer", "VariableName: ","iterator", "VariableName: ","ListElementPointer", "VariableName: ","other");
        return list.equals(iterator.list) && index == iterator.index;
    }
}
