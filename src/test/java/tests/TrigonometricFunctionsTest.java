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
public class TrigonometricFunctionsTest {

    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End Trigonometric Tests");
    }


    @ParameterizedTest(name = "Test tangent with double inputs: tg {0} is {1}")
    @CsvSource({"0.0, 0.0", "180.0, 0.0", "45.0, 1.0"})
    public void testTangentOfAngle(double angleInDegrees, double expectedTangent) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        assertEquals(expectedTangent, calculator.tg(angleInRadians), 0.0001);
    }

    @ParameterizedTest(name = "Test cotangent with double inputs: сtg {0} is {1}")
    @CsvSource({"0.0, 0.0", "90.0, 0.0", "45.0, 1.0", "2250.0, 1.0"})
    void testCotangentOfAngle(double angleInDegrees, double expectedCotangent) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        assertEquals(expectedCotangent, calculator.ctg(angleInRadians), 0.0001);
    }

    @ParameterizedTest(name = "Test cosine with double inputs: cos {0} is {1}")
    @CsvSource({"90.0, 0.0", "360.0, 1.0", "45.0, 0.7071"})
    public void testCosineOfAngle(double angleInDegrees, double expectedCosine) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        assertEquals(expectedCosine, calculator.cos(angleInRadians), 0.0001);
    }

    @ParameterizedTest(name = "Test sine with double inputs: sin {0} is {1}")
    @CsvSource({"90.0, 1.0", "180.0, 0.0", "45.0, 0.7071", "109.0, 0.9455"})
    public void testSineOfAngle(double angleInDegrees, double expectedSine) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        assertEquals(expectedSine, calculator.sin(angleInRadians), 0.0001);
    }
}
