package org.example;

import java.util.Arrays;

public class MergeSort {

    /* O(nlogn)
    Алгоритм разбивает список на две части, каждую из них он разбивает ещё на две и так далее,
    пока не останутся единичные элементы.
    Массив из одного элемента считается упорядоченным.
    Соседние элементы сравниваются и соединяются вместе.
    Так происходит до тех пор, пока все элементы не будут отсортированы.*/

    public void sort(int[] arrayValues) {
        if (arrayValues.length < 2) {
            return;
        }
        int middle = arrayValues.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[arrayValues.length - middle];
        // заполняем массивы
        for (int i = 0; i < middle; i++) {
            leftArray[i] = arrayValues[i];
        }
        for (int i = middle; i < arrayValues.length; i++) {
            rightArray[i - middle] = arrayValues[i];
        }
        sort(leftArray);
        sort(rightArray);
        merge(arrayValues, leftArray, rightArray);
    }

    public void merge(int[] arrayValues, int[] leftArray, int[] rightArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arrayValues[k++] = leftArray[i++];
            } else {
                arrayValues[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            arrayValues[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arrayValues[k++] = rightArray[j++];
        }
        System.out.println("Array: " + Arrays.toString(arrayValues));
    }
}