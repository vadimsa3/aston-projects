package org.example;

public class QuickSort {

    /*
    O(nlogn)
    Выбираем опорный элемент (pivot) в массиве (обычно это средний элемент, но также можно выбрать “опору” случайным образом.
    Проще всего — просто выбрать первый или последний элемент.).
    Начинаем разделение. Делим массив на две части таким образом, что элементы, которые меньше опорного,
    перемещаются влево от него, а те, которые больше — вправо.
    Повторяем процесс рекурсивно для левой и правой части массива до тех пор,
    пока каждая часть не будет состоять из одного элемента.
   */

    public int[] sort(int[] arrayValues, int from, int to) {
        if (from < to) {
            int pivotElement = partition(arrayValues, from, to); // опорный элемент
            sort(arrayValues, from, pivotElement - 1); // для левой части
            sort(arrayValues, pivotElement + 1, to); // для правой части
        }
        return arrayValues;
    }

    /*
    Метод определяет положение опорного элемента (здесь выбран последний элемент массива)
    и переставляет элементы так, чтобы элементы меньше опорного находились слева от него, а большие — справа.
    Этот метод возвращает индекс опорного элемента после перестановки.
    */

    public static int partition(int[] arrayValues, int from, int to) {
        int middleElement = from + (to - from) / 2;
        int pivot = arrayValues[middleElement];

        int temp = arrayValues[middleElement];
        arrayValues[middleElement] = arrayValues[to];
        arrayValues[to] = temp;

        int i = (from - 1);
        for (int j = from; j <= to; j++) {
            if (arrayValues[j] < pivot) {
                i++;
                temp = arrayValues[i];
                arrayValues[i] = arrayValues[j];
                arrayValues[j] = temp;
            }
        }

        temp = arrayValues[i + 1];
        arrayValues[i + 1] = arrayValues[to];
        arrayValues[to] = temp;

        return i + 1;
    }
}