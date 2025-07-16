package task2.utils;

import task2.Rectangle;

public interface RectangleMeasurable {
    default double perimeter(double width, double height) {
        return 2 * (width + height);
    }

    default double perimeter(Rectangle rectangle) {
        return 2 * (rectangle.getWidth() + rectangle.getHeight());
    }

    default double area(double width, double height) {
        return width * height;
    }

    default double area(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }
}
