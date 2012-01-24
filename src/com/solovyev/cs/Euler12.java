
package com.solovyev.cs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler12
{
	private static final boolean DEBUG = true;
	
	public static long solve()
	{
		for(int i = 1; ;i++)
		{
			long t = i * (i + 1) / 2;
			if(DEBUG)
				System.out.println("triangle number: " + t);

			List<Long> factors = Primes.factor(t);
			if(DEBUG)
				System.out.println("prime factors: " + factors);

			Map<Long, Long> factorPowers = new HashMap<Long, Long>();
			for(Long f : factors)
			{
				long c;
				if(factorPowers.containsKey(f))
					c = factorPowers.get(f);
				else
					c = 0;
				factorPowers.put(f, c + 1);
			}
			if(DEBUG)
				System.out.println("factor powers: " + factorPowers);
			
			//
			// This is really very easy.
			//
			// A number can be represented as N = p1^e1 * p2^e2 * ... * pn^en
			// where p1...pn are prime factors and e1...en are respective powers.
			//
			// Every unique divisor of N should be a product of prime factors each to the power of between 0 and ei. That is
			// we can produce divisors by choosing first factor 0 to e1 ways, second factor 0 to e2 ways and so on. Hence the
			// number of divisors is given by (e1 + 1)*(e2 + 1)*(e3 + 1)*....*(en + 1).
			//
			long divisorCount = 1;
			for(Long c : factorPowers.values())
				divisorCount = divisorCount * (c + 1);
			if(DEBUG)
				System.out.println("divisor count: " + divisorCount);
			
			if(DEBUG)
				System.out.println();
			
			if(divisorCount >= 500)
				return t;
		}
	}
}