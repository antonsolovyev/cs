package com.solovyev.cs;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler27Test
{
    @Test
    public void testSolve() throws Exception
    {
        long res = Euler27.solve();
        System.out.println("Euler 27 answer: " + res);
        assertEquals(-59231, res);
    }
}
