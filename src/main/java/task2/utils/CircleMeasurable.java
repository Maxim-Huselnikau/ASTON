package task2.utils;

import task2.Circle;

public interface CircleMeasurable {
    default double perimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    default double perimeter(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }

    default double area(double radius) {
        return Math.PI * radius * radius;
    }

    default double area(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }
}
