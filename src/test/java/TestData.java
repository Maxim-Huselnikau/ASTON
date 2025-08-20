import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

    @DataProvider(name = "sumUp")
    @Test
    public Object[][] sumUp() {
        return new Object[][]{
                {2, 1, 3},
                {10, 15, 25}
        };
    }

    @DataProvider(name = "deduct")
    @Test
    public Object[][] deduct() {
        return new Object[][]{
                {2, 1, 1},
                {10, 15, -5}
        };
    }

    @DataProvider(name = "multiply")
    @Test
    public Object[][] multiply() {
        return new Object[][]{
                {2, 1, 2},
                {10, 15, 150}
        };
    }

    @DataProvider(name = "divide")
    @Test
    public Object[][] divide() {
        return new Object[][]{
                {2, 1, 2},
                {10, 2, 5}
        };
    }

}
