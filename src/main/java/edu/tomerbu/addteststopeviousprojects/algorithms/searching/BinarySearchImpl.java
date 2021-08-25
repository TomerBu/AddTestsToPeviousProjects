package edu.tomerbu.addteststopeviousprojects.algorithms.searching;

import edu.tomerbu.addteststopeviousprojects.algorithms.sorting.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class BinarySearchImpl<T extends Comparable<T>> implements Search<T> {

    @Autowired
    @Qualifier("sort")
    Sort<T> sort;

    @Override
    public int search(T[] arr, T term) {
        T[] sortedArray = sort.sort(arr);
        return search(sortedArray, term, 0, arr.length);
    }

    private int midPoint(int min, int max) {
        return min + (max - min) / 2;
    }

    public int search(T[] a, T key, int min, int max) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int mid = midPoint(min, max);
        if (mid > max || mid < min) {
            return -1;
        }

        if (a[mid].compareTo(key) > 0) {
            return search(a, key, min, mid - 1);
        } else if (a[mid].compareTo(key) < 0) {
            return search(a, key, mid + 1, max);
        } else {
            return mid;
        }
    }
}
