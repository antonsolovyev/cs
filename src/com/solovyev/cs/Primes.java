package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Primes
{
	public static final boolean DEBUG = false;
	
	public static boolean isPrime(long n)
	{
		if(n == 0 || n == 1)
			return false;
		
		for(long i = 2; i * i <= n; i++)
			if(n % i == 0)
				return false;
		return true;
	}
	
	public static List<Long> factor(long n)
	{
		ArrayList<Long> res = new ArrayList<Long>();
		
		long p = 2;
		
		while(p * p <= n)
		{
			if(DEBUG)
				System.out.println("iteration: " + p);
			if(isPrime(p))
			{
				if(DEBUG)
					System.out.println("prime p = " + p + ", remaining number n = " + n);
				while(n % p == 0)
				{
					res.add(p);
					n /= p;
				}
			}
			p += 1;
		}
		
		if(n > 1)
			res.add(n);
		
		return res;
	}
	
	public static long unFactor(List<Long> factors)
	{
		Long res = 1L;
		for(Long l : factors)
		{
			res *= l;
		}
		return res;
	}
	
	public static List<Long> sieveOfEratosthenes(Long n)
	{
		List<Long> input = new ArrayList<Long>(n.intValue() + 1);
		for(long i = 0; i < n; i++)
			input.add(i);
		
		input.set(0, null);
		input.set(1, null);
		
		long p = 2;
OUTER:		while(true)
		{
			if(DEBUG)
				System.out.println("prime: " + p);

			// Fact 1:
			// All the numbers that have prime factors below p are already marked at this point. We
			// are going to mark all multiplies of p starting with 2. However, we can start marking
			// from p^2, since every multiply of p below p is already marked.
			for(long i = p * 2; i < input.size(); i += p)
				input.set((int) i, null);
			
			// Due to fact 1 of p^2 exceeds the length of the array, that means everything else there
			// is already marked, so we can stop.
			for(long i = p + 1; i * i <= input.size(); i++)
			{
				if(input.get((int) i) != null)
				{
					p = i;
					continue OUTER;
				}
			}
			break;
		}
			
		List<Long> res = new ArrayList<Long>();
		for(Long l : input)
			if(l != null)
				res.add(l);
		
		return res;
	}
}