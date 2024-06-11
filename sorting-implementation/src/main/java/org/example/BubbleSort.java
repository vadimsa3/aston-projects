package org.example;

public class BubbleSort {

    // O(n2)
    public int[] sort(int[] arrayValues) {
        int n = arrayValues.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arrayValues[j - 1] > arrayValues[j]) {
                    temp = arrayValues[j - 1];
                    arrayValues[j - 1] = arrayValues[j]; // меняем местами
                    arrayValues[j] = temp; // // меняем местами
                }
            }
        }
        return arrayValues;
    }
}
