package seedu.address.commons.core;

import seedu.address.TemplateClass;
import seedu.address.commons.events.BaseEvent;

import java.io.IOException;
import java.util.logging.*;

/**
 * Configures and manages loggers and handlers, including their logging level
 * Named {@link Logger}s can be obtained from this class<br>
 * These loggers have been configured to output messages to the console and a {@code .log} file by default,
 *   at the {@code INFO} level. A new {@code .log} file with a new numbering will be created after the log
 *   file reaches 5MB big, up to a maximum of 5 files.<br>
 */
public class LogsCenter {
    private static final int MAX_FILE_COUNT = 5;
    private static final int MAX_FILE_SIZE_IN_BYTES = (int) (Math.pow(2, 20) * 5); // 5MB
    private static final String LOG_FILE = "addressbook.log";
    private static Level currentLogLevel = Level.INFO;
    private static final Logger logger = LogsCenter.getLogger(LogsCenter.class);
    private static FileHandler fileHandler;
    private static ConsoleHandler consoleHandler;

    /**
     * Initializes with a custom log level (specified in the {@code config} object)
     * Loggers obtained *AFTER* this initialization will have their logging level changed<br>
     * Logging levels for existing loggers will only be updated if the logger with the same name
     * is requested again from the LogsCenter.
     */
    public static void init(Config config) {
        currentLogLevel = config.getLogLevel();
		TemplateClass.instrum("LineNumber: ","36", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","LogsCenter");
        logger.info("currentLogLevel: " + currentLogLevel);
		TemplateClass.instrum("LineNumber: ","37", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","LogsCenter");
    }

    /**
     * Creates a logger with the given name.
     */
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
		TemplateClass.instrum("LineNumber: ","44", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getLogger", "Class: ","LogsCenter");
        logger.setUseParentHandlers(false);
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getLogger", "Class: ","LogsCenter");

        removeHandlers(logger);
		TemplateClass.instrum("LineNumber: ","47", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getLogger", "Class: ","LogsCenter");
        addConsoleHandler(logger);
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getLogger", "Class: ","LogsCenter");
        addFileHandler(logger);
		TemplateClass.instrum("LineNumber: ","49", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getLogger", "Class: ","LogsCenter");

        return Logger.getLogger(name);
    }

    /**
     * Creates a Logger for the given class name.
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        if (clazz == null) {
            return Logger.getLogger("");
        }
		TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","getLogger", "Class: ","LogsCenter", "VariableName: ","clazz");
        return getLogger(clazz.getSimpleName());
    }

    /**
     * Adds the {@code consoleHandler} to the {@code logger}. <br>
     * Creates the {@code consoleHandler} if it is null.
     */
    private static void addConsoleHandler(Logger logger) {
        if (consoleHandler == null) {
            consoleHandler = createConsoleHandler();
			TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addConsoleHandler", "Class: ","LogsCenter");
        }
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","addConsoleHandler", "Class: ","LogsCenter", "VariableName: ","consoleHandler");
        logger.addHandler(consoleHandler);
		TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addConsoleHandler", "Class: ","LogsCenter");
    }

    /**
     * Remove all the handlers from {@code logger}.
     */
    private static void removeHandlers(Logger logger) {
        Handler[] handlers = logger.getHandlers();
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","removeHandlers", "Class: ","LogsCenter");
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
			TemplateClass.instrum("LineNumber: ","81", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","removeHandlers", "Class: ","LogsCenter");
        }
    }

    /**
     * Adds the {@code fileHandler} to the {@code logger}. <br>
     * Creates {@code fileHandler} if it is null.
     */
    private static void addFileHandler(Logger logger) {
        try {
            if (fileHandler == null) {
                fileHandler = createFileHandler();
				TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addFileHandler", "Class: ","LogsCenter");
            }
			TemplateClass.instrum("LineNumber: ","91", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","addFileHandler", "Class: ","LogsCenter", "VariableName: ","fileHandler");
            logger.addHandler(fileHandler);
			TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addFileHandler", "Class: ","LogsCenter");
        } catch (IOException e) {
            logger.warning("Error adding file handler for logger.");
			TemplateClass.instrum("LineNumber: ","96", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","addFileHandler", "Class: ","LogsCenter");
        }
    }

    /**
     * Creates a {@code FileHandler} for the log file.
     * @throws IOException if there are problems opening the file.
     */
    private static FileHandler createFileHandler() throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE, MAX_FILE_SIZE_IN_BYTES, MAX_FILE_COUNT, true);
		TemplateClass.instrum("LineNumber: ","105", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","createFileHandler", "Class: ","LogsCenter", "VariableName: ","FileHandler", "VariableName: ","fileHandler", "VariableName: ","FileHandler", "VariableName: ","LOG_FILE", "VariableName: ","MAX_FILE_SIZE_IN_BYTES", "VariableName: ","MAX_FILE_COUNT");
        fileHandler.setFormatter(new SimpleFormatter());
		TemplateClass.instrum("LineNumber: ","106", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createFileHandler", "Class: ","LogsCenter");
        fileHandler.setLevel(currentLogLevel);
		TemplateClass.instrum("LineNumber: ","107", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createFileHandler", "Class: ","LogsCenter");
        return fileHandler;
    }

    private static ConsoleHandler createConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
		TemplateClass.instrum("LineNumber: ","112", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","createConsoleHandler", "Class: ","LogsCenter", "VariableName: ","ConsoleHandler", "VariableName: ","consoleHandler", "VariableName: ","ConsoleHandler");
        consoleHandler.setLevel(currentLogLevel);
		TemplateClass.instrum("LineNumber: ","113", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","createConsoleHandler", "Class: ","LogsCenter");
        return consoleHandler;
    }

    /**
     * Decorates the given string to create a log message suitable for logging event handling methods.
     */
    public static String getEventHandlingLogMessage(BaseEvent e, String message) {
        return "---[Event handled][" + e + "]" + message;
    }

    /**
     * @see #getEventHandlingLogMessage(BaseEvent, String)
     */
    public static String getEventHandlingLogMessage(BaseEvent e) {
        return getEventHandlingLogMessage(e, "");
    }
}
