package com.solovyev.cs;

public class Euler4
{
	private static boolean isPalindrome(long n)
	{
		Integer[] digits = new Integer[10];
		
		int i = 0;
		while(true)
		{
			digits[i] = (int) n % 10;
			n = n / 10;
			i++;
			if(n == 0)
				break;
		}
		
		for(int j = 0; j < i / 2; j++)
		{
			if(digits[j] != digits[i - 1 - j])
				return false;
		}
		
		return true;
	}
	
	public static long solve()
	{
		long maxPalindrome = 0;
		for(long i = 100; i < 999; i++)
			for(long j = i; j < 999; j++)
			{
				long product = i * j;
				if(isPalindrome(product))
					if(product > maxPalindrome)
						maxPalindrome = product;
			}
		return maxPalindrome;
	}		
}
