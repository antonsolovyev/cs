package com.solovyev.cs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler23
{
    /*
    Non-abundant sums

    Problem 23

    A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
    the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

    A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
    sum exceeds n.

    As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum
    of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can
    be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
    even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is
    less than this limit.

    Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
     */


    public static List<Integer> getAbundantBelow(int n)
    {
        return IntStream.range(0, n).
                filter(i -> Divisors.getSumDivisors(i) > i).
                    mapToObj(i -> Integer.valueOf(i)).
                        collect(Collectors.toList());
    }
    
    public static long solve()
    {
        Set<Integer> abundant = new TreeSet<>(getAbundantBelow(28123));
        
        Set<Integer> nonSumAbundant = new HashSet<>();
        
        for(int i = 1; i < 28123; i++)
        {
            for(Integer j : abundant)
            {
                if(j > (i / 2))
                {
                    nonSumAbundant.add(i);
                    break;
                }
                
                if(abundant.contains(i - j))
                {
                    break;
                }
            }
        }
        
        return nonSumAbundant.stream().reduce(0, (s, i) -> s + i);
    }
}
