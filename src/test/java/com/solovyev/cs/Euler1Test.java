package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler1Test
{
	@Test
	public void testSolution()
	{
		int res = Euler1.solve();
		System.out.println(res);
		
		assertTrue(res == 233168);
	}
}
