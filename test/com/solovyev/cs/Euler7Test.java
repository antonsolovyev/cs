package com.solovyev.cs;

import static org.junit.Assert.*;
import org.junit.Test;

public class Euler7Test
{
	@Test
	public void testSolution() throws InterruptedException
	{
		long res = Euler7.solve(10001);
		System.out.println("10001-st prime is: " + res);
		
		assertTrue(res == 104743);
	}
}
