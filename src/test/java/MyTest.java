import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {

    //вычисляем факториал
    @Test(groups = {"factorial"})
    public void getZeroFactorialTest() {
        Assert.assertEquals(Helper.getFactorial(0), 1);
    }

    @Test(groups = {"factorial"})
    public void getFactorialOfOneTest() {
        Assert.assertEquals(Helper.getFactorial(1), 1);
    }

    @Test(groups = {"factorial"})
    public void getFactorialOfFiveTest() {
        Assert.assertEquals(Helper.getFactorial(5), 120);
    }

    //вычисляем площадь треугольника
    @Test(groups = {"trangle"})
    public void getTrangleAreaTest() {
        Assert.assertEquals(Helper.getTriangleArea(2, 1), 1);
    }

    //тестим арифметисеские действия
    @Test(groups = "arithmetic", dataProvider = "sumUp", dataProviderClass = TestData.class)
    public void getSumUpTest(int number1, int number2, int sum) {
        Assert.assertEquals(Helper.sumUp(number1, number2), sum);
    }

    @Test(groups = "arithmetic", dataProvider = "deduct", dataProviderClass = TestData.class)
    public void getDeductTest(int number1, int number2, int sum) {
        Assert.assertEquals(Helper.deduct(number1, number2), sum);
    }

    @Test(groups = "arithmetic", dataProvider = "multiply", dataProviderClass = TestData.class)
    public void getMultiplyTest(int number1, int number2, int sum) {
        Assert.assertEquals(Helper.multiply(number1, number2), sum);
    }

    @Test(groups = "arithmetic", dataProvider = "divide", dataProviderClass = TestData.class)
    public void getDivideTest(int number1, int number2, int sum) {
        Assert.assertEquals(Helper.divide(number1, number2), sum);
    }

    //сравнивающую два целых числа
    @Test(groups = {"compare"})
    public void compareEqualNumbersTest() {
        Assert.assertTrue(Helper.compare(2, 2));
    }

    @Test(groups = {"compare"})
    public void compareNotEqualNumbersTest() {
        Assert.assertFalse(Helper.compare(2, 1));
    }
}
