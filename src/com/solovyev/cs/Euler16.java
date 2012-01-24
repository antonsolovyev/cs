package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Euler16
{
	// Return new binary with leading zeros removed
	public static List<Boolean> normalize(List<Boolean> a)
	{
		for(int i = 0; i < a.size(); i++)
			if(a.get(i))
				return new ArrayList<Boolean>(a.subList(i, a.size()));
		
		return new ArrayList<Boolean>();
	}
	
	// Convert a string of 0s and 1s to binary
	public static List<Boolean> stringToBinary(String s)
	{
		List<Boolean> res = new ArrayList<Boolean>();
		for(int i = 0 ; i < s.length(); i++)
		{
			if(s.charAt(i) == '1')
				res.add(true);
			else if(s.charAt(i) == '0')
				res.add(false);
			else
				throw new RuntimeException("unknown char: " + s.charAt(i) + " in binary number string");
		}
		return res;
	}
	
	// Convert binary to long
	public static long binaryToLong(List<Boolean> n)
	{
		long res = 0;
		long basePower = 1;
		for(int i = n.size() - 1; i >= 0; i--)
		{
			int d = n.get(i) ? 1 : 0;
			res += d * basePower;
			basePower *= 2;
		}
		return res;
	}
	
	// Convert long to binary
	public static List<Boolean> longToBinary(long l)
	{
		List<Boolean> res = new ArrayList<Boolean>();
		
		while(true)
		{
			if(l == 0)
				return normalize(res);
			
			if(l % 2 == 1)
				res.add(0, true);
			else
				res.add(0, false);
			
			l = l / 2;
		}		
	}
	
	// Subtract binaries
	public static List<Boolean> subtract(List<Boolean> a, List<Boolean> b)
	{
		List<Boolean> res = new ArrayList<Boolean>();
		
		a = normalize(a);
		b = normalize(b);
		if(a.size() < b.size())
			throw new RuntimeException("negative result");
		
		Boolean borrow = false;
		for(int i = 0; i < a.size(); i++)
		{
			Boolean da = a.get(a.size() - 1 - i);
			
			Boolean db;
			if(b.size() - 1 - i < 0)
				db = false;
			else
				db = b.get(b.size() - 1 - i);
			
			if(borrow)
			{
				if(da)
					borrow = false;
				
				da = !da;
			}
			
			if(da && db)
				res.add(0, false);
			if(da && !db)
				res.add(0, true);
			if(!db && !da)
				res.add(0, false);
			if(!da && db)
			{
				res.add(0, true);
				borrow = true;
			}
		}
		
		if(borrow)
			throw new RuntimeException("negative result");
		
		return normalize(res);
	}
	
	// Divide with remainder
	public static void divide(List<Boolean> dividend, List<Boolean> divisor, List<Boolean> quotinent, List<Boolean> remainder)
	{
		List<Boolean> q = new ArrayList<Boolean>();
		List<Boolean> r = new ArrayList<Boolean>();
		
		List<Boolean> div = new ArrayList<Boolean>();
		for(int i = 0; i < dividend.size(); i++)			
		{
			div.add(dividend.get(i));
			try
			{
				div = subtract(div, divisor);
				q.add(true);
			}
			catch(Exception e)
			{
				q.add(false);
				continue;
			}
		}
		
		for(Boolean b : div)
			r.add(b);
		
		quotinent.clear();
		quotinent.addAll(normalize(q));
		
		remainder.clear();
		remainder.addAll(normalize(r));
	}
	
	// Euler16 solve
	public static long solution()
	{
		List<Boolean> n = new ArrayList<Boolean>();
		n.add(true);
		for(int i = 0; i < 1000; i++)
			n.add(false);
		
		long res = 0;
		
		List<Boolean> dividend = n;
		List<Boolean> ten = longToBinary(10);
		while(true)
		{
			List<Boolean> quotinent = new ArrayList<Boolean>();
			List<Boolean> remainder = new ArrayList<Boolean>();
			
			divide(dividend, ten, quotinent, remainder);
			
			res += binaryToLong(remainder);
			
			if(quotinent.size() == 0)
				break;

			dividend = quotinent;
		}
		
		return res;
	}
}