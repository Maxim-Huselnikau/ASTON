package task2;

import task2.utils.CircleMeasurable;
import task2.utils.Figure;

public class Circle extends Figure implements CircleMeasurable {
    private double radius;

    public Circle(String borderColor, String fillColor) {
        super(borderColor, fillColor);
    }

    public Circle(double radius, String borderColor, String fillColor) {
        super(borderColor, fillColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
