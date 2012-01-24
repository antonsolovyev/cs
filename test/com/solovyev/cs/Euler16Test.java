package com.solovyev.cs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Euler16Test
{
	@Test
	public void testBinaryToLong()
	{
		System.out.println("-------------> testBinaryToLong()");
		
		List<Boolean> n;
		
		n = Arrays.asList(new Boolean[]{true, false, true, false});
		System.out.println("10: " + Euler16.binaryToLong(n));
		assertTrue(Euler16.binaryToLong(n) == 10);


		n = Arrays.asList(new Boolean[]{});
		System.out.println("0: " + Euler16.binaryToLong(n));
		assertTrue(Euler16.binaryToLong(n) == 0);

		n = Arrays.asList(new Boolean[]{false, false});
		System.out.println("0: " + Euler16.binaryToLong(n));
		assertTrue(Euler16.binaryToLong(n) == 0);

		n = Arrays.asList(new Boolean[]{true});
		System.out.println("1: " + Euler16.binaryToLong(n));
		assertTrue(Euler16.binaryToLong(n) == 1);
		
		n = Arrays.asList(new Boolean[]{true, false, true, false, true, true, false, false, true, true, true, false, false, false,
				true, false, true, false, true, false, true, false, true, true, true, false});
		System.out.println("45320878: " + Euler16.binaryToLong(n));
		assertTrue(Euler16.binaryToLong(n) == 45320878);
	}
	
	@Test
	public void testStringToBinary()
	{
		System.out.println("-------------> testStringToBinary()");
		
		List<Boolean> n = Euler16.stringToBinary("10101100111000101010101110");
		assertTrue(45320878 == Euler16.binaryToLong(n));
	}
	
	@Test
	public void testLongToBinary()
	{
		System.out.println("-------------> testLongToBinary()");
		
		List<Boolean> n;
		
		n = Euler16.longToBinary(0);
		System.out.println("0: " + n);

		n = Euler16.longToBinary(1);
		System.out.println("1: " + n);
		
		n = Euler16.longToBinary(10);
		System.out.println("1: " + n);
		
		n = Euler16.longToBinary(3);
		System.out.println("3: " + n);
		
		n = Euler16.longToBinary(45320878);
		System.out.println("45320878: " + Euler16.binaryToLong(n));
		assertTrue(45320878 == Euler16.binaryToLong(n));
	}
	
	@Test
	public void testNormalize()
	{
		System.out.println("-------------> testNormalize()");
		
		List<Boolean> n = Arrays.asList(new Boolean[]{false, false, false, true, true});;		
		System.out.println("3: " + n);
		assertTrue(3 == Euler16.binaryToLong(n));
	}
	
	@Test
	public void testSubtract()
	{
		System.out.println("-------------> testSubtract()");
		
		long a;
		long b;
		long s;
		
		a = 111;
		b = 12;
		s = Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(a), Euler16.longToBinary(b)));
		System.out.println(a + " - " + b + " = " + s);
		assertTrue(s == a - b);
		
		a = 89;
		b = 78;
		s = Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(a), Euler16.longToBinary(b)));
		System.out.println(a + " - " + b + " = " + s);
		assertTrue(s == a - b);

		a = 13;
		b = 7;
		s = Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(a), Euler16.longToBinary(b)));
		System.out.println(a + " - " + b + " = " + s);
		assertTrue(s == a - b);

		a = 39;
		b = 13;
		s = Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(a), Euler16.longToBinary(b)));
		System.out.println(a + " - " + b + " = " + s);
		assertTrue(s == a - b);

		a = 32;
		b = 1;
		s = Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(a), Euler16.longToBinary(b)));
		System.out.println(a + " - " + b + " = " + s);
		assertTrue(s == a - b);
		
		try
		{
			System.out.println("10 - 15 = " + Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(10), Euler16.longToBinary(15))));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			System.out.println("3 - 10 = " + Euler16.binaryToLong(Euler16.subtract(Euler16.longToBinary(3), Euler16.longToBinary(10))));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	
	@Test
	public void testDivide()
	{
		System.out.println("-------------> testDivide()");
		
		List<Boolean> quotinent = new ArrayList<Boolean>();
		List<Boolean> remainder = new ArrayList<Boolean>();
		
		Euler16.divide(Euler16.longToBinary(39), Euler16.longToBinary(7), quotinent, remainder);
		
		System.out.println("quotinent: " + Euler16.binaryToLong(quotinent) + " remainder: " + Euler16.binaryToLong(remainder));
	}
	
	@Test
	public void testSolution()
	{
		System.out.println("-------------> testSulution()");
		
		long res = Euler16.solution();
		
		System.out.println("solution: " + res);
		
		assertTrue(res == 1366);
	}
}
