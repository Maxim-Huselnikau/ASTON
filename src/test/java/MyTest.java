import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyTest {
    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }

    @DisplayName("check factorial function")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120"
    })
    public void getZeroFactorialTest(int factor, int expected) {
        Assertions.assertEquals(expected, Helper.getFactorial(factor));
    }

    @DisplayName("check triangle area function")
    @ParameterizedTest
    @CsvSource({
            "2, 1, 1"
    })
    public void getTrangleAreaTest(int firstSide, int secondSide, int expected) {
        Assertions.assertEquals(expected, Helper.getTriangleArea(firstSide, secondSide));
    }

    @Description("check sum up function")
    @ParameterizedTest
    @CsvSource({
            "2, 1, 3"
    })
    public void getSumUpTest(int firstNumber, int secondNumber, int expected) {
        Assertions.assertEquals(expected, Helper.sumUp(firstNumber, secondNumber));
    }

    @Description("check deduct function")
    @ParameterizedTest
    @CsvSource({
            "2, 1, 1"
    })
    public void getDeductTest(int firstNumber, int secondNumber, int expected) {
        Assertions.assertEquals(expected, Helper.deduct(firstNumber, secondNumber));
    }

    @Description("check multiply function")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 4"
    })
    public void getMultiplyTest(int firstNumber, int secondNumber, int expected) {
        Assertions.assertEquals(expected, Helper.multiply(firstNumber, secondNumber));
    }

    @Description("check divide function")
    @ParameterizedTest
    @CsvSource({
            "6, 2, 3"
    })
    public void getDivideTest(int firstNumber, int secondNumber, int expected) {
        Assertions.assertEquals(expected, Helper.divide(firstNumber, secondNumber));
    }

    @Description("check compare function / use equal numbers")
    @ParameterizedTest
    @CsvSource({
            "2, 2"
    })
    public void compareEqualNumbersTest(int firstNumber, int secondNumber) {
        Assertions.assertTrue(Helper.compare(2, 2));
    }

    @Description("check compare function / use not equal numbers")
    @ParameterizedTest
    @CsvSource({
            "2, 1"
    })
    public void compareNotEqualNumbersTest(int firstNumber, int secondNumber) {
        Assertions.assertFalse(Helper.compare(2, 1));
    }
}
