package edu.tomerbu.addteststopeviousprojects.algorithms.sorting;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Scope("prototype")
@Primary
@Component
public class QuickSortImpl<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] arr) {
        System.out.println("QuickSortImpl");
        T[] copy = Arrays.copyOf(arr, arr.length);
        quicksort(copy, 0, copy.length - 1);
        return copy;
    }

    private void quicksort(T[] array, int startIndex, int endIndex) {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex) {
            // calculate the pivotIndex
            int pivotIndex = partition(array, startIndex, endIndex);
            // sort the left sub-array
            quicksort(array, startIndex, pivotIndex);
            // sort the right sub-array
            quicksort(array, pivotIndex + 1, endIndex);
        }
    }

    private int partition(T[] array, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true) {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (array[startIndex].compareTo(pivotValue) < 0);

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (array[endIndex].compareTo(pivotValue) > 0);

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
}
