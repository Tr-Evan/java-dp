package org.sebsy.strategy;

public class DemoTri {

    public static void main(String[] args) {
        Tri tri = new Tri();

        System.out.println("Avec le Bubble Sort:");
        Integer[] array1 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        tri.exec(new BubbleSortStrategy(), array1);
        printArray(array1);

        System.out.println("\nAvec l'insertion Sort:");
        Integer[] array2 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        tri.exec(new InsertionSortStrategy(), array2);
        printArray(array2);

        System.out.println("\nAvec le selection Sort:");
        Integer[] array3 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        tri.exec(new SelectionSortStrategy(), array3);
        printArray(array3);
    }

    private static void printArray(Integer[] array) {
        for (Integer element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
