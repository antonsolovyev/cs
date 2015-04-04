package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;


public class Divisors
{
    public static List<Integer> getProperDivisors(int n)
    {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= (n / 2); i++)
        {
            if ((n % i) == 0)
            {
                res.add(i);
            }
        }

        return res;
    }

    public static int getSumDivisors(int n)
    {
        return getProperDivisors(n).stream().reduce(0, (res, i) -> res +i);
    }
}
