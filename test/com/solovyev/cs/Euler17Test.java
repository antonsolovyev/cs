package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Euler17Test
{
	@Test
	public void testSayNumber()
	{
		System.out.println("2 " + Euler17.sayNumber(2));
		System.out.println("66 " + Euler17.sayNumber(66));
		System.out.println("20 " + "\"" + Euler17.sayNumber(20) + "\"");
		System.out.println("786 " + Euler17.sayNumber(786));
		System.out.println("300 " + Euler17.sayNumber(300));
		System.out.println("1000 " + Euler17.sayNumber(1000));
	}
	
	@Test
	public void testSolution()
	{
		long res = Euler17.solve();
		System.out.println("res: " + res);
		assertTrue(res == 21124);
	}
}
