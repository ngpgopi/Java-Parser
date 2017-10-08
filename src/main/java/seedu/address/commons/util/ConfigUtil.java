package seedu.address.commons.util;

import seedu.address.TemplateClass;
import seedu.address.commons.core.Config;
import seedu.address.commons.exceptions.DataConversionException;

import java.io.IOException;
import java.util.Optional;

/**
 * A class for accessing the Config File.
 */
public class ConfigUtil {

    public static Optional<Config> readConfig(String configFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(configFilePath, Config.class);
    }

    public static void saveConfig(Config config, String configFilePath) throws IOException {
        JsonUtil.saveJsonFile(config, configFilePath);
		TemplateClass.instrum("LineNumber: ","19", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveConfig", "Class: ","ConfigUtil");
    }

}
