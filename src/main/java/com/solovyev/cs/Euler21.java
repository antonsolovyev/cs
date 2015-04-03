package com.solovyev.cs;

import java.util.*;


public class Euler21
{
    public static List<Integer> getProperDivisors(int n)
    {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= (n / 2); i++)
        {
            if ((n % i) == 0)
            {
                res.add(i);
            }
        }

        return res;
    }

    public static int solve()
    {
        Map<Integer, Integer> divisorSum = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 10000; i++)
        {
            divisorSum.put(i, getSumDivisors(i));
        }

        Map<Integer, Integer> amicable = new HashMap<Integer, Integer>();
        for (Map.Entry e : divisorSum.entrySet())
        {
            if (divisorSum.get(e.getValue()) == null)
            {
                continue;
            }

            if (divisorSum.get(e.getValue()).equals(e.getKey()))
            {
                amicable.put((Integer) e.getValue(), (Integer) e.getKey());
            }
        }


        // System.out.println("amicable: " + amicable);

        int res = 0;
        for (Integer n : amicable.keySet())
        {
            if (!n.equals(amicable.get(n)))
            {
                res += n;
            }
        }

        return res;
    }

    public static int getSumDivisors(int n)
    {
        int res = 0;
        for (Integer i : getProperDivisors(n))
        {
            res += i;
        }

        return res;
    }
}
