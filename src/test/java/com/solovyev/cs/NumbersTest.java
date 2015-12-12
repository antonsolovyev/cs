package com.solovyev.cs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by antonsolovyev on 12/12/15.
 */
public class NumbersTest {

    @Test
    public void testDecimalDigitListToLong() throws Exception
    {
        assertEquals(new Long(123456789), Numbers.decimalDigitListToLong(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
}