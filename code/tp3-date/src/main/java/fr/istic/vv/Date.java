package fr.istic.vv;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

class Date implements Comparable<Date> {

    int day;
    int month;
    int year;
    static Map<Integer, Integer> joursMois = initializeJoursMois();

    public Date(int day, int month, int year) throws IllegalArgumentException {

        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
            initializeJoursMois();
        } else
            throw new IllegalArgumentException();
    }



    public static Map<Integer, Integer> initializeJoursMois() {
        joursMois = new TreeMap<Integer, Integer>();
        joursMois.put(1, 31);
        joursMois.put(2, 28);
        joursMois.put(3, 31);
        joursMois.put(4, 30);
        joursMois.put(5, 31);
        joursMois.put(6, 30);
        joursMois.put(7, 31);
        joursMois.put(8, 31);
        joursMois.put(9, 30);
        joursMois.put(10, 31);
        joursMois.put(11, 30);
        joursMois.put(12, 31);
        return joursMois;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day > 0 && month > 0 && month <= 12) {
            if ((isLeapYear(year) && month == 2 && day <= 29) || joursMois.get(month) >= day) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public Date nextDate() {
        if (!isValidDate(day + 1, month, year)) {
            return new Date(day + 1, month, year);
        } else if (!isValidDate(1, month + 1, year)) {
            return new Date(1, month + 1, year);
        } else {
            return new Date(1, 1, year + 1);
        }
    }

    public Date previousDate() {
        if (!isValidDate(day - 1, month, year)) {
            return new Date(day - 1, month, year);
        } else if (!isValidDate(joursMois.get(month - 1), month - 1, year)) {
            return new Date(joursMois.get(month - 1), month - 1, year);
        } else {
            return new Date(joursMois.get(12), 12, year - 1);
        }
    }

    

    public int compareTo(Date other) {
        if (other != null) {
            if (other.year < this.year) {
                return 1;
            } else if (other.year > this.year) {
                return -1;
            } else if (other.month < this.month) {
                return 1;
            } else if (other.month > this.month) {
                return -1;
            } else if (other.day < this.day) {
                return 1;
            } else if (other.day > this.day) {
                return -1;
            } else
                return 0;
        } else
            throw new NullPointerException();
    }
}