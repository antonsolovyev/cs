package com.solovyev.cs;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 Circular primes

 Problem 35

 The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

 There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

 How many circular primes are there below one million?
 */
public class Euler35
{
    private static final Logger LOGGER = Logger.getLogger(Euler35.class.getName());

    public int solve(long upperBound)
    {
        Set<Long> res = new HashSet<>();

        Set<Long> primes = new HashSet<>(Primes.sieveOfEratosthenes(upperBound));
        for(Long p : primes)
        {
            Set<Long> cyclicPermutations = getCyclicPermutations(p);
            if(!cyclicPermutations.isEmpty() && primes.containsAll(cyclicPermutations))
            {
                res.add(p);
            }
        }

        return res.size();
    }

    public Set<Long> getCyclicPermutations(Long n)
    {
        List<Integer> digits = Numbers.longToDecimalDigitList(n);

        Set<Long> res = new HashSet<>();
        for(int i = 0; i < digits.size(); i++)
        {
            res.add(Numbers.decimalDigitListToLong(digits));
            digits.add(0, digits.remove(digits.size() - 1));
        }

        return res;
    }
}
