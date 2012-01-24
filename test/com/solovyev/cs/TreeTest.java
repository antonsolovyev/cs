package com.solovyev.cs;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TreeTest
{
	private static final Random random = new Random();
	private static final int SIZE = 20;
	private static final int MAX_ELEMENT = 10;
	private ArrayList<Integer> list;
	private Tree<Integer> tree;
	
	@Before
	public void init()
	{
		tree = new Tree<Integer>();
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < SIZE; i++)
		{
			int e = random.nextInt(MAX_ELEMENT);
			list.add(e);
			tree.insert(e);
		}		
	}
	
	@Test
	public void getKeysInOrderTest()
	{
		System.out.println(list);			
		System.out.println(tree.getKeys());			
	}
	
	@Test
	public void getKeyTest() throws Exception
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(tree.getKey(list.get(i)) == null)
				throw new Exception("element: " + list.get(i) + " not found");
		}
	}
	
	@Test
	public void getMinMaxTest() throws Exception
	{
		System.out.println("sorted list: " + tree.getKeys());
		System.out.println("min: " + tree.getMin());
		System.out.println("max: " + tree.getMax());
	}
	
	@Test
	public void getSuccessorPredecessorTest() throws Exception
	{
		System.out.println("list: " + list);
		System.out.println("sorted list: " + tree.getKeys());

		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("successor for: " + list.get(i) + " is: " + tree.getSuccessor(list.get(i)));
			System.out.println("predecessor for: " + list.get(i) + " is: " + tree.getPredecessor(list.get(i)));
		}		
	}
	
	@Test
	public void deleteTest()
	{
		System.out.println("list: " + list);
		System.out.println("tree: " + tree.getKeys());
		System.out.println("tree.toString(): " + tree);

		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("deleting: " + list.get(i));
			tree.delete(list.get(i));
			System.out.println("tree: " + tree.getKeys());
		}		
	}	
}
