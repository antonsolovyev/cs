package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler9Test
{
	@Test
	public void testSolution()
	{
		long res = Euler9.solve();
		System.out.println(res);
		
		assertTrue(res == 31875000);
	}
}
