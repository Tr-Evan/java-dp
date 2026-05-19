package org.sebsy.strategy;

public class Tri {

    public void exec(int typeTri, Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        switch (typeTri) {
            case 1:
                bubbleSort(arr);
                break;
            case 2:
                insertionSort(arr);
                break;
            case 3:
                selectionSort(arr);
                break;
            default:
                throw new IllegalArgumentException("Type de tri inconnu : " + typeTri);
        }
    }

    private void bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void insertionSort(Integer[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int temp = arr[k];
            int j = k - 1;
            while (j >= 0 && temp <= arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
