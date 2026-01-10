package sample;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorsJUnit5Test {

    @Test
    public void testScalarMultiplication() {
        System.out.println("scalarMultiplication");
        assertEquals(0, Vectors.scalarMultiplication(new int[]{0, 0}, new int[]{10, 20}));
        assertEquals(10, Vectors.scalarMultiplication(new int[]{1, 2}, new int[]{2, 4}));
        assertEquals(-1, Vectors.scalarMultiplication(new int[]{1, -1}, new int[]{2, 3}));
    }

    @Test
    public void equalsCheck() {
        System.out.println("equalsCheck");
        assertTrue(Vectors.equal(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        assertFalse(Vectors.equal(new int[]{1, 2, 3}, new int[]{0, 0, 0}));
        assertFalse(Vectors.equal(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}