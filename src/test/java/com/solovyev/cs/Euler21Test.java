package com.solovyev.cs;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler21Test
{
    @Test
    public void testSolve() throws Exception
    {

        int res = Euler21.solve();

        System.out.println("res: " + res);

        assertEquals(31626, res);
    }
}
