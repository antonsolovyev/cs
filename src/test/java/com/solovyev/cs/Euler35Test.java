package com.solovyev.cs;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by antonsolovyev on 12/12/15.
 */
public class Euler35Test
{
    @Test
    public void testSolve() throws Exception
    {
        assertEquals(13, new Euler35().solve(100));
        assertEquals(55, new Euler35().solve(1_000_000L));
    }

    @Test
    public void testGetCyclicPermutations()
    {
        assertEquals(new HashSet<>(Arrays.asList(123L, 312L, 231L)), new Euler35().getCyclicPermutations(123L));
    }
}