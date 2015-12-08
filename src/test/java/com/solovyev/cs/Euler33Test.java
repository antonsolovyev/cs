package com.solovyev.cs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Euler33Test
{
    @Test
    public void testSolve() throws Exception
    {
        assertEquals(100, new Euler33().solve());
    }

    @Test
    public void testSimplify()
    {
        assertEquals(1, Euler33.RationalNumber.simplify(new Euler33.RationalNumber(3, 6)).getNumerator());
        assertEquals(2, Euler33.RationalNumber.simplify(new Euler33.RationalNumber(3, 6)).getDenominator());

        assertEquals(1, Euler33.RationalNumber.simplify(new Euler33.RationalNumber(49, 98)).getNumerator());
        assertEquals(2, Euler33.RationalNumber.simplify(new Euler33.RationalNumber(49, 98)).getDenominator());
    }
}