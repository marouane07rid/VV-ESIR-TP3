package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class DateTest { 

    /////////////////////////////////////
    ///// Test isValidDate() method /////
    /////////////////////////////////////
    private int[][] testSet_isValidDate = {{1,3,2000}, {31,3,2000}, {-20,5,2000}, {31,4,2000}, {5,1,2000}, {5,12,2000}, {5,13,2000}, {5,5,-5}};

    @Test
    void testIsValidDate_firstDay() {
        int[] date = testSet_isValidDate[0];
        assertTrue(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_lastDay() {
        int[] date = testSet_isValidDate[1];
        assertTrue(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_negativeDay() {
        int[] date = testSet_isValidDate[2];
        assertFalse(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_dayOutOfBounds() {
        int[] date = testSet_isValidDate[3];
        assertFalse(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_firstMonth() {
        int[] date = testSet_isValidDate[4];
        assertTrue(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_lastMonth() {
        int[] date = testSet_isValidDate[5];
        assertTrue(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_monthOutOfBounds() {
        int[] date = testSet_isValidDate[6];
        assertFalse(Date.isValidDate(date[0],date[1],date[2]));
    }

    @Test
    void testIsValidDate_negativeYear() {
        int[] date = testSet_isValidDate[7];
        assertTrue(Date.isValidDate(date[0],date[1],date[2]));
    }


    /////////////////////////////////////
    ///// Test isLeapyear() method //////
    /////////////////////////////////////
    private int[] testSet_isLeapYear = {800, 80, 200, 15};

    @Test
    void testIsLeapYear_modulo400() {
        assertTrue(Date.isLeapYear(testSet_isLeapYear[0]));
    }

    @Test
    void testIsLeapYear_modulo4butNot100() {
        assertTrue(Date.isLeapYear(testSet_isLeapYear[1]));
    }

    @Test
    void testIsLeapYear_modulo4and100() {
        assertFalse(Date.isLeapYear(testSet_isLeapYear[2]));
    }

    @Test
    void testIsLeapYear_moduloNot4andNot100() {
        assertFalse(Date.isLeapYear(testSet_isLeapYear[3]));
    }


    /////////////////////////////////////
    /////// Test nextDate() method //////
    /////////////////////////////////////
    private int[][] testSet_nextDate = {{15,10,2000}, {1,2,2000}, {31,1,2000}, {31,12,2000}, {29,2,800}, {28,2,801}};

    @Test
    void testNextsDate_midMonthDay() {
        Date date = new Date(testSet_nextDate[0][0],testSet_nextDate[0][1],testSet_nextDate[0][2]);
        date = date.nextDate();
        assertEquals(date.day, 16);
        assertEquals(date.month, 10);
        assertEquals(date.year, 2000);
    }

    @Test
    void testNextDate_firstDayOfMonth() {
        Date date = new Date(testSet_nextDate[1][0],testSet_nextDate[1][1],testSet_nextDate[1][2]);
        date = date.nextDate();
        assertEquals(date.day, 2);
        assertEquals(date.month, 2);
        assertEquals(date.year, 2000);
    }

    @Test
    void testNextDate_lastDayOfMonth() {
        Date date = new Date(testSet_nextDate[2][0],testSet_nextDate[2][1],testSet_nextDate[2][2]);
        date = date.nextDate();
        assertEquals(date.day, 1);
        assertEquals(date.month, 2);
        assertEquals(date.year, 2000);
    }

    @Test
    void testNextDate_lastDayOfYear() {
        Date date = new Date(testSet_nextDate[3][0],testSet_nextDate[3][1],testSet_nextDate[3][2]);
        date = date.nextDate();
        assertEquals(date.day, 1);
        assertEquals(date.month, 1);
        assertEquals(date.year, 2001);
    }

    @Test
    void testNextDate_endFebruaryBisextile() {
        Date date = new Date(testSet_nextDate[4][0],testSet_nextDate[4][1],testSet_nextDate[4][2]);
        date = date.nextDate();
        assertEquals(date.day, 1);
        assertEquals(date.month, 3);
        assertEquals(date.year, 800);
    }

    @Test
    void testNextDate_endFebruaryNonBisextile() {
        Date date = new Date(testSet_nextDate[5][0],testSet_nextDate[5][1],testSet_nextDate[5][2]);
        date = date.nextDate();
        assertEquals(date.day, 1);
        assertEquals(date.month, 3);
        assertEquals(date.year, 801);
    }



    /////////////////////////////////////
    ///// Test previousDate() method ////
    /////////////////////////////////////
    private int[][] testSet_previousDate = {{15,10,2000}, {1,2,2000}, {31,1,2000}, {1,1,2000}, {1,3,800}, {1,3,801}};

    @Test
    void testPreviousDate_midMonthDay() {
        Date date = new Date(testSet_previousDate[0][0],testSet_previousDate[0][1],testSet_previousDate[0][2]);
        date = date.previousDate();
        assertEquals(date.day, 14);
        assertEquals(date.month, 10);
        assertEquals(date.year, 2000);
    }

    @Test
    void testPreviousDate_firstDayOfMonth() {
        Date date = new Date(testSet_previousDate[1][0],testSet_previousDate[1][1],testSet_previousDate[1][2]);
        date = date.previousDate();
        assertEquals(date.day, 31);
        assertEquals(date.month, 1);
        assertEquals(date.year, 2000);
    }

    @Test
    void testPreviousDate_lastDayOfMonth() {
        Date date = new Date(testSet_previousDate[2][0],testSet_previousDate[2][1],testSet_previousDate[2][2]);
        date = date.previousDate();
        assertEquals(date.day, 30);
        assertEquals(date.month, 1);
        assertEquals(date.year, 2000);
    }

    @Test
    void testPreviousDate_firstDayOfYear() {
        Date date = new Date(testSet_previousDate[3][0],testSet_previousDate[3][1],testSet_previousDate[3][2]);
        date = date.previousDate();
        System.out.println(date.toString());
        assertEquals(date.day, 31);
        assertEquals(date.month, 12);
        assertEquals(date.year, 1999);
    }

    @Test
    void testpreviousDate_startMarchBisextile() {
        Date date = new Date(testSet_previousDate[4][0],testSet_previousDate[4][1],testSet_previousDate[4][2]);
        date = date.previousDate();
        assertEquals(date.day, 29);
        assertEquals(date.month, 2);
        assertEquals(date.year, 800);
    }

    @Test
    void testpreviousDate_startMarchNonBisextile() {
        Date date = new Date(testSet_previousDate[5][0],testSet_previousDate[5][1],testSet_previousDate[5][2]);
        date = date.previousDate();
        assertEquals(date.day, 28);
        assertEquals(date.month, 2);
        assertEquals(date.year, 801);
    }


    /////////////////////////////////////
    ////// Test pcompareTo() method /////
    /////////////////////////////////////
    private Date date = new Date(15,10,2000);

    @Test
    void testCompareTo_sameDate() {
        Date compareDate = new Date(15,10,2000);
        assertEquals(date.compareTo(compareDate), 0);
    }

    @Test
    void testCompareTo_earlierDate() {
        Date compareDate = new Date(14,10,2000);
        assertEquals(date.compareTo(compareDate), 1);
    }

    @Test
    void testCompareTo_laterDate() {
        Date compareDate = new Date(16,10,2000);
        assertEquals(date.compareTo(compareDate), -1);
    }

    @Test
    void testCompareTo_earlierMonth() {
        Date compareDate = new Date(15,9,2000);
        assertEquals(date.compareTo(compareDate), 1);
    }

    @Test
    void testCompareTo_laterMonth() {
        Date compareDate = new Date(15,11,2000);
        assertEquals(date.compareTo(compareDate), -1);
    }

    @Test
    void testCompareTo_earlierYear() {
        Date compareDate = new Date(15,10,1999);
        assertEquals(date.compareTo(compareDate), 1);
    }

    @Test
    void testCompareTo_laterYear() {
        Date compareDate = new Date(15,10,2001);
        assertEquals(date.compareTo(compareDate), -1);
    }
}