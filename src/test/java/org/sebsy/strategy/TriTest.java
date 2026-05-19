package org.sebsy.strategy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TriTest {

    @Test
    public void testBubbleSort() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(1, actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSort() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(2, actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectionSort() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(3, actual);

        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownSortTypeThrows() {
        Tri tri = new Tri();
        Integer[] actual = {1, 2, 3};

        tri.exec(99, actual);
    }
}
