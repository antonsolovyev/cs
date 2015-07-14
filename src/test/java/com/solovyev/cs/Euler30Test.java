package com.solovyev.cs;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler30Test
{
    @Test
    public void testSolve()
    {
        assertEquals(443839, Euler30.solve());
    }

    @Test
    public void testGetDigitsFifthPowers()
    {
        System.out.println("=> fifth powers: " + Euler30.getDigitsFifthPowers());
    }
}
