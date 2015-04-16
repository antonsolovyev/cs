package com.solovyev.cs;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.junit.Assert.*;


public class Euler26Test
{
    @Test
    public void testGetDivisionFractional() throws Exception
    {
        // 1/2 = 0.5
        Pair<List<Integer>, Integer> res = Euler26.getDivisionFractional(1, 2);
        assertEquals(new ImmutablePair<>(Arrays.asList(5), null), res);

        // 1/3 = 0.(3)
        Pair<List<Integer>, Integer> res2 = Euler26.getDivisionFractional(1, 3);
        assertEquals(new ImmutablePair<>(Arrays.asList(3), 0), res2);

        // 1/4 = 0.25
        Pair<List<Integer>, Integer> res3 = Euler26.getDivisionFractional(1, 4);
        assertEquals(new ImmutablePair<>(Arrays.asList(2, 5), null), res3);

        // 1/5 = 0.2
        Pair<List<Integer>, Integer> res4 = Euler26.getDivisionFractional(1, 5);
        assertEquals(new ImmutablePair<>(Arrays.asList(2), null), res4);

        // 1/6 = 0.1(6)
        Pair<List<Integer>, Integer> res5 = Euler26.getDivisionFractional(1, 6);
        assertEquals(new ImmutablePair<>(Arrays.asList(1, 6), 1), res5);

        // 1/7 = 0.(142857)
        Pair<List<Integer>, Integer> res6 = Euler26.getDivisionFractional(1, 7);
        assertEquals(new ImmutablePair<>(Arrays.asList(1, 4, 2, 8, 5, 7), 0), res6);

        // 1/8 = 0.125
        Pair<List<Integer>, Integer> res7 = Euler26.getDivisionFractional(1, 8);
        assertEquals(new ImmutablePair<>(Arrays.asList(1, 2, 5), null), res7);

        // 1/9 = 0.(1)
        Pair<List<Integer>, Integer> res8 = Euler26.getDivisionFractional(1, 9);
        assertEquals(new ImmutablePair<>(Arrays.asList(1), 0), res8);

        // 1/10 = 0.1
        Pair<List<Integer>, Integer> res9 = Euler26.getDivisionFractional(1, 10);
        assertEquals(new ImmutablePair<>(Arrays.asList(1), null), res9);

        // 1/11 = 0.(03)
        Pair<List<Integer>, Integer> res10 = Euler26.getDivisionFractional(1, 37);
        assertEquals(new ImmutablePair<>(Arrays.asList(0, 2, 7), 0), res10);
    }

    @Test
    public void testSolve() throws Exception
    {
        int res = Euler26.solve();
        assertEquals(983, res);
        System.out.println("Euler 26 answer: " + res);
    }
}
