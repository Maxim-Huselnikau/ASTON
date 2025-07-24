import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {

    @DataProvider(name = "sumUp")
    @Test
    public Object[][] sumUp() {
        return new Object[][] {
                {2,1,3},
                {10,15,25}
        };
    }

}
