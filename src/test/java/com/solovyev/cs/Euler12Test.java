package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler12Test
{

	@Test
	public void testSolution()
	{
		long res = Euler12.solve();
		System.out.println(res);
		
		assertTrue(res == 76576500);
	}
}
