package com.solovyev.cs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Euler32Test
{
    @Test
    public void testSolve() throws Exception
    {
        assertEquals(45228, Euler32.solve());
    }

    @Test
    public void testIsPandigitalIdentity() throws Exception
    {
        // From example
        assertTrue(Euler32.isPandigitalIdentity(39, 186, 7254));
        // Repeating digit
        assertFalse(Euler32.isPandigitalIdentity(33, 186, 7254));
        // Zero present
        assertFalse(Euler32.isPandigitalIdentity(30, 186, 7254));
        // Duplicated digits, more than 9 digits
        assertFalse(Euler32.isPandigitalIdentity(399, 186, 7254));
        // Less than 9 digits
        assertFalse(Euler32.isPandigitalIdentity(3, 186, 7254));
    }
}