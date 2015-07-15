package com.solovyev.cs;

import java.util.Arrays;
import java.util.List;


/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:

 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class Euler31
{
    private static List<Integer> coinValues = Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1);

    public static int solve()
    {
        return count(200, 0);
    }

    private static int count(int amount, int coinValueIndex)
    {
        // Only one way to get the required amount with pennies.
        if (coinValueIndex == (coinValues.size() - 1))
        {
            return 1;
        }

        int res = 0;
        for (int i = 0; (coinValues.get(coinValueIndex) * i) <= amount; i++)
        {
            res += count(amount - (coinValues.get(coinValueIndex) * i), coinValueIndex + 1);
        }

        return res;
    }
}
