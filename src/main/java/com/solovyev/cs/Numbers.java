package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Numbers
{
    public static List<Integer> longToDecimalDigitList(long n)
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
