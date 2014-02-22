package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Euler18
{
	private static final boolean DEBUG = false;
	
	public static List<List<Long>> stringToListList(String input)
	{
		List<List<Long>> res = new ArrayList<List<Long>>();
		
		String[] s = input.split("\n");
		
		for(String t : s)
		{
			List<Long> l = new ArrayList<Long>();
			String[] u = t.split("\\s+");
			for(String v : u)
			{
				l.add(Long.parseLong(v));
			}
			res.add(l);
		}
		
		return res;
	}

	/*
	 * We are building another triangle where each number is the cost of the best path from that point down.
	 * 
	 * Each next row up is obtained by choosing the best path down from the two alternatives + the cost of the current triangle row.
	 * 
	 * The result is the top value of the derivative triangle.
	 */
	public static long solve(List<List<Long>> triangle)
	{
		List<Long> list = new ArrayList<Long>();
		for(int i = 0; i < triangle.get(triangle.size() - 1).size() + 1; i++)
			list.add(0L);
		
		for(int i = 0; i < triangle.size(); i++)
		{
			if(DEBUG)
				System.out.println("list: " + list);
			
			List<Long> next = new ArrayList<Long>();
			List<Long> row = triangle.get(triangle.size() - 1 - i); 
			for(int j = 0; j < row.size(); j++)
			{
				if(list.get(j) > list.get(j + 1))
					next.add(list.get(j) + row.get(j));
				else
					next.add(list.get(j + 1) + row.get(j));
			}
			list = next;
		}
		return list.get(0);
	}
}