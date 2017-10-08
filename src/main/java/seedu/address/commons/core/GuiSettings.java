package seedu.address.commons.core;

import seedu.address.TemplateClass;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Serializable class that contains the GUI settings.
 */
public class GuiSettings implements Serializable {

    private static final double DEFAULT_HEIGHT = 600;
    private static final double DEFAULT_WIDTH = 740;

    private Double windowWidth;
    private Double windowHeight;
    private Point windowCoordinates;

    public GuiSettings() {
        this.windowWidth = DEFAULT_WIDTH;
		TemplateClass.instrum("LineNumber: ","20", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowWidth", "VariableName: ","DEFAULT_WIDTH");
        this.windowHeight = DEFAULT_HEIGHT;
		TemplateClass.instrum("LineNumber: ","21", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowHeight", "VariableName: ","DEFAULT_HEIGHT");
        this.windowCoordinates = null; // null represent no coordinates
		TemplateClass.instrum("LineNumber: ","22", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowCoordinates");
    }

    public GuiSettings(Double windowWidth, Double windowHeight, int xPosition, int yPosition) {
        this.windowWidth = windowWidth;
		TemplateClass.instrum("LineNumber: ","26", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowWidth", "VariableName: ","windowWidth");
        this.windowHeight = windowHeight;
		TemplateClass.instrum("LineNumber: ","27", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowHeight", "VariableName: ","windowHeight");
        this.windowCoordinates = new Point(xPosition, yPosition);
		TemplateClass.instrum("LineNumber: ","28", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","GuiSettings", "Class: ","GuiSettings", "VariableName: ","windowCoordinates", "VariableName: ","Point", "VariableName: ","xPosition", "VariableName: ","yPosition");
    }

    public Double getWindowWidth() {
        return windowWidth;
    }

    public Double getWindowHeight() {
        return windowHeight;
    }

    public Point getWindowCoordinates() {
        return windowCoordinates;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
		TemplateClass.instrum("LineNumber: ","45", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","GuiSettings", "VariableName: ","other");
        if (!(other instanceof GuiSettings)) { //this handles null as well.
            return false;
        }
		TemplateClass.instrum("LineNumber: ","48", "Type: ","org.eclipse.jdt.core.dom.IfStatement", "Method: ","equals", "Class: ","GuiSettings", "VariableName: ","other", "VariableName: ","GuiSettings");

        GuiSettings o = (GuiSettings) other;
		TemplateClass.instrum("LineNumber: ","52", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","equals", "Class: ","GuiSettings", "VariableName: ","GuiSettings", "VariableName: ","o", "VariableName: ","GuiSettings", "VariableName: ","other");

        return Objects.equals(windowWidth, o.windowWidth)
                && Objects.equals(windowHeight, o.windowHeight)
                && Objects.equals(windowCoordinates.x, o.windowCoordinates.x)
                && Objects.equals(windowCoordinates.y, o.windowCoordinates.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowWidth, windowHeight, windowCoordinates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		TemplateClass.instrum("LineNumber: ","67", "Type: ","org.eclipse.jdt.core.dom.VariableDeclarationStatement", "Method: ","toString", "Class: ","GuiSettings", "VariableName: ","StringBuilder", "VariableName: ","sb", "VariableName: ","StringBuilder");
        sb.append("Width : " + windowWidth + "\n");
		TemplateClass.instrum("LineNumber: ","68", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","GuiSettings");
        sb.append("Height : " + windowHeight + "\n");
		TemplateClass.instrum("LineNumber: ","69", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","GuiSettings");
        sb.append("Position : " + windowCoordinates);
		TemplateClass.instrum("LineNumber: ","70", "Type: ","org.eclipse.jdt.core.dom.ExpressionStatement", "Method: ","toString", "Class: ","GuiSettings");
        return sb.toString();
    }
}
