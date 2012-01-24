package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Euler11
{
	private static final boolean DEBUG = false;
	
	private static List<List<Long>> parseMatrix(String matrix)
	{
		List<List<Long>> res = new ArrayList<List<Long>>();
		for(String r : matrix.split("\n"))
		{
			List<Long> row = new ArrayList<Long>(); 
			String[] bits = r.split(" ");
			for(String b : bits)
			{
				row.add(Long.parseLong(b));
			}
			res.add(row);
		}
		
		if(DEBUG)
			for(List<Long> list : res)
			{
				for(Long l : list)
				{
					System.out.print(l + " ");
				}
				System.out.print("\n");
			}
		return res;
	}
	
	public static long solve(String matrixAsString)
	{
		List<List<Long>> matrix = parseMatrix(matrixAsString);
		
		// Assume square matrix
		long n = matrix.size();
		
		//
		//   1. + X + +
		//
		//   2. +
		//      X
		//      +
		//      +
		//
		//   3. +
		//        X
		//          +
		//            +
		//
		//   4.
		//          +
		//        X
		//      +
		//    +
		//
		long max = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(j - 1 >= 0 && j + 2 < n)
					max = Math.max(max, matrix.get(i).get(j - 1) * matrix.get(i).get(j) * matrix.get(i).get(j + 1) * matrix.get(i).get(j + 2));
				
				if(i - 1 >= 0 && i + 2 < n)
					max = Math.max(max, matrix.get(i - 1).get(j) * matrix.get(i).get(j) * matrix.get(i + 1).get(j) * matrix.get(i + 2).get(j));
				
				if(i - 1 >= 0 && i + 2 < n && j - 1 >=0 && j + 2 < n)
					max = Math.max(max, matrix.get(i - 1).get(j - 1) * matrix.get(i).get(j) * matrix.get(i + 1).get(j + 1) * matrix.get(i + 2).get(j + 2));
				
				if(i - 1 >= 0 && i + 2 < n && j - 2 >= 0 && j + 1 < n)
					max = Math.max(max, matrix.get(i - 1).get(j + 1) * matrix.get(i).get(j) * matrix.get(i + 1).get(j - 1) * matrix.get(i + 2).get(j - 2));
			}
		}

		return max;
	}
}