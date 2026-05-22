package org.sebsy.strategy;

public class Tri {

    public void exec(int typeTri, Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        SortStrategy strategy = resolveStrategy(typeTri);
        strategy.sort(arr);
    }

    public void exec(SortStrategy strategy, Integer[] arr) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy must not be null");
        }
        if (arr == null || arr.length < 2) {
            return;
        }

        strategy.sort(arr);
    }

    private SortStrategy resolveStrategy(int typeTri) {
        switch (typeTri) {
            case 1:
                return new BubbleSortStrategy();
            case 2:
                return new InsertionSortStrategy();
            case 3:
                return new SelectionSortStrategy();
            default:
                throw new IllegalArgumentException("Type de tri inconnu : " + typeTri);
        }
    }
}
