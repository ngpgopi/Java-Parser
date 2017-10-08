package seedu.address.commons.util;

import seedu.address.TemplateClass;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * Utility methods related to Collections
 */
public class CollectionUtil {

    /** @see #requireAllNonNull(Collection) */
    public static void requireAllNonNull(Object... items) {
        requireNonNull(items);
		TemplateClass.instrum("LineNumber: ","19", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","requireAllNonNull", "Class: ","CollectionUtil");
        Stream.of(items).forEach(Objects::requireNonNull);
		TemplateClass.instrum("LineNumber: ","20", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","requireAllNonNull", "Class: ","CollectionUtil");
    }

    /**
     * Throws NullPointerException if {@code items} or any element of {@code items} is null.
     */
    public static void requireAllNonNull(Collection<?> items) {
        requireNonNull(items);
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","requireAllNonNull", "Class: ","CollectionUtil");
        items.forEach(Objects::requireNonNull);
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","requireAllNonNull", "Class: ","CollectionUtil");
    }

    /**
     * Returns true if {@code items} contain any elements that are non-null.
     */
    public static boolean isAnyNonNull(Object... items) {
        return items != null && Arrays.stream(items).anyMatch(Objects::nonNull);
    }

    /**
     * Returns true if every element in a collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","elementsAreUnique", "Class: ","CollectionUtil", "VariableName: ","Set", "VariableName: ","Object", "VariableName: ","testSet", "VariableName: ","HashSet");
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
			TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","elementsAreUnique", "Class: ","CollectionUtil");
            if (itemAlreadyExists) {
                return false;
            }
			TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","elementsAreUnique", "Class: ","CollectionUtil", "VariableName: ","itemAlreadyExists");
        }
        return true;
    }
}
