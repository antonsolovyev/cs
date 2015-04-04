package com.solovyev.cs;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler25Test
{
    @Test
    public void testSolve() throws Exception
    {
        int res = Euler25.solve();
        System.out.println("Euler 25 result: " + res);
        assertEquals(4782, res);
    }
}
