package com.solovyev.cs;

import java.util.Arrays;
import java.util.List;


/*
Lexicographic permutations

Problem 24

A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3
and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The
lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class Euler24
{
    public static List<Integer> solve()
    {
        List<Integer> input = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 1; i < 1000000; i++)
        {
            permutate(input);
        }

        return input;
    }

    /*
    Find next larger permutation

    0. Consider:

        0356872941

    1. Start at the back of list and find first unordered element (2):

        034687 2941

    2. Now work with a sub list that starts with this element:

        2 941

    3. Swap 0-th element with the first one looking from the back that is larger (4):

        4 9 2 1

    4. The remaining list is still ordered after swap, so revert it to get the smallest:

        4 129

    5. Result is:

        0356874129

     */
    public static List<Integer> permutate(List<Integer> input)
    {
        for (int i = input.size() - 1; i > 0; i--)
        {
            if (input.get(i - 1) < input.get(i))
            {
                permutate2(input.subList(i - 1, input.size()));

                break;
            }
        }

        return null;
    }

    // Steps starting with #2
    public static void permutate2(List<Integer> input)
    {

        for (int i = input.size() - 1; i > 0; i--)
        {
            if (input.get(i) > input.get(0))
            {
                swap(input, 0, i);

                break;
            }
        }

        revert(input.subList(1, input.size()));
    }

    // Revert list
    public static void revert(List<Integer> input)
    {
        for (int i = 0; i < (input.size() / 2); i++)
        {
            swap(input, i, input.size() - 1 - i);
        }
    }

    // Swap elements
    public static void swap(List<Integer> input, int i, int j)
    {
        int t = input.get(i);
        input.set(i, input.get(j));
        input.set(j, t);
    }
}
