package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Sort2
{
    private static final Logger LOGGER = Logger.getLogger(Sort2.class.getName());

    public static <T extends Comparable<T>> void insertionSort(List<T> input)
    {
        for (int i = 1; i < input.size(); i++)
        {
            T t = input.get(i);
            for (int j = i - 1; j >= 0; j--)
            {
                if (t.compareTo(input.get(j)) < 0)
                {
                    input.set(j + 1, input.get(j));
                    input.set(j, t);
                }
                else
                {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> input)
    {
        for (int i = 0; i < input.size(); i++)
        {
            int idx = i;
            T min = input.get(i);
            for (int j = i; j < input.size(); j++)
            {
                if (min.compareTo(input.get(j)) >= 0)
                {
                    idx = j;
                    min = input.get(j);
                }

            }
            swap(input, i, idx);
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> input)
    {
        for (int i = 0; i < input.size(); i++)
        {
            // System.out.println("pass #: " + i);
            for (int j = input.size() - 1; j > i; j--)
            {
                if (input.get(j).compareTo(input.get(j - 1)) < 0)
                {
                    swap(input, j, j - 1);
                }
                // System.out.println("state: " + input);
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> input)
    {
        mergeSort(input, 0, input.size() - 1);
    }

    private static <T extends Comparable> void mergeSort(List<T> input, int p, int r)
    {
        if (p >= r)
        {
            return;
        }

        int q = p + ((r - p + 1) / 2);

        mergeSort(input, p, q - 1);
        mergeSort(input, q, r);
        merge(input, p, q, r);
    }

    private static <T extends Comparable> void merge(List<T> input, int p, int q, int r)
    {
        List<T> left = new ArrayList<T>(input.subList(p, q));
        List<T> right = new ArrayList<T>(input.subList(q, r + 1));

        int i = 0; // left
        int j = 0; // right
        int k = p; // input

        while (k <= r)
        {
            if ((i < left.size()) && ((j >= right.size()) || (left.get(i).compareTo(right.get(j)) < 0)))
            {
                input.set(k, left.get(i));
                i++;
            }
            else
            {
                input.set(k, right.get(j));
                j++;
            }

            k++;
        }
    }

    private static <T> void swap(List<T> list, int i, int j)
    {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
}
