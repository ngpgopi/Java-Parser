package seedu.address.commons.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import seedu.address.TemplateClass;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * Converts a Java object instance to JSON and vice versa
 */
public class JsonUtil {

    private static final Logger logger = LogsCenter.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            .registerModule(new SimpleModule("SimpleModule")
                    .addSerializer(Level.class, new ToStringSerializer())
                    .addDeserializer(Level.class, new LevelDeserializer(Level.class)));

    static <T> void serializeObjectToJsonFile(File jsonFile, T objectToSerialize) throws IOException {
        FileUtil.writeToFile(jsonFile, toJsonString(objectToSerialize));
		TemplateClass.instrum("LineNumber: ","42", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","serializeObjectToJsonFile", "Class: ","JsonUtil");
    }

    static <T> T deserializeObjectFromJsonFile(File jsonFile, Class<T> classOfObjectToDeserialize)
            throws IOException {
        return fromJsonString(FileUtil.readFromFile(jsonFile), classOfObjectToDeserialize);
    }

    /**
     * Returns the Json object from the given file or {@code Optional.empty()} object if the file is not found.
     * If any values are missing from the file, default values will be used, as long as the file is a valid json file.
     * @param filePath cannot be null.
     * @param classOfObjectToDeserialize Json file has to correspond to the structure in the class given here.
     * @throws DataConversionException if the file format is not as expected.
     */
    public static <T> Optional<T> readJsonFile(
            String filePath, Class<T> classOfObjectToDeserialize) throws DataConversionException {
        requireNonNull(filePath);
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readJsonFile", "Class: ","JsonUtil");
        File file = new File(filePath);
		TemplateClass.instrum("LineNumber: ","60", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","readJsonFile", "Class: ","JsonUtil", "VariableName: ","File", "VariableName: ","file", "VariableName: ","File", "VariableName: ","filePath");

        if (!file.exists()) {
            logger.info("Json file "  + file + " not found");
			TemplateClass.instrum("LineNumber: ","63", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readJsonFile", "Class: ","JsonUtil");
            return Optional.empty();
        }
		TemplateClass.instrum("LineNumber: ","62", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","readJsonFile", "Class: ","JsonUtil");

        T jsonFile;
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","readJsonFile", "Class: ","JsonUtil", "VariableName: ","T", "VariableName: ","jsonFile");

        try {
            jsonFile = deserializeObjectFromJsonFile(file, classOfObjectToDeserialize);
			TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readJsonFile", "Class: ","JsonUtil");
        } catch (IOException e) {
            logger.warning("Error reading from jsonFile file " + file + ": " + e);
			TemplateClass.instrum("LineNumber: ","72", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","readJsonFile", "Class: ","JsonUtil");
            throw new DataConversionException(e);
        }

        return Optional.of(jsonFile);
    }

    /**
     * Saves the Json object to the specified file.
     * Overwrites existing file if it exists, creates a new file if it doesn't.
     * @param jsonFile cannot be null
     * @param filePath cannot be null
     * @throws IOException if there was an error during writing to the file
     */
    public static <T> void saveJsonFile(T jsonFile, String filePath) throws IOException {
        requireNonNull(filePath);
		TemplateClass.instrum("LineNumber: ","87", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveJsonFile", "Class: ","JsonUtil");
        requireNonNull(jsonFile);
		TemplateClass.instrum("LineNumber: ","88", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveJsonFile", "Class: ","JsonUtil");

        serializeObjectToJsonFile(new File(filePath), jsonFile);
		TemplateClass.instrum("LineNumber: ","90", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveJsonFile", "Class: ","JsonUtil");
    }


    /**
     * Converts a given string representation of a JSON data to instance of a class
     * @param <T> The generic type to create an instance of
     * @return The instance of T with the specified values in the JSON string
     */
    public static <T> T fromJsonString(String json, Class<T> instanceClass) throws IOException {
        return objectMapper.readValue(json, instanceClass);
    }

    /**
     * Converts a given instance of a class into its JSON data string representation
     * @param instance The T object to be converted into the JSON string
     * @param <T> The generic type to create an instance of
     * @return JSON data representation of the given class instance, in string
     */
    public static <T> String toJsonString(T instance) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(instance);
    }

    /**
     * Contains methods that retrieve logging level from serialized string.
     */
    private static class LevelDeserializer extends FromStringDeserializer<Level> {

        protected LevelDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        protected Level _deserialize(String value, DeserializationContext ctxt) throws IOException {
            return getLoggingLevel(value);
        }

        /**
         * Gets the logging level that matches loggingLevelString
         * <p>
         * Returns null if there are no matches
         *
         */
        private Level getLoggingLevel(String loggingLevelString) {
            return Level.parse(loggingLevelString);
        }

        @Override
        public Class<Level> handledType() {
            return Level.class;
        }
    }

}
