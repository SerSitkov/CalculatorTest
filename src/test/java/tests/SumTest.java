package tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SumTest {
    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End Sum Tests");
    }


    @ParameterizedTest(name = "Test sum with long inputs: {0} + {1} = {2}")
    @CsvSource({"2, 3, 5", "0, 0, 0", "-5, 5, 0"})
    public void testSumLong(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @ParameterizedTest(name = "Test sum with double inputs: {0} + {1} = {2}")
    @CsvSource({"2.0, 3.0, 5.0", "0.0, 0.0, 0.0", "-5.0, 5.0, 0.0"})
    public void testSumDouble(double a, double b, double expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

}
