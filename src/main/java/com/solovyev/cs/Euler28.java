package com.solovyev.cs;

/**
 *
 * 43 44 45 46 47 48 49
 * 42 21 22 23 24 25 26
 * 41 20  7  8  9 10 27
 * 40 19  6  1  2 11 28
 * 39 18  5  4  3 12 29
 * 38 17 16 15 14 13 30
 * 37 36 35 34 33 32 31
 */
public class Euler28
{
    public static long solve() throws Exception
    {
        // 1. 1 in the center is the initial value
        // 2. The north-east diagonal is squares of i = 1,3,5,7,...,1001
        // 3. The other diagonals are less by i - 1 each
        long res = 1;
        for (int i = 3; i <= 1001; i += 2)
        {
            for (int j = 0; j < 4; j++)
            {
                res += (i * i) - ((i - 1) * j);
            }
        }

        return res;
    }
}
