package org.example;

public class BinarySearch {

    // O(logn)
    public int searchByRecurs(int[] sortedArray, int valueToFind, int from, int to) {

        if (from == to) {
            return (sortedArray[from] == valueToFind) ? from : -1;
        }

        int middle = from + (to - from) / 2;

        if (valueToFind > sortedArray[middle]) {
            return searchByRecurs(sortedArray, valueToFind, middle + 1, to);
        } else if (sortedArray[middle] > valueToFind) {
            return searchByRecurs(sortedArray, valueToFind, from, middle - 1);
        }
        return middle;
    }
}