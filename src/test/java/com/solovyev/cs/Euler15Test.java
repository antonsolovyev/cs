package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler15Test
{
	@Test
	public void testSolution()
	{
		long res = Euler15.solution();
		System.out.println("result: " + res);
		assertTrue(res == 137846528820L);
	}
}
