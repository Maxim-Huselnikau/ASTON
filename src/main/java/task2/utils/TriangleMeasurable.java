package task2.utils;

import task2.Triangle;

public interface TriangleMeasurable {
    default double perimeter(Triangle triangle) {
        return triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
    }

    default double area(Triangle triangle) {
        return 0.5 * triangle.getSideB() * triangle.getHeightToB();
    }
}
