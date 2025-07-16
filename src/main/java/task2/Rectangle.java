package task2;

import task2.utils.Figure;
import task2.utils.RectangleMeasurable;

public class Rectangle extends Figure implements RectangleMeasurable {
    private double width;
    private double height;

    public Rectangle(String borderColor, String fillColor) {
        super(borderColor, fillColor);
    }

    public Rectangle(double width, double height, String borderColor, String fillColor) {
        super(borderColor, fillColor);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}