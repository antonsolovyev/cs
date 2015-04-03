package com.solovyev.cs;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler22Test
{
    @Test
    public void testReadNameList() throws Exception
    {
        List<String> res = Euler22.readNameList();
        // System.out.println("=> " + res);
        assertEquals("MARY", res.get(0));
        assertEquals("ALONSO", res.get(res.size() - 1));
    }

    @Test
    public void testGetSortedNameList() throws Exception
    {
        List<String> res = Euler22.getSortedNameList();
        // System.out.println("=> " + res);
        assertEquals("AARON", res.get(0));
        assertEquals("ZULMA", res.get(res.size() - 1));
    }


    @Test
    public void testGetNameWorth() throws Exception
    {
        assertEquals(1, Euler22.getNameWorth("A"));
        assertEquals(3, Euler22.getNameWorth("AB"));
    }

    @Test
    public void testSolve() throws Exception
    {
        long res = Euler22.solve();
        System.out.println("Euler 22 answer => " + res);
        assertEquals(871198282, res);
    }
}
