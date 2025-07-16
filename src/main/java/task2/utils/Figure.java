package task2.utils;

public abstract class Figure {
    private String borderColor;
    private String fillColor;

    public Figure(String borderColor, String fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
