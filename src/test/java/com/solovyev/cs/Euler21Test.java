package com.solovyev.cs;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler21Test
{
    @Test
    public void testGetProperDivisors() throws Exception
    {
        assertEquals(Arrays.asList(1, 2, 4), Euler21.getProperDivisors(8));
        assertEquals(Arrays.asList(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110), Euler21.getProperDivisors(220));
    }

    @Test
    public void testSolve() throws Exception
    {

        int res = Euler21.solve();

        System.out.println("res: " + res);

        assertEquals(31626, res);
    }
}
