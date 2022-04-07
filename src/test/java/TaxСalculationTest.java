import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculationTest {
    TaxСalculation sut;
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void firstStage() {
        System.out.println("Running Tests");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void finalStage() {
        System.out.println("Tests complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        sut = new TaxСalculation();
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @Test
    public void taxEarningsTest() {
        double earnings = 268.8;
        double expected = 16.128;

        double result = sut.taxEarnings(earnings);

        assertEquals(expected, result);
    }

    @Test
    public void earningsMinusSpendingTest() {
        double earnings = 598.0;
        double spendings = 38.0;
        double expected = 560.0;

        double result = sut.earningsMinusSpending(earnings, spendings);

        assertEquals(expected, result);

    }

    @Test
    public void taxEarningsMinusSpendingTest() {
        double eMs = 268;
        double expected = 40.2;

        double result = sut.taxEarningsMinusSpending(eMs);

        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("source")
    public void taxEarningsMinusSpendingTest(double eMs, double expected) {

        double result = sut.taxEarningsMinusSpending(eMs);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(268, 40.2), Arguments.of(857, 128.55));
    }

    @org.junit.jupiter.api.Test
    void TaxСalculation() {

    }

}