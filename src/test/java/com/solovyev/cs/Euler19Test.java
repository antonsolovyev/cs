package com.solovyev.cs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.*;


public class Euler19Test
{
    @Test
    public void testIsLeapYear() throws Exception
    {
        assertTrue(Euler19.isLeapYear(1904));
        assertFalse(Euler19.isLeapYear(1900));
        assertTrue(Euler19.isLeapYear(2000));
    }

    @Test
    public void testGetNumberDays() throws Exception
    {
        assertEquals(28, Euler19.getNumberDays(Euler19.Month.FEBRUARY, 1903));
        assertEquals(29, Euler19.getNumberDays(Euler19.Month.FEBRUARY, 1904));
        assertEquals(28, Euler19.getNumberDays(Euler19.Month.FEBRUARY, 1900));
        assertEquals(29, Euler19.getNumberDays(Euler19.Month.FEBRUARY, 2000));

        assertEquals(31, Euler19.getNumberDays(Euler19.Month.JANUARY, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.MARCH, 1900));
        assertEquals(30, Euler19.getNumberDays(Euler19.Month.APRIL, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.MAY, 1900));
        assertEquals(30, Euler19.getNumberDays(Euler19.Month.JUNE, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.JULY, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.AUGUST, 1900));
        assertEquals(30, Euler19.getNumberDays(Euler19.Month.SEPTEMBER, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.OCTOBER, 1900));
        assertEquals(30, Euler19.getNumberDays(Euler19.Month.NOVEMBER, 1900));
        assertEquals(31, Euler19.getNumberDays(Euler19.Month.DECEMBER, 1900));
    }

    @Test
    public void testGetDayOfYear() throws Exception
    {
        assertEquals(32, Euler19.getDayOfYear(1900, Euler19.Month.FEBRUARY, 1));
        assertEquals(365, Euler19.getDayOfYear(1900, Euler19.Month.DECEMBER, 31));

        assertEquals(32, Euler19.getDayOfYear(1903, Euler19.Month.FEBRUARY, 1));
        assertEquals(365, Euler19.getDayOfYear(1903, Euler19.Month.DECEMBER, 31));

        assertEquals(32, Euler19.getDayOfYear(1904, Euler19.Month.FEBRUARY, 1));
        assertEquals(366, Euler19.getDayOfYear(1904, Euler19.Month.DECEMBER, 31));

        assertEquals(32, Euler19.getDayOfYear(2000, Euler19.Month.FEBRUARY, 1));
        assertEquals(366, Euler19.getDayOfYear(2000, Euler19.Month.DECEMBER, 31));
    }

    @Test
    public void testGetDeltaDays() throws Exception
    {
        Calendar calendar = new GregorianCalendar(1900, 1, 1);
        Calendar calendar2 = new GregorianCalendar(2002, 1, 1);
        int days = (int) ((calendar2.getTime().getTime() - calendar.getTime().getTime()) / TimeUnit.DAYS.toMillis(1));
        assertEquals(days, Euler19.getDeltaDays(1900, Euler19.Month.JANUARY, 1, 2002, Euler19.Month.JANUARY, 1));

        calendar = new GregorianCalendar(1943, 3, 25);
        calendar2 = new GregorianCalendar(1969, 5, 22);
        days = (int) ((calendar2.getTime().getTime() - calendar.getTime().getTime()) / TimeUnit.DAYS.toMillis(1));
        assertEquals(days, Euler19.getDeltaDays(1943, Euler19.Month.MARCH, 25, 1969, Euler19.Month.MAY, 22));

    }

    @Test
    public void testGetDay() throws Exception
    {
        Calendar calendar = new GregorianCalendar(2002, 0, 1);
        String dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());

        assertEquals(dayName.toUpperCase(), Euler19.getDay(2002, Euler19.Month.JANUARY, 1).name());
    }

    @Test
    public void testSolve() throws Exception
    {
        int res = Euler19.solve(1901, 2000);
        System.out.println("Euler 19 answer: " + res);
        assertEquals(171, res);
    }
}
