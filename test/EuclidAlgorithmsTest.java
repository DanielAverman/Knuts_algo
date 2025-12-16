import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EuclidAlgorithmsTest {

    @Test
    public void testGCD_PositiveNumbers() {
        assertEquals(1, EuclidAlgorithms.GCD(7, 1));
        assertEquals(3, EuclidAlgorithms.GCD(9, 6));
        assertEquals(5, EuclidAlgorithms.GCD(25, 5));
        assertEquals(12, EuclidAlgorithms.GCD(48, 60));
    }

    @Test
    public void testGCD_NegativeNumbers() {
        assertEquals(5, EuclidAlgorithms.GCD(-25, 5));
        assertEquals(3, EuclidAlgorithms.GCD(9, -6));
        assertEquals(1, EuclidAlgorithms.GCD(-7, -1));
    }

    @Test
    public void testGCD_Zero() {
        assertThrows(ArithmeticException.class, () -> EuclidAlgorithms.GCD(5, 0));
        assertThrows(ArithmeticException.class, () -> EuclidAlgorithms.GCD(0, 0));
    }

    @Test
    public void testGCD_recursive_PositiveNumbers() {
        assertEquals(1, EuclidAlgorithms.GCD_recursive(7, 1));
        assertEquals(3, EuclidAlgorithms.GCD_recursive(9, 6));
        assertEquals(5, EuclidAlgorithms.GCD_recursive(25, 5));
        assertEquals(12, EuclidAlgorithms.GCD_recursive(48, 60));
    }

    @Test
    public void testGCD_recursive_NegativeNumbers() {
        assertEquals(5, EuclidAlgorithms.GCD_recursive(-25, 5));
        assertEquals(3, EuclidAlgorithms.GCD_recursive(9, -6));
        assertEquals(1, EuclidAlgorithms.GCD_recursive(-7, -1));
    }

    @Test
    public void testGCD_recursive_Zero() {
        assertThrows(ArithmeticException.class, () -> EuclidAlgorithms.GCD_recursive(5, 0));
        assertThrows(ArithmeticException.class, () -> EuclidAlgorithms.GCD_recursive(0, 0));
    }

    @Test
    public void testExtendedGCD_PositiveNumbers() {
        long[] result = EuclidAlgorithms.extendedGCD(1769, 551);
        checkExtendedGCDResults(result);
    }

    @Test
    public void testExtendedGCD_NegativeNumbers() {
        long[] result = EuclidAlgorithms.extendedGCD(-1769, 551);
        checkExtendedGCDResults(result);
    }

    @Test
    public void testExtendedGCD_ZeroNumbers() {
        assertThrows(ArithmeticException.class, () -> EuclidAlgorithms.extendedGCD(-1769, 0));
    }

    private static void checkExtendedGCDResults(long[] result) {
        //result[a, m, b, n, d]
        long a = result[0];
        long m = result[1];
        long b = result[2];
        long n = result[3];
        long d = result[4];

        assertEquals(d, a*m + b*n);
        assertEquals(0, m % d);
        assertEquals(0, n % d);
    }
}
