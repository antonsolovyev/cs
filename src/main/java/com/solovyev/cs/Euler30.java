package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
// I only need to worry about 6 digit numbers at the most:
// The largest 5-th power is n * 9^5. The smallest number with n digits is 10^(n - 1).
// Obviously, n = 7 is guaranteed to make the power always smaller (7*10^5 vs 10^6), so 6 is our number
// of digits.
public class Euler30
{
    private static final long MAX_POWER = 6 * 9 * 9 * 9 * 9 * 9;

    public static long solve()
    {
        long res = 0L;
        for (Long n : getDigitsFifthPowers())
        {
            res += n;
        }

        return res;
    }

    public static List<Long> getDigitsFifthPowers()
    {
        List<Long> res = new ArrayList<>();

        for (long i = 2; i <= MAX_POWER; i++)
        {
            List<Integer> digits = Numbers.longToDecimalDigitList(i);
            long powers = 0L;
            for (Integer d : digits)
            {
                powers += d * d * d * d * d;
            }
            if (powers == i)
            {
                res.add(i);
            }
        }

        return res;
    }
}
