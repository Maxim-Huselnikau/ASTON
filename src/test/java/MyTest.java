import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyTest {
    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }

    @Test
    public void getZeroFactorialTest() {
        Assertions.assertEquals(1, Main.getFactorial(0));
    }

    @Test
    public void getFactorialOfOneTest() {
        Assertions.assertEquals(1, Main.getFactorial(1));
    }

    @Test
    public void getFactorialOfFiveTest() {
        Assertions.assertEquals(120, Main.getFactorial(5));
    }

    @Test
    public void getTrangleAreaTest() {
        Assertions.assertEquals(1, Main.getTriangleArea(2, 1));
    }

    @Test
    public void getSumUpTest() {
        Assertions.assertEquals(3, Main.sumUp(1, 2));
    }

    @Test
    public void compareEqualNumbersTest() {
        Assertions.assertTrue(Main.compare(2, 2));
    }

    @Test
    public void compareNotEqualNumbersTest() {
        Assertions.assertFalse(Main.compare(2, 1));
    }
}
