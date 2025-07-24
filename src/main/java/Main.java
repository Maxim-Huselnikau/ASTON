public class Main {
    public static void main(String[] args) {

    }

    public static int getFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int getTriangleArea(int base, int height) {
        return (base * height) / 2;
    }

    public static int sumUp(int number1, int number2) {
        return number1 + number2;
    }

    public static boolean compare(int number1, int number2) {
        return number1 == number2;
    }

}