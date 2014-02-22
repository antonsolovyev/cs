package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler10Test
{
	public static final int MAX = 2000000;

	@Test
	public void testSolution()
	{
		long res = Euler10.solve(MAX);
		System.out.println(res);
		
		assertTrue(res == 142913828922L);
	}
}