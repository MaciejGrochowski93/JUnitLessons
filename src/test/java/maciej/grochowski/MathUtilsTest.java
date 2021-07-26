package maciej.grochowski;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When testing class MathUtil")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils utils;
    TestInfo testInfo;
    TestReporter testReporter;
    int a = 1;

//    @BeforeAll
//    static void beforeAllInit() {
//        System.out.println("BeforeAll starting");
//    }
//
//    @AfterAll
//    static void afterAllCleanUp() {
//        System.out.println("AfterAll starting");
//    }

    @AfterEach
    void cleanUp() {

    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        utils = new MathUtils();
        testReporter.publishEntry(testInfo.getDisplayName() + ", from Tag: " + testInfo.getTags() + "\n");
    }

    @Test
    @DisplayName("Testing add() method")
    @Tag("Math")
    void addTest() {
        int expected = 2;
        int actual = utils.add(1, 1);

        assertEquals(expected, actual);

        expected = 3;
        actual = utils.add(2, 1);

        assertEquals(expected, actual);
    }

    @Nested
    @DisplayName("Testing add method")
    class AddTestClass {

        @Test
        @DisplayName("When testing positive numbers")
        void addPositive() {
            assertEquals(5, utils.add(3, 2));
        }

        @Test
        @DisplayName("When testing negative numbers")
        void addNegative() {
            assertEquals(-8, utils.add(-10, 2));
        }
    }

    @Test
    @Disabled
    @DisplayName("TDD test, shouldn't run")
    void testDisabled() {
        fail("Should be disabled");
//        System.out.println("It shouldn't appear");
    }

    @RepeatedTest(3)
    @Tag("Math")
    @DisplayName("Testing if 2 multiplied negatives return positive")
    void multiplyNegative(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 2) {
            System.out.println("It's 2nd repetition");
        } else {
            System.out.println("It's not 2nd repetition");
        }
        assertEquals(6, utils.multiply(-3, -2), "Should return positive number");
    }

    @Test
    @DisplayName("Multiply test")
    void multiply() {
        assertAll(
                () -> assertEquals(2, utils.multiply(2, 1)),
                () -> assertEquals(0, utils.multiply(15, 0)),
                () -> assertEquals(-5, utils.multiply(5, -1))
        );
    }

    @Test
    void calculateCircleAreaTest() {
        boolean isRegistered = true;
        double expected = 314.1592653589793;
        double actual = utils.calculateCircleArea(10);

        assumeTrue(isRegistered);
        assertEquals(expected, actual,
                () -> "Should return " + expected + ", but returned " + actual);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void divideTest() {
        assertThrows(ArithmeticException.class, () -> utils.divide(2, 0), "Divide by 0 should throw Arithmetic exception");
    }
}