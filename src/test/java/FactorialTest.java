import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.*;

public class FactorialTest {
    private Factorial fact;

    @BeforeMethod
    public void initFactorial() {
        fact = new Factorial();
    }

    @Test
    public void test_factorial0() {
        Assert.assertEquals(1, fact.factorial(0));
    }

    @Test
    public void test_factorial3() {
        Assert.assertEquals(120, fact.factorial(5));
    }

    @Test
    public void test_factorial10() {
        Assert.assertEquals(3628800, fact.factorial(10));
    }

}
