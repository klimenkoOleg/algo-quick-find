package com.oklimenko.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Approach 2. Lazy approach. Find too expensive - could be N (of tree is all tall).
 */
public class QuickUnion {

    private final int[] array;

    /** O(N)
     * @param size
     */
    public QuickUnion(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;//new int().setValue(i).setRoot(i);
        }
    }

    /**
     * O(N) read access in the worst case. Slow.
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /**
     * This give O(N) in the worst case, if tree is actually a list.
     * @param i
     * @return
     */
    private int getRoot(int i) {
        while (i != array[i]) {
            i = array[i];
        }
        return i;
    }

    /**
     * O(N) because includes cost of finding roots.
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        array[rootP] = rootQ;
    }

    public int get(int i) {
        return array[i];
    }

    public IntStream stream() {
        return Arrays.stream(array);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (int i=0; i<array.length; i++) {
            result.append(String.format("| %d ", array[i]));
        }
        return result.toString();
    }

}
