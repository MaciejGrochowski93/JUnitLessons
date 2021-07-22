package maciej.grochowski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilsTest {

    @Test
    void name() {
        MathUtils utils = new MathUtils();

        int expected = 2;
        int actual = utils.add(1, 1);

        assertEquals(expected, actual);

        expected = 3;
        actual = utils.add(2, 1);

        assertEquals(expected, actual);
    }

    @Test
    void testCalculateCircleArea() {
        MathUtils utils = new MathUtils();

        assertEquals(314.1592653589793, utils.calculateCircleArea(10), "Should return correct circle area");
    }

    @Test
    void divideTest() {
        MathUtils utils = new MathUtils();

        assertThrows(ArithmeticException.class, () -> utils.divide(2, 0), "Divide by 0 should throw Arithmetic exception");
        
    }
}