package maciej.grochowski;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

    @BeforeEach
    void init() {
        utils = new MathUtils();
    }

//    @AfterEach
//    void cleanUp() {
//        a++;
//        System.out.println("Cleaning up");
//        System.out.println("a = " + a + "\n");
//    }

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

    @Test
    @Disabled
    @DisplayName("TDD test, shouldn't run")
    void testDisabled() {
        fail("Should be disabled");
//        System.out.println("It shouldn't appear");
    }

    @Test
    void calculateCircleAreaTest() {
        boolean isRegistered = false;
        assumeTrue(isRegistered);
        assertEquals(314.1592653589793, utils.calculateCircleArea(10), "Should return correct circle area");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void divideTest() {
        assertThrows(ArithmeticException.class, () -> utils.divide(2, 0), "Divide by 0 should throw Arithmetic exception");
    }
}