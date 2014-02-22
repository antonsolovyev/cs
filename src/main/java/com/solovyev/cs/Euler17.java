package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Euler17
{
	private static final boolean DEBUG = true;
	
	private static final String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static List<Integer> longToDecimalDigitList(long n)
	{
		List<Integer> res = new ArrayList<Integer>();		
		while(true)
		{
			if(n == 0)
				break;
			
			res.add(0, (int)(n % 10));
			
			n = n / 10;
		}
		return res;
	}
	
	public static String sayNumber(long n)
	{
		if(n < 1 || n > 1000)
			throw new RuntimeException("don't know how to say \"" + n + "\"");

		List<Integer> digits = longToDecimalDigitList(n);
		
		String res = "";
		
		for(int i = 0; i < digits.size(); i++)
		{
			int digit = digits.get(digits.size() - 1 - i);
			
			if(i == 0)
			{
				if(digit != 0)
					res = ones[(int) digit - 1];
			}
			else if(i == 1)
			{
				if(digit != 0)
				{
					if(digit == 1)
					{
						digit = digits.get(digits.size() - 1);
						res = teens[digit];
					}
					else
						res = tens[digit - 2] + " " + res;
				}
			}
			else if(i == 2)
			{
				if(digit != 0)
					res = ones[(int) digit - 1] + " hundred" + (res.length() == 0 ? "" : " and " + res);
			}
			else if(i == 3)
			{
				if(digit != 0)
					res = ones[(int) digit - 1] + " thousand " + res;
			}
			else
			{
				throw new RuntimeException("can't get here");
			}
		}

		return res.replaceFirst("\\s+$", "");
	}

	public static long solve()
	{
		String res = "";
		for(int i = 1; i <= 1000; i++)
		{
			String n = sayNumber(i);
			
			if(DEBUG)
				System.out.println(i + ": " + n);
			
			res += " " + n;
		}
		
		res = res.replace(" ", "");
		
		return res.length();
	}
}
