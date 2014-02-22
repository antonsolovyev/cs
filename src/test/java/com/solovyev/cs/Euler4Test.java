package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler4Test
{

	@Test
	public void testSolution()
	{
		long res = Euler4.solve();		
		System.out.println(res);
		
		assertTrue(res == 906609);
	}
}
