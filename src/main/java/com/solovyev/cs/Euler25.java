package com.solovyev.cs;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Euler25
{
    public static final int FIBONACCI_0 = 0;
    public static final int FIBONACCI_1 = 1;

    public static int solve()
    {
        List<Integer> fibonacci;
        List<Integer> fibonacciPreviousPrevious = Arrays.asList(FIBONACCI_0);
        List<Integer> fibonacciPrevious = Arrays.asList(FIBONACCI_1);

        int term = 2;
        while (true)
        {
            fibonacci = Euler20.add(fibonacciPrevious, fibonacciPreviousPrevious);

            if (fibonacci.size() >= 1000)
            {
                return term;
            }

            fibonacciPreviousPrevious = fibonacciPrevious;
            fibonacciPrevious = fibonacci;
            term++;
        }
    }
}
