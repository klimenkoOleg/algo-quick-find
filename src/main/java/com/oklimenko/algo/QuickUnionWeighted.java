package com.oklimenko.algo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Approach 3. Modify quick-union to avoid tall trees.
 * Keeps track of size of each tree (number of objects).
 * Balance by linking root of smaller tree to root of larger tree.
 *
 * Proposition: depth of any node x is at most log N (base 2).
 * N=10, depth(x) = 3 * log N.
 * 1000, log(1000) = ...  2^10 = 1024, so log(1000)~10, 256, 512
 * log(1_000_000) = ..., 11-2048, 12-8000, 13-16000, 14-32000, 15-64000, 16-128000, 17-256000. 18-512000, 19-1024000
 *
 * @author Oleg Klimenko
 */
public class QuickUnionWeighted {

    @Data
    @Accessors(chain = true)
    private class Item {
        int root;
        int weight;
    }

    private final Item[] array;

    /** O(N)
     * @param size
     */
    public QuickUnionWeighted(int size) {
        array = new Item[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Item().setRoot(i).setWeight(1);
        }
    }

    /**
     * O(lg N) - as per cost of finding roots.
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /**
     * This give O(lg N).
     * @param i
     * @return
     */
    private int getRoot(int i) {
        while (i != array[i].getRoot()) {
            i = array[i].root;
        }
        return i;
    }

    /**
     * O(lg N)
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        if (array[rootP].root == array[rootQ].root) {
            return;
        }
        if (array[rootP].weight < array[rootQ].weight) {
            array[rootP].root = rootQ;
            array[rootQ].weight += array[rootP].weight;
        } else {
            array[rootQ].root = rootP;
            array[rootP].weight += array[rootQ].weight;
        }
    }

    public int get(int i) {
        return array[i].getRoot();
    }

    public Stream<Item> stream() {
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
