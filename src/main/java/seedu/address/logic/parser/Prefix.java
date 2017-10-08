package seedu.address.logic.parser;

import seedu.address.TemplateClass;

/**
 * A prefix that marks the beginning of an argument in an arguments string.
 * E.g. 't/' in 'add James t/ friend'.
 */
public class Prefix {
    private final String prefix;

    public Prefix(String prefix) {
        this.prefix = prefix;
		TemplateClass.instrum("LineNumber: ","11", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","Prefix", "Class: ","Prefix", "VariableName: ","prefix", "VariableName: ","prefix");
    }

    public String getPrefix() {
        return prefix;
    }

    public String toString() {
        return getPrefix();
    }

    @Override
    public int hashCode() {
        return prefix == null ? 0 : prefix.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Prefix)) {
            return false;
        }
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Prefix", "VariableName: ","obj", "VariableName: ","Prefix");
        if (obj == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","Prefix", "VariableName: ","obj");

        Prefix otherPrefix = (Prefix) obj;
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","Prefix", "VariableName: ","Prefix", "VariableName: ","otherPrefix", "VariableName: ","Prefix", "VariableName: ","obj");
        return otherPrefix.getPrefix().equals(getPrefix());
    }
}
