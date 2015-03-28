package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;


public class Sort
{
    public static <T extends Comparable<T>> void insertionSort(List<T> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            T element = list.get(i);

            int j = i - 1;
            while ((j >= 0) && (element.compareTo(list.get(j)) < 0))
            {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, element);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> list)
    {
        for (int j = 0; j < (list.size() - 1); j++)
        {
            int minIndex = j;
            for (int i = j; i < list.size(); i++)
            {
                if (list.get(minIndex).compareTo(list.get(i)) > 0)
                {
                    minIndex = i;
                }
            }

            T min = list.get(minIndex);
            list.set(minIndex, list.get(j));
            list.set(j, min);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int p, int q, int r)
    {
        List<T> left = new ArrayList<T>();
        for (int i = p; i < q; i++)
        {
            left.add(list.get(i));
        }

        List<T> right = new ArrayList<T>();
        for (int i = q; i < r; i++)
        {
            right.add(list.get(i));
        }

        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++)
        {
            if ((i < left.size()) && (((j < right.size()) && (left.get(i).compareTo(right.get(j)) < 0)) || (j >= right.size())))
            {
                list.set(k, left.get(i));
                i++;
            }
            else
            {
                list.set(k, right.get(j));
                j++;
            }
        }
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> list, int p, int r)
    {
        if (p >= (r - 1))
        {
            return;
        }

        int q = (r + p) / 2;
        mergeSort(list, p, q);
        mergeSort(list, q, r);
        merge(list, p, q, r);
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> list)
    {
        mergeSort(list, 0, list.size());
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = list.size() - 1; j > i; j--)
            {
                if (list.get(j).compareTo(list.get(j - 1)) < 0)
                {
                    T t = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, t);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void treeSort(List<T> list)
    {
        Tree<T> tree = new Tree<T>();

        for (T t : list)
        {
            tree.insert(t);
        }

        list.clear();

        for (T t : tree.getKeys())
        {
            list.add(t);
        }
    }

    public static <T extends Comparable<T>> void bubbleSort2(List<T> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            for (int j = list.size() - 1; j >= i; j--)
            {
                if (list.get(j).compareTo(list.get(j - 1)) < 0)
                {
                    T e = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, e);
                }
            }
        }
    }
}
