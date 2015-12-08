package com.solovyev.cs;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/*
Digit cancelling fractions

Problem 33

The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two
digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Euler33
{
    private static final Logger LOGGER = Logger.getLogger(Euler3.class.getName());

    public int solve()
    {
        Set<RationalNumber> found = new HashSet<>();

        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                int numerator = i * 10 + j;

                for(int k = 1; k <= 9; k++)
                {
                    int denominator = i * 10 + k;
                    RationalNumber r = new RationalNumber(numerator, denominator);
                    if(r.equals(new RationalNumber(j, k)) &&
                            r.compareTo(new RationalNumber(1, 1)) < 0)
                    {
                        found.add(r);
                    }
                }

                for(int k = 1; k <= 9; k++)
                {
                    int denominator = j * 10 + k;
                    RationalNumber r = new RationalNumber(numerator, denominator);
                    if(r.equals(new RationalNumber(i, k)) &&
                            r.compareTo(new RationalNumber(1, 1)) < 0)
                    {
                        found.add(r);
                    }
                }
            }
        }

        LOGGER.info("Found: " + found);

        int n = 1;
        int d = 1;
        for(RationalNumber r : found)
        {
            n *= r.getNumerator();
            d *= r.getDenominator();
        }

        return RationalNumber.simplify(new RationalNumber(n, d)).getDenominator();
    }

    public static class RationalNumber implements Comparable<RationalNumber>
    {
        private final int numerator;
        private final int denominator;

        public RationalNumber(int numerator, int denominator)
        {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator()
        {
            return numerator;
        }

        public int getDenominator()
        {
            return denominator;
        }

        public static RationalNumber simplify(RationalNumber r)
        {
            int runningNumerator = r.getNumerator();
            int runningDenominator = r.getDenominator();

            OUTER:
            while(true)
            {
                for(int i = 2; i <= r.getNumerator(); i++)
                {
                    if(runningNumerator % i == 0 && runningDenominator % i == 0)
                    {
                        runningNumerator /= i;
                        runningDenominator /= i;
                        continue OUTER;
                    }
                }
                return new RationalNumber(runningNumerator, runningDenominator);
            }
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }

            if (o == null || getClass() != o.getClass())
            {
                return false;
            }

            RationalNumber that = (RationalNumber) o;

            if(numerator * that.getDenominator() == that.getNumerator() * denominator)
            {
                return true;
            }

            return false;
        }

        @Override
        public int hashCode()
        {
            RationalNumber r = simplify(this);

            int result = r.getNumerator() ^ (r.getNumerator() >>> 32);
            result = 31 * result + r.getDenominator() ^ (r.getDenominator() >>> 32);

            return result;
        }

        @Override
        public String toString()
        {
            return numerator + "/" + denominator;
        }

        @Override
        public int compareTo(RationalNumber o)
        {
            return new Long(numerator * o.getDenominator()).compareTo(new Long(o.getNumerator() * denominator));
        }
    }
}
