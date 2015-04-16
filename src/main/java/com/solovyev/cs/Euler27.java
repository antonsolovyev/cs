package com.solovyev.cs;

import java.util.HashSet;
import java.util.Set;


/*
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40,
402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to
79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes
for consecutive values of n, starting with n = 0.
 */
public class Euler27
{
    private static final long COEFFICIENT_LIMIT = 1000;

    public static long solve()
    {
        Set<Long> primes = new HashSet<>(Primes.sieveOfEratosthenes((long) ((COEFFICIENT_LIMIT * COEFFICIENT_LIMIT) +
                        (COEFFICIENT_LIMIT * COEFFICIENT_LIMIT) + COEFFICIENT_LIMIT)));

        long maxPrimes = 0;
        long maxPrimesA = 0;
        long maxPrimesB = 0;
        for (long a = -COEFFICIENT_LIMIT + 1; a < COEFFICIENT_LIMIT; a++)
        {
            for (long b = -COEFFICIENT_LIMIT + 1; b < COEFFICIENT_LIMIT; b++)
            {
                for (long n = 0; n < b; n++)
                {
                    long q = (n * n) + (a * n) + b;
                    if (!primes.contains(q))
                    {
                        if ((n - 1) > maxPrimes)
                        {
                            maxPrimes = n - 1;
                            maxPrimesA = a;
                            maxPrimesB = b;
                        }

                        break;
                    }
                }
            }
        }

        System.out.println("maxPrimes: " + maxPrimes + ", maxPimesA: " + maxPrimesA + ", maxPrimesB: " + maxPrimesB);

        return maxPrimesA * maxPrimesB;
    }
}
