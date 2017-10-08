package seedu.address.storage;

import java.io.IOException;
import java.util.Optional;

import seedu.address.TemplateClass;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.UserPrefs;

/**
 * A class to access UserPrefs stored in the hard disk as a json file
 */
public class JsonUserPrefsStorage implements UserPrefsStorage {

    private String filePath;

    public JsonUserPrefsStorage(String filePath) {
        this.filePath = filePath;
		TemplateClass.instrum("LineNumber: ","18", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","JsonUserPrefsStorage", "Class: ","JsonUserPrefsStorage", "VariableName: ","filePath", "VariableName: ","filePath");
    }

    @Override
    public String getUserPrefsFilePath() {
        return filePath;
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return readUserPrefs(filePath);
    }

    /**
     * Similar to {@link #readUserPrefs()}
     * @param prefsFilePath location of the data. Cannot be null.
     * @throws DataConversionException if the file format is not as expected.
     */
    public Optional<UserPrefs> readUserPrefs(String prefsFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(prefsFilePath, UserPrefs.class);
    }

    @Override
    public void saveUserPrefs(UserPrefs userPrefs) throws IOException {
        JsonUtil.saveJsonFile(userPrefs, filePath);
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveUserPrefs", "Class: ","JsonUserPrefsStorage");
    }

}
