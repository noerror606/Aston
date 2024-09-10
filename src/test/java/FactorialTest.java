import org.example.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    public static Factorial fact;

    @BeforeAll
    public static void initFactorial() {
        fact = new Factorial();
    }

    @Test
    public void test_factorial0() {
        Assertions.assertEquals(1, fact.factorial(0));
    }

    @Test
    public void test_factorial3() {
        Assertions.assertEquals(120, fact.factorial(5));
    }

    @Test
    public void test_factorial10() {
        Assertions.assertEquals(3628800, fact.factorial(10));
    }

}
