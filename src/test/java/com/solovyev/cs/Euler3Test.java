package com.solovyev.cs;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class Euler3Test
{
	private static final long NUMBER_GIVEN = 600851475143L;

	@Test
	public void testSolution()
	{
		System.out.println("number given: " + NUMBER_GIVEN);
		
		List<Long> factors = Primes.factor(NUMBER_GIVEN);
		System.out.println("factors: " + factors);
		
		long n = Primes.unFactor(factors);
		System.out.println("number: " + n);		
		assertTrue(n == NUMBER_GIVEN);
		
		
		long res = Euler3.solve();
		System.out.println("answer: " + res);
		
		assertTrue(res == 6857);
	}
}