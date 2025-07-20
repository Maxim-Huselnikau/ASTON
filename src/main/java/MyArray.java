import java.util.ArrayList;
import java.util.List;

public class MyArray {

    public static void checkSizeArray(String[][] arr) {
        try {
            if (arr.length != 4) {
                throw new MyArraySizeException("Wrong size of array. The size is " + arr.length + ". Expected: 4");
            }else System.out.println("Array size is " + arr.length + ". This is good");
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumUpArray(String[][] arr) {
        checkSizeArray(arr);
        List<MyArrayDataException> errors = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    errors.add(new MyArrayDataException(i, j, arr[i][j]));
                }
            }
        }
        printArrayInfo(errors);
        return sum;
    }

    public static void printArrayInfo(List<MyArrayDataException> errors) {
        try {
            if (!errors.isEmpty()) {
                for (MyArrayDataException e : errors) {
                    System.out.println(e.getMessage());
                }
                throw new MyArrayDataException();
            } else System.out.println("There are no errors");
        } catch (MyArrayDataException ignored) {
        }
    }

}
