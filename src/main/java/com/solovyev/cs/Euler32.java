package com.solovyev.cs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
 * the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1
 * through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9
 * pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Euler32
{
    // Some back of the envelope calcs show we only need to check 1-digit by 4-digit equals 5-digit
    // and 2-digit by 3-digit equals 5 digit

    public static long solve()
    {

        Set<Long> products = new HashSet<>();

        for(long i  = 1; i <= 9; i++)
        {
            for(long j = 1234; j <= 9876; j++)
            {
                long product = i * j;
                if(isPandigitalIdentity(i, j, product))
                {
                    products.add(product);
                }
            }
        }

        for(long i  = 12; i <= 98; i++)
        {
            for(long j = 123; j <= 987; j++)
            {
                long product = i * j;
                if(isPandigitalIdentity(i, j, product))
                {
                    products.add(product);
                }
            }
        }

        long sum = 0;
        for(Long l : products)
        {
            sum += l;
        }

        return sum;
    }

    public static boolean isPandigitalIdentity(long multiplicand, long multiplier, long product)
    {
        List<Integer> decimalDigits = new ArrayList<>();
        decimalDigits.addAll(longToDecimalDigitList(multiplicand));
        decimalDigits.addAll(longToDecimalDigitList(multiplier));
        decimalDigits.addAll(longToDecimalDigitList(product));

        Set<Integer> uniqueDecimalDigits = new HashSet<>(decimalDigits);
        if(decimalDigits.size() == 9  && uniqueDecimalDigits.size() == 9 && !uniqueDecimalDigits.contains(0))
        {
            return true;
        }

        return false;
    }

    private static List<Integer> longToDecimalDigitList(long n)
    {
        List<Integer> res = new ArrayList<>();
        while(true)
        {
            if(n == 0)
                break;

            res.add(0, (int)(n % 10));

            n = n / 10;
        }
        return res;
    }
}
