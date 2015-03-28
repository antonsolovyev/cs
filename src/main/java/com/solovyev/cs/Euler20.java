package com.solovyev.cs;


import java.util.ArrayList;
import java.util.List;


public class Euler20
{
    public static List<Integer> add(List<Integer> a, List<Integer> b)
    {
        List<Integer> res = new ArrayList<Integer>();
        int carryOver = 0;

        for (int i = 0; i < Math.max(a.size(), b.size()); i++)
        {
            int ai = (i < a.size()) ? a.get(i) : 0;
            int bi = (i < b.size()) ? b.get(i) : 0;
            int s = ai + bi + carryOver;

            carryOver = s / 10;

            res.add(s % 10);
        }

        if (carryOver != 0)
        {
            res.add(carryOver);
        }

        return res;
    }

    public static List<Integer> multiply(List<Integer> a, List<Integer> b)
    {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++)
        {
            List<Integer> t = new ArrayList<Integer>();
            int carryOver = 0;

            for (int j = 0; j < b.size(); j++)
            {
                int product = (a.get(i) * b.get(j)) + carryOver;
                carryOver = product / 10;
                t.add(product % 10);
            }

            if (carryOver != 0)
            {
                t.add(carryOver);
            }

            for (int j = 0; j < i; j++)
            {
                t.add(0, 0);
            }

            res = add(res, t);
        }

        return res;
    }

    public static List<Integer> asList(int n)
    {
        List<Integer> res = new ArrayList<Integer>();
        while (n > 0)
        {
            res.add(n % 10);
            n = n / 10;
        }

        return res;
    }

    public static int solve()
    {
        List<Integer> product = asList(1);
        for (int i = 2; i <= 100; i++)
        {
            product = multiply(product, asList(i));
        }

        int res = 0;
        for (int i = 0; i < product.size(); i++)
        {
            res += product.get(i);
        }

        return res;
    }
}
