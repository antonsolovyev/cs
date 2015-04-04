package com.solovyev.cs;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;


public class DivisorsTest
{
    @Test
    public void testGetProperDivisors() throws Exception
    {
        assertEquals(Arrays.asList(1, 2, 4), Divisors.getProperDivisors(8));
        assertEquals(Arrays.asList(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110), Divisors.getProperDivisors(220));
    }

    @Test
    public void testGetSumDivisors() throws Exception
    {

        assertEquals(28, Divisors.getSumDivisors(28));
    }
}
