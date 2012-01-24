package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Euler9
{
	public static final List<Long> squares = new ArrayList<Long>();
	public static final boolean DEBUG = true;
	
	static
	{
		for(long i = 0; i < 1000; i++)
			squares.add(i * i);
	}
	
	public static long solve()
	{
		for(int i = 2; i < 1000; i++)
		{
			for(int j = i; j < 1000 - i; j++)
				if(squares.get(i) + squares.get(j) == squares.get(1000 - i - j))
				{
					if(DEBUG)
						System.out.println("i: " + i + " j: " + j + " k: " + (1000 - i - j));
					
					return i * j * (1000 - i -j);
					
				}
		}
		throw new RuntimeException("solution not found");
	}
}
