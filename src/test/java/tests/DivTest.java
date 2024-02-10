package tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Execution(ExecutionMode.CONCURRENT)
public class DivTest {
    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End Dividing Tests");
    }

    @ParameterizedTest(name = "Test division with long inputs: {0} / {1} = {2}")
    @CsvSource({"6, 3, 2", "10, 2, 5", "-8, 2, -4"})
    public void testDivLong(long a, long b, long expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    @ParameterizedTest(name = "Test division with double inputs: {0} / {1} = {2}")
    @CsvSource({"6.0, 3.0, 2.0", "10.0, 2.0, 5.0", "-8.0, 2.0, -4.0"})
    public void testDivDouble(double a, double b, double expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivByZero() {
        assertThrows(NumberFormatException.class, () -> calculator.div(5L, 0L));
    }

}
