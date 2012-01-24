package com.solovyev.cs;

public class Euler14
{
	public static final boolean DEBUG = true;
	
	public static long sequenceLength(long n)
	{
		long count = 0;
		
		while(true)
		{
			if(n == 1)
				return count;

			if(n % 2 == 0)
				n = n / 2;
			else
				n = 3 * n + 1;
			
			count++;			
		}
	}
	
	public static long solve()
	{
		long res = 1;
		long maxLength = -1;
		
		for(long i = 1; i < 1000000; i++)
		{
			long l = sequenceLength(i);
			if(maxLength < l)
			{
				maxLength = l;
				res = i;
			}
			if(DEBUG)
				System.out.println("i = " + i + " maxLength = " + maxLength);
		}
		
		return res;
	}
}