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
public class PositiveNegativeTest {
    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End Positive and Negative Tests");
    }


    @ParameterizedTest(name = "Test positive values with long inputs: value {0} is {1}")
    @CsvSource({"2, true", "3, true", "5, true", "0, false", "-5, false", "-145, false", "-20, false"})
    public void testPositiveLong(long a, boolean expected) {
        assertEquals(expected, calculator.isPositive(a));
    }

    @ParameterizedTest(name = "Test negative values with long inputs: value {0} is {1}")
    @CsvSource({"2, false", "3, false", "5, false", "0, false", "-5, true", "-145, true", "-20, true"})
    public void testNegativeLong(long a, boolean expected) {
        assertEquals(expected, calculator.isNegative(a));
    }

}
