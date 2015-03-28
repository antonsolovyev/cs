package com.solovyev.cs;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler20Test
{
    @Test
    public void testMultiply() throws Exception
    {
        List<Integer> res = Euler20.multiply(Arrays.asList(2), Arrays.asList(3));
        assertEquals(Arrays.asList(6), res);

        res = Euler20.multiply(Arrays.asList(6), Arrays.asList(6));
        assertEquals(Arrays.asList(6, 3), res);

        res = Euler20.multiply(Arrays.asList(3), Arrays.asList(2, 1));
        assertEquals(Arrays.asList(6, 3), res);

        res = Euler20.multiply(Arrays.asList(3, 2), Arrays.asList(8, 1));
        assertEquals(Arrays.asList(4, 1, 4), res);

        res = Euler20.multiply(Arrays.asList(4, 3, 2, 1), Arrays.asList(9, 8, 7));
        assertEquals(Arrays.asList(6, 2, 6, 3, 7, 9), res);
    }

    @Test
    public void testAsList() throws Exception
    {
        assertEquals(Arrays.asList(3), Euler20.asList(3));
        assertEquals(Arrays.asList(3, 2, 1), Euler20.asList(123));
    }

    @Test
    public void testSolve() throws Exception
    {
        int res = Euler20.solve();
        System.out.println("Euler 20 answer is: " + res);
        assertEquals(648, res);
    }

    @Test
    public void testAdd() throws Exception
    {
        List<Integer> res = Euler20.add(Arrays.asList(1, 2), Arrays.asList(2));
        assertEquals(Arrays.asList(3, 2), res);

        res = Euler20.add(Arrays.asList(1, 2), Arrays.asList(3, 2, 1));
        assertEquals(Arrays.asList(4, 4, 1), res);
    }
}
