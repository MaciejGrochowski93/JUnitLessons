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
        a++;
        System.out.println("Cleaning up");
        System.out.println("a = " + a + "\n");
    }

    @BeforeEach
    void init() {
        utils = new MathUtils();
    }

    @Test
    @DisplayName("Testing add() method")
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