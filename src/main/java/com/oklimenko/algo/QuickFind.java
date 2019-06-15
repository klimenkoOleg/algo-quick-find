package com.oklimenko.algo;

/**
 * Approach 1. Eager approach. Slow O(N^2) to touch each element.
 */
public class QuickFind {

    private final int[] array;

    /**
     * O(N) complexity to initialize.
     * @param size
     */
    public QuickFind(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    /**
     * O(1) complexity.
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return array[p] == array[q];
    }

    /**
     * O(N) - complexity to change array.
     * This is N^2 - quadratic - to access array by index..
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int oldValue = array[p];
        int newValue = array[q];
        for (int i = 0; i<array.length; i++) {
            if (array[i] == oldValue) {
                array[i] = newValue;
            }
        }
    }

}
