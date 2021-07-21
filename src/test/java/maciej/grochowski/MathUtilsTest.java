package maciej.grochowski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    }}