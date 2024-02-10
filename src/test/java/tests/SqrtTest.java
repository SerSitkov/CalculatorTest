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
    public class SqrtTest {
        static Calculator calculator;

        @BeforeAll
        public static void prepTest() {
            calculator = new Calculator();
        }

        @AfterAll
        public static void afterAll() {
            System.out.println("End Sqrt Tests");
        }


        @ParameterizedTest(name = "Test sqrt with double input: sqrt {0} = {1}")
        @CsvSource({"25.0, 5.0", "0.0, 0.0", "-625.0, 25.0"})
        public void testSqrtDouble(double a, double expected) {
            assertEquals(expected, calculator.sqrt(a));
        }
}
