package com.solovyev.cs;

import java.util.*;
import java.util.concurrent.ThreadFactory;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;


/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators
2 to 10 are given:

1/2     =       0.5
1/3     =       0.(3)
1/4     =       0.25
1/5     =       0.2
1/6     =       0.1(6)
1/7     =       0.(142857)
1/8     =       0.125
1/9     =       0.(1)
1/10    =       0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Euler26
{

    /**
     * Returns the fractional part of division. List in the resulting tuple contains decimal digits. Integer
     * in the resulting tuple contains null for a non-periodic result and the first decimal digit of the
     * period for periodic result.
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public static Pair<List<Integer>, Integer> getDivisionFractional(int numerator, int denominator)
    {
        List<Integer> remainders = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int remainder = numerator % denominator;
        int digit;

        while (true)
        {
            remainders.add(remainder);

            digit = (remainder * 10) / denominator;
            remainder = (remainder * 10) % denominator;

            res.add(digit);

            if (remainder == 0)
            {
                return new ImmutablePair<>(res, null);
            }

            if (remainders.contains(remainder))
            {
                return new ImmutablePair<>(res, remainders.indexOf(remainder));
            }
        }
    }

    public static int solve()
    {
        int maxCycle = -1;
        int maxCycleDivisor = 0;

        for (int i = 2; i < 1000; i++)
        {
            Pair<List<Integer>, Integer> res = getDivisionFractional(1, i);
            if (res.getRight() != null)
            {
                int cycle = res.getLeft().size() - res.getRight();
                if (cycle > maxCycle)
                {
                    maxCycle = cycle;
                    maxCycleDivisor = i;
                }
            }
        }

        System.out.println("Longest cycle: " + maxCycle);
        System.out.println("Longest cycle fraction: " + getDivisionFractional(1, maxCycleDivisor));

        return maxCycleDivisor;
    }
}
