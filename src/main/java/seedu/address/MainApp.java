package seedu.address;

import com.google.common.eventbus.Subscribe;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.events.ui.ExitAppRequestEvent;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.model.*;
import seedu.address.model.util.SampleDataUtil;
import seedu.address.storage.*;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * The main entry point to the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 6, 0, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    protected Logic logic;
    protected Storage storage;
    protected Model model;
    protected Config config;
    protected UserPrefs userPrefs;


    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing AddressBook ]===========================");
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");
        super.init();
		TemplateClass.instrum("LineNumber: ","58", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp", "VariableName: ","init");

        config = initConfig(getApplicationParameter("config"));
		TemplateClass.instrum("LineNumber: ","60", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","init", "Class: ","MainApp");
        userPrefs = initPrefs(userPrefsStorage);
		TemplateClass.instrum("LineNumber: ","63", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");
        AddressBookStorage addressBookStorage = new XmlAddressBookStorage(userPrefs.getAddressBookFilePath());
		TemplateClass.instrum("LineNumber: ","64", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","init", "Class: ","MainApp");
        storage = new StorageManager(addressBookStorage, userPrefsStorage);
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp", "VariableName: ","storage", "VariableName: ","StorageManager", "VariableName: ","addressBookStorage", "VariableName: ","userPrefsStorage");

        initLogging(config);
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");

        model = initModelManager(storage, userPrefs);
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");

        logic = new LogicManager(model);
		TemplateClass.instrum("LineNumber: ","71", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp", "VariableName: ","logic", "VariableName: ","LogicManager", "VariableName: ","model");

        ui = new UiManager(logic, config, userPrefs);
		TemplateClass.instrum("LineNumber: ","73", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp", "VariableName: ","ui", "VariableName: ","UiManager", "VariableName: ","logic", "VariableName: ","config", "VariableName: ","userPrefs");

        initEventsCenter();
		TemplateClass.instrum("LineNumber: ","75", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","init", "Class: ","MainApp");
    }

    private String getApplicationParameter(String parameterName) {
        Map<String, String> applicationParameters = getParameters().getNamed();
		TemplateClass.instrum("LineNumber: ","79", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getApplicationParameter", "Class: ","MainApp");
        return applicationParameters.get(parameterName);
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private Model initModelManager(Storage storage, UserPrefs userPrefs) {
        Optional<ReadOnlyAddressBook> addressBookOptional;
		TemplateClass.instrum("LineNumber: ","89", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initModelManager", "Class: ","MainApp", "VariableName: ","Optional", "VariableName: ","ReadOnlyAddressBook", "VariableName: ","addressBookOptional");
        ReadOnlyAddressBook initialData;
		TemplateClass.instrum("LineNumber: ","90", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initModelManager", "Class: ","MainApp", "VariableName: ","ReadOnlyAddressBook", "VariableName: ","initialData");
        try {
            addressBookOptional = storage.readAddressBook();
			TemplateClass.instrum("LineNumber: ","92", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp");
            if (!addressBookOptional.isPresent()) {
                logger.info("Data file not found. Will be starting with a sample AddressBook");
				TemplateClass.instrum("LineNumber: ","94", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp");
            }
			TemplateClass.instrum("LineNumber: ","93", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","initModelManager", "Class: ","MainApp");
            initialData = addressBookOptional.orElseGet(SampleDataUtil::getSampleAddressBook);
			TemplateClass.instrum("LineNumber: ","96", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp");
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty AddressBook");
			TemplateClass.instrum("LineNumber: ","98", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp");
            initialData = new AddressBook();
			TemplateClass.instrum("LineNumber: ","99", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp", "VariableName: ","initialData", "VariableName: ","AddressBook");
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
			TemplateClass.instrum("LineNumber: ","101", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp");
            initialData = new AddressBook();
			TemplateClass.instrum("LineNumber: ","102", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initModelManager", "Class: ","MainApp", "VariableName: ","initialData", "VariableName: ","AddressBook");
        }

        return new ModelManager(initialData, userPrefs);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
		TemplateClass.instrum("LineNumber: ","109", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initLogging", "Class: ","MainApp");
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(String configFilePath) {
        Config initializedConfig;
		TemplateClass.instrum("LineNumber: ","118", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","Config", "VariableName: ","initializedConfig");
        String configFilePathUsed;
		TemplateClass.instrum("LineNumber: ","119", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","String", "VariableName: ","configFilePathUsed");

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;
		TemplateClass.instrum("LineNumber: ","121", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","configFilePathUsed", "VariableName: ","Config", "VariableName: ","DEFAULT_CONFIG_FILE");

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
			TemplateClass.instrum("LineNumber: ","124", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");
            configFilePathUsed = configFilePath;
			TemplateClass.instrum("LineNumber: ","125", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","configFilePathUsed", "VariableName: ","configFilePath");
        }
		TemplateClass.instrum("LineNumber: ","123", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","configFilePath");

        logger.info("Using config file : " + configFilePathUsed);
		TemplateClass.instrum("LineNumber: ","128", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
			TemplateClass.instrum("LineNumber: ","131", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initConfig", "Class: ","MainApp");
            initializedConfig = configOptional.orElse(new Config());
			TemplateClass.instrum("LineNumber: ","132", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");
        } catch (DataConversionException e) {
            logger.warning("Config file at " + configFilePathUsed + " is not in the correct format. "
                    + "Using default config properties");
			TemplateClass.instrum("LineNumber: ","134", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");
            initializedConfig = new Config();
			TemplateClass.instrum("LineNumber: ","136", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp", "VariableName: ","initializedConfig", "VariableName: ","Config");
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
			TemplateClass.instrum("LineNumber: ","141", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
			TemplateClass.instrum("LineNumber: ","143", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initConfig", "Class: ","MainApp");
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs file path,
     * or a new {@code UserPrefs} with default configuration if errors occur when
     * reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        String prefsFilePath = storage.getUserPrefsFilePath();
		TemplateClass.instrum("LineNumber: ","154", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initPrefs", "Class: ","MainApp");
        logger.info("Using prefs file : " + prefsFilePath);
		TemplateClass.instrum("LineNumber: ","155", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");

        UserPrefs initializedPrefs;
		TemplateClass.instrum("LineNumber: ","157", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initPrefs", "Class: ","MainApp", "VariableName: ","UserPrefs", "VariableName: ","initializedPrefs");
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
			TemplateClass.instrum("LineNumber: ","159", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","initPrefs", "Class: ","MainApp");
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
			TemplateClass.instrum("LineNumber: ","160", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");
        } catch (DataConversionException e) {
            logger.warning("UserPrefs file at " + prefsFilePath + " is not in the correct format. "
                    + "Using default user prefs");
			TemplateClass.instrum("LineNumber: ","162", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");
            initializedPrefs = new UserPrefs();
			TemplateClass.instrum("LineNumber: ","164", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp", "VariableName: ","initializedPrefs", "VariableName: ","UserPrefs");
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
			TemplateClass.instrum("LineNumber: ","166", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");
            initializedPrefs = new UserPrefs();
			TemplateClass.instrum("LineNumber: ","167", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp", "VariableName: ","initializedPrefs", "VariableName: ","UserPrefs");
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
			TemplateClass.instrum("LineNumber: ","172", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
			TemplateClass.instrum("LineNumber: ","174", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initPrefs", "Class: ","MainApp");
        }

        return initializedPrefs;
    }

    private void initEventsCenter() {
        EventsCenter.getInstance().registerHandler(this);
		TemplateClass.instrum("LineNumber: ","181", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","initEventsCenter", "Class: ","MainApp");
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting AddressBook " + MainApp.VERSION);
		TemplateClass.instrum("LineNumber: ","186", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","MainApp");
        ui.start(primaryStage);
		TemplateClass.instrum("LineNumber: ","187", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","start", "Class: ","MainApp");
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping Address Book ] =============================");
		TemplateClass.instrum("LineNumber: ","192", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
        ui.stop();
		TemplateClass.instrum("LineNumber: ","193", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
        try {
            storage.saveUserPrefs(userPrefs);
			TemplateClass.instrum("LineNumber: ","195", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
			TemplateClass.instrum("LineNumber: ","197", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
        }
        Platform.exit();
		TemplateClass.instrum("LineNumber: ","199", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
        System.exit(0);
		TemplateClass.instrum("LineNumber: ","200", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","stop", "Class: ","MainApp");
    }

    @Subscribe
    public void handleExitAppRequestEvent(ExitAppRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
		TemplateClass.instrum("LineNumber: ","205", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleExitAppRequestEvent", "Class: ","MainApp");
        this.stop();
		TemplateClass.instrum("LineNumber: ","206", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","handleExitAppRequestEvent", "Class: ","MainApp");
    }

    public static void main(String[] args) {
        launch(args);
		TemplateClass.instrum("LineNumber: ","210", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","main", "Class: ","MainApp");
    }
    public static File file = new File ( "Logging.txt" );
}
