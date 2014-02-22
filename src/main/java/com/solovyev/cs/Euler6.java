package com.solovyev.cs;

public class Euler6
{
	public static long solve(long n)
	{
		long res = 0;
		// (a1 + a2 + a3 + ... + an)^2 - (a1^2 + a2^2 + a3^2 + ... + an^2) =
		// 	= (a1 * a2 + a1 * a3 + ... + a1 * an) + (a2 * a1 + a2 * a3 + ... + a2 * an) + ... + (an * a1 + an * a2 + ... + an * an-1)
		for(long i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n; j++)
				if(i != j)
					res += i * j; 
		}		
		return res;
	}
}