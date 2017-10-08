package seedu.address.commons.util;

import seedu.address.TemplateClass;

import java.io.PrintWriter;
import java.io.StringWriter;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");
        requireNonNull(word);
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");

        String preppedWord = word.trim();
		TemplateClass.instrum("LineNumber: ","29", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
		TemplateClass.instrum("LineNumber: ","30", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");
		TemplateClass.instrum("LineNumber: ","31", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");

        String preppedSentence = sentence;
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil", "VariableName: ","String", "VariableName: ","preppedSentence", "VariableName: ","sentence");
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");
		TemplateClass.instrum("LineNumber: ","34", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");

        for (String wordInSentence: wordsInPreppedSentence) {
            if (wordInSentence.equalsIgnoreCase(preppedWord)) {
                return true;
            }
			TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","containsWordIgnoreCase", "Class: ","StringUtil");
        }
        return false;
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getDetails", "Class: ","StringUtil");
        StringWriter sw = new StringWriter();
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getDetails", "Class: ","StringUtil", "VariableName: ","StringWriter", "VariableName: ","sw", "VariableName: ","StringWriter");
        t.printStackTrace(new PrintWriter(sw));
		TemplateClass.instrum("LineNumber: ","50", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getDetails", "Class: ","StringUtil");
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","isNonZeroUnsignedInteger", "Class: ","StringUtil");

        try {
            int value = Integer.parseInt(s);
			TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","isNonZeroUnsignedInteger", "Class: ","StringUtil");
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
