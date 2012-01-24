package com.solovyev.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinatoricsTest
{
	@Test
	public void combinationsTest()
	{
		long c1_0 = Combinatorics.combinations(1, 0);
		System.out.println("1,0: " + c1_0);
		assertTrue(c1_0 == 1);
		
		long c1_1 = Combinatorics.combinations(1, 1);
		System.out.println("1,1: " + c1_1);
		assertTrue(c1_1 == 1);
		
		long c2_1 = Combinatorics.combinations(2, 1);
		System.out.println("2,1: " + c2_1);
		assertTrue(c2_1 == 2);
		
		long c2_2 = Combinatorics.combinations(2, 2);
		System.out.println("2,2: " + c2_2);
		assertTrue(c2_2 == 1);
		
		long c4_2 = Combinatorics.combinations(4, 2);
		System.out.println("4,2: " + c4_2);
		assertTrue(c4_2 == 6);
		
		long c4_0 = Combinatorics.combinations(4, 0);
		System.out.println("4,0: " + c4_0);
		assertTrue(c1_0 == 1);
		
		long c4_4 = Combinatorics.combinations(4, 4);
		System.out.println("4,4: " + c4_4);
		assertTrue(c1_0 == 1);
		
		long c6_2 = Combinatorics.combinations(6, 2);
		System.out.println("6,2: " + c6_2);
		assertTrue(c6_2 == 15);
		
		long c8_3 = Combinatorics.combinations(8, 3);
		System.out.println("8,3: " + c8_3);
		assertTrue(c8_3 == 56);
		
		long c40_20 = Combinatorics.combinations(40, 20);
		System.out.println("40,20: " + c40_20);
		assertTrue(c40_20 == 137846528820L);
	}
}