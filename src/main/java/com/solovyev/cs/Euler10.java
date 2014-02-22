package com.solovyev.cs;

import java.util.List;

public class Euler10
{
	public static long solve(long n)
	{
		List<Long> primes = Primes.sieveOfEratosthenes(n);
		
		long res = 0;
		for(Long p : primes)
			res += p;
		
		return res;
	}
}