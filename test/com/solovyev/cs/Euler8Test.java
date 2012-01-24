package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler8Test
{
	@Test
	public void testSolution()
	{
		long res = Euler8.solve();
		System.out.println(res);
		
		assertTrue(res == 40824);
	}
}
