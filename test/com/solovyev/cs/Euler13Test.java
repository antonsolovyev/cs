package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler13Test
{
	@Test
	public void testSolutin()
	{
		String res = Euler13.solve();
		
		assertTrue(res.equals("5537376230"));
	}
}