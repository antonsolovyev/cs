package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler14Test
{
	@Test
	public void testSolution()
	{
		long res =  Euler14.solve();
		assertTrue(res == 837799);
	}
}
