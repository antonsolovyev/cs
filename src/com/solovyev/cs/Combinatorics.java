package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Combinatorics
{
	public static final boolean DEBUG = false;
	
	/**
	 * Calculate number of unordered combinations of k elements of set of n elements using Pascal triangle.
	 * 
	 * @param n size of set to choose from
	 * @param k size of the subset
	 * @return number of combinations
	 */
	public static long combinations(int n, int k)
	{
		if(k > n)
			return 0;

		List<Long> line = new ArrayList<Long>();
		line.add(1L);
		for(int i = 0; i < n; i++)
			line = nextPascalTriangleLine(line);
		
		return line.get(k);
	}
	
	private static List<Long> nextPascalTriangleLine(List<Long> line)
	{
		if(DEBUG)
			System.out.println("input line: " + line);
		
		List<Long> res = new ArrayList<Long>();
		
		res.add(1L);
		for(int i = 0; i < line.size() - 1; i++)
			res.add(line.get(i) + line.get(i + 1));
		res.add(1L);
	
		if(DEBUG)
			System.out.println("output line: " + line);
		
		return res;
	}
}