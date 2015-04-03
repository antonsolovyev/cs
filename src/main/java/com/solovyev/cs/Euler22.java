package com.solovyev.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Euler22
{
    /*
    Names scores

    Problem 22

    Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first
    names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply
    this value by its alphabetical position in the list to obtain a name score.

    For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is
    the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

    What is the total of all the name scores in the file?
     */

    public static List<String> readNameList() throws IOException, URISyntaxException
    {
        try(InputStream inputStream = Euler22.class.getClassLoader().getResourceAsStream("p022_names.txt"))
        {
            StringBuilder res = new StringBuilder();
            while (true)
            {
                byte[] buffer = new byte[4096];
                int n = inputStream.read(buffer);
                if (n == -1)
                {
                    break;
                }
                res.append(new String(buffer, 0, n));
            }

            return Arrays.asList(res.toString().replaceAll("\"", "").split(","));
        }
    }

    public static List<String> getSortedNameList() throws IOException, URISyntaxException
    {
        return readNameList().stream().sorted().collect(Collectors.toList());
    }

    public static int getNameWorth(String name)
    {
        return name.toUpperCase().chars().reduce(0, (res, c) -> res + (c - 64));
    }

    public static long solve() throws IOException, URISyntaxException
    {
        List<String> names = getSortedNameList();
        
        return IntStream.range(0, names.size()).reduce(0, (res, i) -> res + getNameWorth(names.get(i)) * (i + 1));
    }
}
