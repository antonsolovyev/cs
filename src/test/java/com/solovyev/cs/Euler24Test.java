package com.solovyev.cs;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Euler24Test
{
    @Test
    public void testPermutate() throws Exception
    {
        List<Integer> list = Arrays.asList(8, 7, 6, 2, 9, 4, 1);
        Euler24.permutate(list);
        assertEquals(Arrays.asList(8, 7, 6, 4, 1, 2, 9), list);

        List<Integer> list2 = Arrays.asList(8, 7, 6, 2, 9, 1, 4);
        Euler24.permutate(list2);
        assertEquals(Arrays.asList(8, 7, 6, 2, 9, 4, 1), list2);

        List<Integer> list3 = Arrays.asList(7, 8, 6, 5, 4, 3, 2);
        Euler24.permutate(list3);
        assertEquals(Arrays.asList(8, 2, 3, 4, 5, 6, 7), list3);
    }

    @Test
    public void testPermutateSimple() throws Exception
    {
        List<Integer> list = Arrays.asList(2, 9, 4, 1);
        Euler24.permutate2(list);
        assertEquals(Arrays.asList(4, 1, 2, 9), list);

        List<Integer> list2 = Arrays.asList(2, 9, 4, 3);
        Euler24.permutate2(list2);
        assertEquals(Arrays.asList(3, 2, 4, 9), list2);

        List<Integer> list3 = Arrays.asList(5, 9, 4, 3);
        Euler24.permutate2(list3);
        assertEquals(Arrays.asList(9, 3, 4, 5), list3);
    }

    @Test
    public void testRevert() throws Exception
    {
        List<Integer> list = Arrays.asList(3, 1, 2, 0);
        Euler24.revert(list);
        assertEquals(Arrays.asList(0, 2, 1, 3), list);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        Euler24.revert(list2);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), list2);
    }

    @Test
    public void testSwap() throws Exception
    {
        List<Integer> list = Arrays.asList(3, 2, 1);
        Euler24.swap(list, 0, 1);
        assertEquals(Arrays.asList(2, 3, 1), list);
        Euler24.swap(list, 0, 2);
        assertEquals(Arrays.asList(1, 3, 2), list);
    }

    @Test
    public void testSolve() throws Exception
    {
        List<Integer> res = Euler24.solve();
        System.out.println("Euler 24 answer: " + res);
        assertEquals(Arrays.asList(2, 7, 8, 3, 9, 1, 5, 4, 6, 0), res);
    }
}
