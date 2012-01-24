package com.solovyev.cs;

public class Euler7
{
	public static final boolean DEBUG = false;
	
	public static long solve(long n) throws InterruptedException
	{
		long count = 0;
		long i = 2;
		while(true)
		{
			if(Primes.isPrime(i))
			{
				count++;
				
				if(DEBUG)
					System.out.println("prime #: " + count + " is: " + i);
				
				if(count == n)
					return i;
			}
			i++;
		}
	}
}