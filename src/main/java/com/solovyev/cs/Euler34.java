package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
Digit factorials

Problem 34

145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Euler34
{
    private static final Logger LOGGER = Logger.getLogger(Euler34.class.getName());

    // 9! = 362880 < 4 * 10^5, hence the largest sum of factorials is 4n * 10^5 where n is number of digits.
    // At n = 7 the smallest number (1000000) is larger than the largest sum of factorials. Hence we do not
    // need to test above n = 6.
    public long solve()
    {

        List<Long> factorials = getFactorials(9);

        List<Long> found = new ArrayList<>();

        for(long i = 3; i < 999999; i++)
        {
            List<Integer> digits = Numbers.longToDecimalDigitList(i);

            long sum = 0;
            for(Integer d : digits)
            {
                sum += factorials.get(d);
            }

            if(sum == i)
            {
                found.add(i);
            }
        }

        LOGGER.info("found: " + found);

        return found.stream().mapToLong(n -> n).sum();
    }

    public List<Long> getFactorials(int n)
    {
        List<Long> res = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            long f = 1;
            for(int j = 1; j <= i; j++)
            {
                f *= j;
            }
            res.add(f);
        }

        return res;
    }
}
