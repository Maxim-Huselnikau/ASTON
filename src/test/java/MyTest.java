import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {

    @Test(groups = {"factorial"})
    public void getZeroFactorialTest() {
        Assert.assertEquals(Main.getFactorial(0), 1);
    }

    @Test(groups = {"factorial"})
    public void getFactorialOfOneTest() {
        Assert.assertEquals(Main.getFactorial(1), 1);
    }

    @Test(groups = {"factorial"})
    public void getFactorialOfFiveTest() {
        Assert.assertEquals(Main.getFactorial(5), 120);
    }

    @Test(groups = {"trangle"})
    public void getTrangleAreaTest() {
        Assert.assertEquals(Main.getTriangleArea(2, 1), 1);
    }

    @Test(groups = "sumUp", dataProvider = "sumUp", dataProviderClass = Data.class)
    public void getSumUpTest(int number1, int number2, int sum) {
        Assert.assertEquals(Main.sumUp(number1, number2), sum);
    }

    @Test(groups = {"compare"})
    public void compareEqualNumbersTest() {
        Assert.assertTrue(Main.compare(2,2));
    }

    @Test(groups = {"compare"})
    public void compareNotEqualNumbersTest() {
        Assert.assertFalse(Main.compare(2,1));
    }
}
