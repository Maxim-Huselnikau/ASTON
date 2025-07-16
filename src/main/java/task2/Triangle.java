package task2;

import task2.utils.Figure;
import task2.utils.TriangleMeasurable;

public class Triangle extends Figure implements TriangleMeasurable {
    private double sideA;
    private double sideB;
    private double sideC;
    private double heightToBase;

    public Triangle(String borderColor, String fillColor) {
        super(borderColor, fillColor);
    }

    public Triangle(double sideA, double sideB, double sideC, String borderColor, String fillColor) {
        super(borderColor, fillColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(double baseLength, double heightToThisBase, String borderColor, String fillColor) {
        super(borderColor, fillColor);
        this.heightToBase = heightToThisBase;
        sideB = baseLength;
    }

    public Triangle(double sideA, double sideB, double sideC, double heightToThisBase, String borderColor, String fillColor) {
        super(borderColor, fillColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.heightToBase = heightToThisBase;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getHeightToB() {
        return heightToBase;
    }

    public void setHeightToB(double heightToB) {
        this.heightToBase = heightToB;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
