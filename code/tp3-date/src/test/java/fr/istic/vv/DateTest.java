package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class DateTest {


    List<Date> testSet = new ArrayList<Date>();

    private void fillTestSet(int[][] dates) {
        for (int[] date : dates) {
            testSet.add(new Date(date[0], date[1], date[2]));
        }
    }

    private void clearTestSet() {
        testSet.clear();
    }


    @Test
    void testDate() {
        int[][] testSet = {{1,1,2000}, {-20,5,1990}, {31,4,1500}};
    }


    @Test
    void testIsValidDate() {
        int[][] testSet = {{1,1,2000}, {-20,5,1990}, {31,4,1500}};

    }
}