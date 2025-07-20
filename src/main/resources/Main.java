import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"zero", "2", "3", "4"}, {"tuk-tuk", "six", "7", "8"}, {"9", "10", "opa", "12"}};
        System.out.println("Summa of the array is " + MyArray.sumUpArray(arr) + "\n");

        //generate ArrayIndexOutOfBoundsException
        try {
            int i = 0;
            int j = 0;
            try {
                for (i = 0; i < arr.length; i++) {
                    for (j = 0; j <= arr[i].length; j++) {
                        System.out.println(arr[i][j]);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException(i, j);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}