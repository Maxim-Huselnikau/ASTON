public class Main {
    public static void main(String[] args) {
//        printThreeWords();
//        checkSumSign();
//        printColor();
//        compareNumbers();
//        sumLayBetween10and20(0, 0);
//        isPositive(0);
//        isNegative(0);
//        printString(5, "Hello World");
//        isLeapYear(2100);

//Task #10
        /*int[] arr= {1,0,1,1,0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1) {
                arr[i]=0;
            }else arr[i]=1;
        }*/

//Task #11
        /*int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));*/

//Task #12
        /*int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }*/

//Task #13
        /*int[][] arr = new int[5][5];
        int a=0;
        int b=arr.length-1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j==b&&a==i) {
                    arr[i][j] = 1;
                }
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
            a++;
            b--;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

//Task #14
//        createArray(5, 3);

    }


    public static void printThreeWords() {
        System.out.println("Orange\n" + "Banana\n" + "Apple");
    }

    public static void checkSumSign() {
        int a = 0;
        int b = 0;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 0;
        int b = 0;
        if (a >= b) {
            System.out.println("a>=b");
        } else System.out.println("a<b");
    }

    public static boolean sumLayBetween10and20(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else return false;
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("is positive");
        } else System.out.println("is negative");
    }

    public static boolean isNegative(int a) {
        if (a >= 0) {
            return false;
        } else return true;
    }

    public static void printString(int number, String string) {
        for (int i = 0; i < number; i++) {
            System.out.println(string);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else return false;
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}