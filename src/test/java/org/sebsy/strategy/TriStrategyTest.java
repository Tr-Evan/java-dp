package org.sebsy.strategy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TriStrategyTest {

    @Test
    public void testBubbleSortStrategy() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(new BubbleSortStrategy(), actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortStrategy() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(new InsertionSortStrategy(), actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectionSortStrategy() {
        Tri tri = new Tri();
        Integer[] actual = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] expected = {-5, -3, 0, 4, 7, 8, 9, 12, 15};

        tri.exec(new SelectionSortStrategy(), actual);

        assertArrayEquals(expected, actual);
    }
}
