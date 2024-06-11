package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        int valueToFind = 18;
        int from = 0;
        int to = createSortedArray(20).length - 1;
        System.out.println("BinarySearch");
        System.out.printf("Index valueToFind by binarySearch = %d%n", binarySearch.searchByRecurs(createSortedArray(20),
                valueToFind, from, to));

        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayValues1 = {3, 15, 1, 4, 2, 11, 5, 14, 7, 12, 8, 13};
        System.out.println("\n" + "BubbleSort");
        System.out.println("Unsorted array: " + Arrays.toString(arrayValues1));
        System.out.println("Sorted array: " + Arrays.toString(bubbleSort.sort(arrayValues1)));

        QuickSort quickSort = new QuickSort();
        int[] arrayValues2 = {3, 15, 1, 4, 2, 11, 5, 14, 7, 12, 8, 13};
        int to1 = arrayValues2.length - 1;
        System.out.println("\n" + "QuickSort");
        System.out.println("Unsorted array: " + Arrays.toString(arrayValues2));
        System.out.println("Sorted array: " + Arrays.toString(quickSort.sort(arrayValues2, from, to1)));

        MergeSort mergeSort = new MergeSort();
        int[] arrayValues3 = {3, 1, 4, 2, 11, 5};
        System.out.println("\n" + "MergeSort");
        System.out.println("Unsorted array: " + Arrays.toString(arrayValues3));
        mergeSort.sort(arrayValues3);
    }

    public static int[] createSortedArray(int arrayLength) {
        int[] values = new int[arrayLength];
        for (int i = 1; i < values.length; i++) {
            values[i] = i;
        }
        Arrays.sort(values);
        return values;
    }
}