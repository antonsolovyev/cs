package com.solovyev.cs;

import java.util.*;


public class Euler29
{
    public static Map<Long, List<Long>> getFactorMap()
    {
        Map<Long, List<Long>> res = new HashMap<>();
        for (long i = 2; i <= 100; i++)
        {
            res.put(i, Primes.factor(i));
        }

        return res;
    }

    public static int solve()
    {
        Map<Long, List<Long>> factorMap = getFactorMap();

        Set<List<Long>> res = new HashSet<>();
        for (int i = 2; i <= 100; i++)
        {
            for (int j = 2; j <= 100; j++)
            {
                List<Long> powerFactors = new ArrayList<>();

                for (int k = 0; k < j; k++)
                {
                    powerFactors.addAll(factorMap.get((long) i));
                }
                Collections.sort(powerFactors);

                res.add(powerFactors);
            }
        }

        return res.size();
    }
}
