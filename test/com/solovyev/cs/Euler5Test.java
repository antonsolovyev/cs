package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler5Test
{
	@Test
	public void testSolution()
	{
		long res = Euler5.solve(20L);
		System.out.println(res);
		
		assertTrue(res == 232792560);
	}
}
