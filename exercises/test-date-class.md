# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1. We select a test set for each method. The inputs that need to be tested for every method are at the boundaries of days and months(e.g. 1/1/2000, 31/12/2000, ...) and also at the boundaries of february march (leap year). Each boundary must be tested separately. There are 4 parameters used in this class : day, month, year, and Date. Date includes all the other fields. It means that almost every mothod (except isLeapYear()) uses day, month and year value.

|                   | classic date  | outOfBounds | negative date |
| :---------------  |:-------------:| :----------:| :-----------: |
| not leap year     |   15/5/2000   | 29/2/2000   | -5/1/2000     |
| leap year         |   15/5/2000   | 30/2/2000   | -5/1/2000     |

2. When we checked the if statement, we decided to add some tests at boundaries. Especially for nextDate() and previousDate(). We added this.

|                   |   first day   |   last day  | first of year |
| :---------------  |:-------------:| :----------:| :-----------: |
| not leap year     |    1/6/801    |   28/2/801  |   1/1/801     |
| leap year         |    1/3/800    |   29/2/800  |   1/1/800     |

3. For example with isLeapYear(), we need to test every possible case:

- year is modulo 400
- year is modulo4 and modulo 100
- year is modulo 4 but not 100
- year is not modulo 4 but modulo 100 (impossible according to math)
- year is not modulo 4 and not modulo 100

```
(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
```

4. Here is the pitest review of Date class

![image](/ressources/pitest_date.png)

After some improvements and after adding some test, we have a better coverage.

![image](/ressources/pitest_date_improved.png)
