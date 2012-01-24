package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler2Test
{
	@Test
	public void testSolution()
	{
		long res = Euler2.solve();
		System.out.println(res);
		
		assertTrue(res == 4613732);
	}	
}
