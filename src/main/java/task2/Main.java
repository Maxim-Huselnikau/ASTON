package task2;

public class Main {
    public static void main(String[] args) {
        //Circle
        Circle circle = new Circle(3, "red", "blue");
        System.out.println("Circle perimeter: " + circle.perimeter(circle.getRadius()));
        System.out.println("Circle area:" + circle.area(circle.getRadius()));
        System.out.println("Border color of the circle is: " + circle.getBorderColor());
        System.out.println("Fill color of the circle is: " + circle.getFillColor() + "\n");

        //Triangle
        Triangle triangle = new Triangle(2, 4, 1, 2, "color1", "color2");
        System.out.println("Triangle perimeter: " + triangle.perimeter(triangle));
        System.out.println("Triangle area:" + triangle.area(triangle));
        System.out.println("Border color of the triangle is: " + triangle.getBorderColor());
        System.out.println("Fill color of the triangle is: " + triangle.getFillColor() + "\n");

        //Rectangle
        Rectangle rectangle = new Rectangle(2, 2, "color3", "color4");
        System.out.println("Rectangle area: " + rectangle.area(rectangle));
        System.out.println("Rectangle perimeter: " + rectangle.perimeter(rectangle));
        System.out.println("Border color of the rectangle is: " + rectangle.getBorderColor());
        System.out.println("Fill color of the rectangle is: " + rectangle.getFillColor());
    }
}