package org.sebsy.strategy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TriEdgeCasesTest {

    @Test
    public void testNullArrayDoesNotThrow() {
        Tri tri = new Tri();
        tri.exec(1, null);
        tri.exec(2, null);
        tri.exec(3, null);
    }

    @Test
    public void testEmptyArrayNoChange() {
        Tri tri = new Tri();
        Integer[] actual = new Integer[0];
        Integer[] expected = new Integer[0];

        tri.exec(1, actual);
        assertArrayEquals(expected, actual);

        tri.exec(2, actual);
        assertArrayEquals(expected, actual);

        tri.exec(3, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingleElementNoChange() {
        Tri tri = new Tri();
        Integer[] actual = {5};
        Integer[] expected = {5};

        tri.exec(1, actual);
        assertArrayEquals(expected, actual);

        tri.exec(2, actual);
        assertArrayEquals(expected, actual);

        tri.exec(3, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAlreadySortedRemainsSorted() {
        Tri tri = new Tri();
        Integer[] sorted = {-3, 0, 1, 4, 7};
        Integer[] expected = {-3, 0, 1, 4, 7};

        tri.exec(1, sorted);
        assertArrayEquals(expected, sorted);

        Integer[] sorted2 = {-3, 0, 1, 4, 7};
        tri.exec(2, sorted2);
        assertArrayEquals(expected, sorted2);

        Integer[] sorted3 = {-3, 0, 1, 4, 7};
        tri.exec(3, sorted3);
        assertArrayEquals(expected, sorted3);
    }
}
