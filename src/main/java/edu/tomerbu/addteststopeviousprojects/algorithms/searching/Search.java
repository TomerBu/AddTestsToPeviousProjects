package edu.tomerbu.addteststopeviousprojects.algorithms.searching;

import org.springframework.stereotype.Component;

@Component
public interface Search<T extends Comparable<T>> {
    /**
     * A Search interface for arrays:
     *
     * @param arr  the array to search
     * @param term the element you want found
     * @return the index of the found item, -1 if not found
     */
    int search(T[] arr, T term);
}
