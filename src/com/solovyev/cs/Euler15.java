package com.solovyev.cs;

public class Euler15
{
	//
	// Count number of paths from upper left corner to bottom right corner on square grid (no backtracking).
	//
	// 1. Each path can be represented as a sequence of right/bottom moves. Lets mark right as 1 and left as 0
	// 2. There are 40 moves required to reach one corner from another
	// 3. Each path must contain 20 right moves and 20 bottom moves
	// 4. Hence we need to count the number of unique ways to distribute 20 ones in 40 slots
	// 5. Lets number slots 1 to 40. Each distribution is a unique combination of 20 numbers out of 40 total, or number of combinations of 20 from 40.
	// 6. The answer is 40! / ( 20! * (40 - 20)!) = 40! / 20! * 20! = (40 * 39 * .... * 21) / (1 * 2 * 3 * .... * 20)
	//
	
	public static long solution()
	{
		return Combinatorics.combinations(40, 20);
	}
}
