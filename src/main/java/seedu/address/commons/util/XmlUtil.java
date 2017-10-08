package seedu.address.commons.util;

import seedu.address.TemplateClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

import static java.util.Objects.requireNonNull;

/**
 * Helps with reading from and writing to XML files.
 */
public class XmlUtil {

    /**
     * Returns the xml data in the file as an object of the specified type.
     *
     * @param file           Points to a valid xml file containing data that match the {@code classToConvert}.
     *                       Cannot be null.
     * @param classToConvert The class corresponding to the xml data.
     *                       Cannot be null.
     * @throws FileNotFoundException Thrown if the file is missing.
     * @throws JAXBException         Thrown if the file is empty or does not have the correct format.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getDataFromFile(File file, Class<T> classToConvert)
            throws FileNotFoundException, JAXBException {

        requireNonNull(file);
		TemplateClass.instrum("LineNumber: ","32", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getDataFromFile", "Class: ","XmlUtil");
        requireNonNull(classToConvert);
		TemplateClass.instrum("LineNumber: ","33", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","getDataFromFile", "Class: ","XmlUtil");

        if (!FileUtil.isFileExists(file)) {
            throw new FileNotFoundException("File not found : " + file.getAbsolutePath());
        }
		TemplateClass.instrum("LineNumber: ","35", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","getDataFromFile", "Class: ","XmlUtil");

        JAXBContext context = JAXBContext.newInstance(classToConvert);
		TemplateClass.instrum("LineNumber: ","39", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getDataFromFile", "Class: ","XmlUtil");
        Unmarshaller um = context.createUnmarshaller();
		TemplateClass.instrum("LineNumber: ","40", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","getDataFromFile", "Class: ","XmlUtil");

        return ((T) um.unmarshal(file));
    }

    /**
     * Saves the data in the file in xml format.
     *
     * @param file Points to a valid xml file containing data that match the {@code classToConvert}.
     *             Cannot be null.
     * @throws FileNotFoundException Thrown if the file is missing.
     * @throws JAXBException         Thrown if there is an error during converting the data
     *                               into xml and writing to the file.
     */
    public static <T> void saveDataToFile(File file, T data) throws FileNotFoundException, JAXBException {

        requireNonNull(file);
		TemplateClass.instrum("LineNumber: ","56", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");
        requireNonNull(data);
		TemplateClass.instrum("LineNumber: ","57", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");

        if (!file.exists()) {
            throw new FileNotFoundException("File not found : " + file.getAbsolutePath());
        }
		TemplateClass.instrum("LineNumber: ","59", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");

        JAXBContext context = JAXBContext.newInstance(data.getClass());
		TemplateClass.instrum("LineNumber: ","63", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");
        Marshaller m = context.createMarshaller();
		TemplateClass.instrum("LineNumber: ","64", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		TemplateClass.instrum("LineNumber: ","65", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");

        m.marshal(data, file);
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","saveDataToFile", "Class: ","XmlUtil");
    }

}
