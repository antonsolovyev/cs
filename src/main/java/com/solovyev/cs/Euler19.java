package com.solovyev.cs;


public class Euler19
{
    public static final int EPOCH_YEAR = 1900;
    public static final Month EPOCH_MONTH = Month.JANUARY;
    public static final int EPOCH_DAY = 1;
    public static final Weekday EPOCH_WEEKDAY = Weekday.SUNDAY;

    public static boolean isLeapYear(int year)
    {
        if ((((year % 4) == 0) && !((year % 100) == 0)) || ((year % 400) == 0))
        {
            return true;
        }

        return false;
    }

    public static int getNumberDays(Month m, int year)
    {
        if ((m == Month.FEBRUARY) && isLeapYear(year))
        {
            return Month.FEBRUARY.getDays() + 1;
        }

        return m.getDays();
    }

    public static int getDayOfYear(int year, Month month, int day)
    {
        int res = 0;

        for (Month m : Month.values())
        {
            if (m.ordinal() >= month.ordinal())
            {
                break;
            }
            res += getNumberDays(m, year);
        }

        res += day;

        return res;
    }

    public static int getDeltaDays(int year1, Month month1, int day1, int year2, Month month2, int day2)
    {
        int res = 0;

        for (int y = year1; y < year2; y++)
        {
            res += 365;
            if (isLeapYear(y))
            {
                res += 1;
            }
        }

        res += getDayOfYear(year2, month2, day2);

        res -= getDayOfYear(year1, month1, day1);

        return res;
    }

    public static Weekday getDay(int year, Month month, int day)
    {
        int delta = getDeltaDays(EPOCH_YEAR, EPOCH_MONTH, EPOCH_DAY, year, month, day);

        return Weekday.values()[(EPOCH_WEEKDAY.ordinal() + delta + 1) % 7];
    }

    public static int solve(int year1, int year2)
    {
        int res = 0;
        for (int y = year1; y <= year2; y++)
        {
            for (Month m : Month.values())
            {
                if (getDay(y, m, 1) == Weekday.SUNDAY)
                {
                    res++;
                }
            }
        }

        return res;
    }

    public enum Month
    {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        Month(int days)
        {
            this.days = days;
        }

        public int getDays()
        {
            return days;
        }
    }

    public enum Weekday
    {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
    }
}
