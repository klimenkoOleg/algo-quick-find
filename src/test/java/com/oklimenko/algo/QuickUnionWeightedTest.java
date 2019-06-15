package com.oklimenko.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class QuickUnionWeightedTest {

    @Test
    public void shouldJoin() {
        QuickUnionWeighted quickUnion = new QuickUnionWeighted(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);

        assertThat(quickUnion.isConnected(8, 9)).isTrue();
        assertThat(quickUnion.isConnected(5, 4)).isFalse();
        assertThat(quickUnion.isConnected(4, 8)).isTrue();
        assertThat(quickUnion.isConnected(8, 4)).isTrue();

        quickUnion.union(5, 0);
        quickUnion.union(7, 2);
        quickUnion.union(6, 1);


        // check | 1 | 1 | 1 | 8 | 3 | 0 | 5 | 1 | 8 | 8
//        int target[] = { 1, 1, 1, 8, 3, 0, 5, 1, 8, 8};
//        isStreamsEqual(quickUnion.stream(), Arrays.stream(target));


        quickUnion.union(7, 3);

        // check | 1 | 8 | 1 | 8 | 3 | 0 | 5 | 1 | 8 | 8
//        int target2[] = { 1, 8, 1, 8, 3, 0, 5, 1, 8, 8};
//        isStreamsEqual(quickUnion.stream(), Arrays.stream(target2));

        System.out.println(quickUnion);
    }


    private void isStreamsEqual(Stream quickUnion, Stream target) {
        Iterator iter1 = quickUnion.iterator();
        Iterator iter2 = target.iterator();

        while(iter1.hasNext() && iter2.hasNext()) {
            assertThat(iter1.next()).isEqualTo(iter2.next());
        }
        assertThat(!iter1.hasNext() && !iter2.hasNext()) .isTrue();
    }
}
