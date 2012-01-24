package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler6Test
{
	@Test
	public void testSolution()
	{
		long res = Euler6.solve(100);
		System.out.println(res);
		
		assertTrue(res == 25164150L);
	}
}
