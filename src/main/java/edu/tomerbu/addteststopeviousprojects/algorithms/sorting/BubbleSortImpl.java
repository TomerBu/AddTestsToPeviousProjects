package edu.tomerbu.addteststopeviousprojects.algorithms.sorting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Qualifier("sort")
@Component
public class BubbleSortImpl<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] arr) {
        System.out.println("BubbleSortImpl");
        T[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length - i - 1; j++) {
                if (copy[j].compareTo(copy[j + 1]) > 0) {
                    T temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        return copy;
    }
}
