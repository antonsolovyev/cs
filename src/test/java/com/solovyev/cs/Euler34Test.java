package com.solovyev.cs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Euler34Test
{

    @Test
    public void testSolve() throws Exception
    {
        assertEquals(40730L,  new Euler34().solve());
    }

    @Test
    public void testGetFactorials()
    {
        assertEquals(Arrays.asList(1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L),
                new Euler34().getFactorials(9));
    }
}