package tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class PowTest {

    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End Power Tests");
    }

    @ParameterizedTest(name = "Powered test with double inputs: {0} ^ {1} = {2}")
    @CsvSource({"2.0, 3.0, 8.0", "0.0, 0.0, 1.0", "-5.0, 5.0, -3125.0"})
    public void testSumLong(double a, double b, double expected) {
        assertEquals(expected, calculator.pow(a, b));
    }

}
