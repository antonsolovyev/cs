package com.solovyev.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler5
{
	public static final boolean DEBUG = true;
	
	public static long solve(Long n)
	{
		Map<Integer, List<Long>> factorMap = new HashMap<Integer, List<Long>>();
		
		for(int i = 2; i <= n; i++)
			factorMap.put(i, Primes.factor(i));

		if(DEBUG)
			System.out.println("factor map: " + factorMap);

		ArrayList<Long> resultFactors = new ArrayList<Long>();
		for(int i = 2; i <= n; i++)
		{
			if(!Primes.isPrime(i))
				continue;
			
			int maxFactorCount = 0;
			for(List<Long> factorList : factorMap.values())
			{
				int count = 0;
				for(Long factor : factorList)
				{
					if(factor == i)
						count++;
				}
				if(count > maxFactorCount)
					maxFactorCount = count;
			}
			
			if(DEBUG)
				System.out.println("prime factor: " + i + " count: " + maxFactorCount)
				;
			for(int j = 0; j < maxFactorCount; j++)
				resultFactors.add((long) i);
		}
		
		
		long res = 1;
		for(Long factor : resultFactors)
			res *= factor;
		
		return res;
	}
}