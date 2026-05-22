package org.sebsy.strategy;

public class InsertionSortStrategy implements SortStrategy {

    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int k = 1; k < arr.length; k++) {
            int temp = arr[k];
            int j = k - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
