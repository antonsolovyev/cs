package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.*;

public class SortTest
{
	private static final Random random = new Random();
	private static final int SIZE = 20;
	private static final int MAX_ELEMENT = 20;
	private static final ArrayList<Integer> LIST = new ArrayList<Integer>();
		
        static
	{
		for(int i = 0; i < SIZE; i++)
			LIST.add(random.nextInt(MAX_ELEMENT));
        }

	private static <T> List<T> cloneList(List<T> list)
	{
		ArrayList<T> res = new ArrayList<T>();
		for(T e : list)
			res.add(e);
		return res;
	}

	private <T extends Comparable<T>> void verifySort(List<T> unsorted, List<T> sorted) throws Exception
	{
		unsorted = cloneList(unsorted);
	
		if(sorted.size() != unsorted.size())
			throw new Exception("sorted/unsorted size mismatch");
		
		for(int i = 0; i < sorted.size() - 1; i++)
			if(sorted.get(i).compareTo(sorted.get(i + 1)) > 0)
				throw new Exception("sorted is not in ascending order");

		for(T i : sorted)
			if(unsorted.contains(i))
				unsorted.remove(i);
			else
				throw new Exception("sorted/unsorted content mismatch");
	}

	@Test
	public void insertionSortTest() throws Exception
	{
		System.out.println("--------> insertion sort");
		
		List<Integer> list = cloneList(LIST);
		
		//System.out.println("input: " + list);
		
		Sort.insertionSort(list);
		
		//System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}
	
	@Test
	public void selectionSortTest() throws Exception
	{
		
		System.out.println("--------> selection sort");
		
		List<Integer> list = cloneList(LIST);
		
		//System.out.println("input: " + list);
		
		Sort.selectionSort(list);
		
		//System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}
	
	@Test
	public void mergeSortTest() throws Exception
	{
		System.out.println("--------> merge sort");
		
		List<Integer> list = cloneList(LIST);
		
		//System.out.println("input: " + list);
		
		Sort.mergeSort(list);
		
		//System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}

	@Test
	public void bubbleSortTest() throws Exception
	{
		System.out.println("--------> bubble sort");
		
		List<Integer> list = cloneList(LIST);
		
		//System.out.println("input: " + list);
		
		Sort.bubbleSort(list);
		
		//System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}

	@Test
	public void bubbleSortTest2() throws Exception
	{
		System.out.println("--------> bubble sort2");
		
		List<Integer> list = cloneList(LIST);
		
		System.out.println("input: " + list);
		
		Sort.bubbleSort2(list);
		
		System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}

	@Test
	public void treeSortTest() throws Exception
	{
		System.out.println("--------> tree sort");
		
		List<Integer> list = cloneList(LIST);
		
		System.out.println("input: " + list);
		
		Sort.treeSort(list);
		
		System.out.println("output: " + list);
		
		verifySort(LIST, list);
	}
}