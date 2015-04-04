package com.solovyev.cs;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Euler23Test
{
    private static String getStackTrace(Throwable t)
    {
        if (t == null)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (StackTraceElement ste : t.getStackTrace())
        {
            sb.append(ste.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Test
    public void testGetAbundantBelow() throws Exception
    {
        List<Integer> res = Euler23.getAbundantBelow(28123);
        assertEquals(6965, res.size());
    }

    @Test
    public void testSolve() throws Exception
    {
        long res = Euler23.solve();
        assertEquals(4179871, res);
        System.out.println("Euler 23 answer: " + res);
    }
}
