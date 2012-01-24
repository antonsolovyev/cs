package com.solovyev.cs;

public class Euler2
{
	public static final long FIBONACCI_0 = 0;
	public static final long FIBONACCI_1 = 1;
		
	public static long fibonacci(int n)
	{
		if(n == 0)
			return FIBONACCI_0;
		if(n == 1)
			return FIBONACCI_1;
		
		long fibonacci = 0;
		long fibonacciPreviousPrevious = FIBONACCI_0;
		long fibonacciPrevious = FIBONACCI_1;
		for(int i = 0; i < n - 1; i++)
		{
			fibonacci = fibonacciPrevious + fibonacciPreviousPrevious;
			fibonacciPreviousPrevious = fibonacciPrevious;
			fibonacciPrevious = fibonacci;
		}
		return fibonacci;
	}
	
	public static long fibonacci2(int n)
	{
		if(n == 0)
			return FIBONACCI_0;
		if(n == 1)
			return FIBONACCI_1;
		
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
	
	public static long solve()
	{
		long res = 0;
		long fibonacci;
		long fibonacciPreviousPrevious = FIBONACCI_0;
		long fibonacciPrevious = FIBONACCI_1;
		while(true)
		{
			fibonacci = fibonacciPrevious + fibonacciPreviousPrevious;
			if(fibonacci > 4000000)
				return res;
			if(fibonacci % 2 == 0)
				res += fibonacci;		
			fibonacciPreviousPrevious = fibonacciPrevious;
			fibonacciPrevious = fibonacci;
		}
	}
	
}
