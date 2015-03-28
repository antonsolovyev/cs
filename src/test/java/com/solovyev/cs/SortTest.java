package com.solovyev.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import static org.junit.Assert.assertTrue;


public class SortTest
{
    private static final Logger LOGGER = Logger.getLogger(SortTest.class.getName());

    private static final List<Integer> LIST = Arrays.asList(11, 3, 18, 14, 3, 5, 11, 7, 4, 18, 9, 15, 2, 13, 5, 17, 10,
            16, 4, 8);
    private static final List<Integer> LIST2 = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LIST3 = Arrays.asList(5, 4, 3, 2, 1);
    private static final List<Integer> LIST4 = Arrays.asList(1, 1, 1, 1, 1);
    private static final List<Integer> LIST5 = Arrays.asList(1, 2, 1, 2, 1, 2);
    private static final List<Integer> LIST6 = Arrays.asList(2, 1, 2, 1, 2, 1);
    private static final List<Integer> LIST7 = Arrays.asList();
    private static final List<Integer> LIST8 = Arrays.asList(1);
    private static final List<Integer> LIST9 = Arrays.asList(1, 2);
    private static final List<Integer> LIST10 = Arrays.asList(2, 1);
    private static final List<Integer> LIST11 = Arrays.asList(5, 4, 3, 2, 1, 2, 3, 4, 5);
    private static final List<Integer> LIST12 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);


    @Test
    public void testInsertionSort() throws Exception
    {
        LOGGER.info("testing insertion sort");

        List<Integer> list = new ArrayList<Integer>(LIST);

        Sort.insertionSort(list);

        verifySort(LIST, list);
    }

    @Test
    public void testSelectionSort() throws Exception
    {

        LOGGER.info("testing selection sort");

        List<Integer> list = new ArrayList<Integer>(LIST);

        Sort.selectionSort(list);

        verifySort(LIST, list);
    }

    @Test
    public void testMergeSort() throws Exception
    {
        LOGGER.info("testing merge sort");

        List<Integer> list = new ArrayList<Integer>(LIST);

        Sort.mergeSort(list);

        verifySort(LIST, list);
    }

    @Test
    public void testBubbleSort() throws Exception
    {
        LOGGER.info("testing bubble sort");

        List<Integer> list = new ArrayList<Integer>(LIST);

        Sort.bubbleSort(list);

        verifySort(LIST, list);
    }

    @Test
    public void testBubbleSort2() throws Exception
    {
        LOGGER.info("testing bubble sort2");

        List<Integer> list = new ArrayList<Integer>(LIST);

        LOGGER.fine("input: " + list);

        Sort.bubbleSort2(list);

        LOGGER.fine("output: " + list);

        verifySort(LIST, list);
    }

    @Test
    public void testTreeSort() throws Exception
    {
        LOGGER.info("testing tree sort");

        List<Integer> list = new ArrayList<Integer>(LIST);

        LOGGER.fine("input: " + list);

        Sort.treeSort(list);

        LOGGER.fine("output: " + list);

        verifySort(LIST, list);
    }

    @Test
    public void testInsertionSort2() throws Exception
    {
        for (List<Integer> l :
            Arrays.asList(LIST, LIST2, LIST3, LIST4, LIST5, LIST6, LIST7, LIST8, LIST9, LIST10,
                LIST11, LIST12))
        {
            testSort(new Sorter<Integer>()
                {
                    @Override
                    public void sort(List<Integer> input)
                    {
                        Sort2.insertionSort(input);
                    }
                }, l);
        }
    }

    @Test
    public void testBubbleSort22() throws Exception
    {
        for (List<Integer> l :
            Arrays.asList(LIST, LIST2, LIST3, LIST4, LIST5, LIST6, LIST7, LIST8, LIST9, LIST10,
                LIST11, LIST12))
        {
            testSort(new Sorter<Integer>()
                {
                    @Override
                    public void sort(List<Integer> input)
                    {
                        Sort2.bubbleSort(input);
                    }
                }, l);
        }
    }

    @Test
    public void testMergeSort2() throws Exception
    {
        for (List<Integer> l :
            Arrays.asList(LIST, LIST2, LIST3, LIST4, LIST5, LIST6, LIST7, LIST8, LIST9, LIST10,
                LIST11, LIST12))
        {
            testSort(new Sorter<Integer>()
                {
                    @Override
                    public void sort(List<Integer> input)
                    {
                        Sort2.mergeSort(input);
                    }
                }, l);
        }
    }

    @Test
    public void testSelectionSort2() throws Exception
    {
        for (List<Integer> l :
            Arrays.asList(LIST, LIST2, LIST3, LIST4, LIST5, LIST6, LIST7, LIST8, LIST9, LIST10,
                LIST11, LIST12))
        {
            testSort(new Sorter<Integer>()
                {
                    @Override
                    public void sort(List<Integer> input)
                    {
                        Sort2.selectionSort(input);
                    }
                }, l);
        }
    }

    private <T extends Comparable<T>> void testSort(Sorter<T> sorter, List<T> input) throws Exception
    {
        List<T> sorted = new ArrayList<T>(input);
        sorter.sort(sorted);
        verifySort(input, sorted);
    }

    private <T extends Comparable<T>> void verifySort(List<T> unsorted, List<T> sorted) throws Exception
    {
        unsorted = new ArrayList<T>(unsorted);

        assertEquals("sorted/unsorted size mismatch", unsorted.size(), sorted.size());

        for (T i : sorted)
        {
            if (unsorted.contains(i))
            {
                unsorted.remove(i);
            }
            else
            {
                fail("sorted/unsorted content mismatch");
            }
        }

        for (int i = 0; i < (sorted.size() - 1); i++)
        {
            assertTrue("sorted is not in ascending order", sorted.get(i).compareTo(sorted.get(i + 1)) <= 0);
        }
    }

    private interface Sorter<T>
    {
        public void sort(List<T> input);
    }
}
