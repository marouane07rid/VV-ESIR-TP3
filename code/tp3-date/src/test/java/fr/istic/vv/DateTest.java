package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class DateTest {


    private int[][] testSet_isValidDate = {{1,3,2000}, {31,3,2000}, {-20,5,2000}, {31,4,2000}, {5,1,2000}, {5,12,2000}, {5,13,2000}, {5,5,-5}};
    private int[][] testSet_compareTo = {{1,1,2000}, {-20,5,1990}, {31,4,1500}};

    private List<Date> fillTestSet(int[][] dates) {
        List<Date> res = new ArrayList<Date>();
        for (int[] date : dates) {
            res.add(new Date(date[0], date[1], date[2]));
        }
        return res;
    }


    /////////////////////////////////////
    ///// Test isValidDate() method /////
    /////////////////////////////////////
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


    
}