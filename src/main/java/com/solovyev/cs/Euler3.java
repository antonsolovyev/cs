package com.solovyev.cs;

import java.util.List;

public class Euler3
{
	public static long solve()
	{
		List<Long> factors = Primes.factor(600851475143L);
		return factors.get(factors.size() - 1);
	}
}
