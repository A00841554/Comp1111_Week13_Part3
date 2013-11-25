package q3;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Represents a college student.
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class Student {

    // create supplier objects
    /** Used to format a number into decimal format. */
    private static final DecimalFormat PERCENT_FMT = new DecimalFormat("0.00");

    // declare constants
    /** Number of tests. */
    private static final int TEST_COUNT = 3;

    // declare instance variables
    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Home address of this student. */
    private Address homeAddress;

    /** School address of this student.  Can be shared by other students. */
    private Address schoolAddress;

    /** Array that contains the score of each test. */
    private ArrayList<Double> testScores;

    // ------------------------------------------------------------
    // CONSTRUCTOR METHODS
    // ------------------------------------------------------------
    /**
     * Constructor: Sets up this student with the specified values.
     */
    public Student() {
        testScores = new ArrayList<Double>(TEST_COUNT);
        testScores.add(0.0);
        testScores.add(0.0);
        testScores.add(0.0);
    }

    /**
     * Constructor: Sets up this student with the specified values.
     * @param first     The first name of the student
     * @param last      The last name of the student
     * @param home      The home of the student
     * @param school    The school address of the student
     * @param score0    The score that the student got on test1
     * @param score1    The score that the student got on test2
     * @param score2    The score that the student got on test3
     */
    public Student(String first, String last, Address home, Address school,
            double score0, double score1, double score2) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        testScores = new ArrayList<Double>(TEST_COUNT);
        testScores.add(score0);
        testScores.add(score1);
        testScores.add(score2);
    }

    // ------------------------------------------------------------
    // SETTER METHOD
    // ------------------------------------------------------------
    /**
     * Sets student test score given test number.
     * @param test     number of the test
     * @param score    new score of specified test
     */
    public void setTestScore(int test, double score) {
        testScores.set(test, score);
    }

    /**
     * Sets first name of student given first name.
     * @param firstName    new first name of student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name of student given last name.
     * @param lastName    new last name of student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set home address of student given home address.
     * @param homeAddress    new home address
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Set school address of student given school address.
     * @param schoolAddress    new school address
     */
    public void setSchoolAddress(Address schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    // ------------------------------------------------------------
    // GETTER METHOD
    // ------------------------------------------------------------
    /**
     * Gets student test score given test number; returns it.
     * @param test    number of the test
     * @return        score student got on test specified
     */
    public double getTestScore(int test) {
        return testScores.get(test);
    }

    /**
     * Get number of tests the student needs to do; returns it.
     * @return    number of tests the student needs to do
     */
    public int getTestCount() {
        return TEST_COUNT;
    }

    // ------------------------------------------------------------
    // UNCATEGORIZED INTERFACE METHODS
    // ------------------------------------------------------------
    /**
     * Computes and returns student's test score average.
     * @return    average of all test scores
     */
    public double average() {
        // declare variables
        double total;

        // initiate variables
        total = 0;

        // compute total
        for (int i = 0; i < testScores.size(); i++) {
            total += testScores.get(i);
        }

        // compute and return average
        return (total / testScores.size());
    }

    // ------------------------------------------------------------
    // toString METHOD
    // ------------------------------------------------------------
    /**
     * Returns a string description of this Student object.
     * @return    formatted name and addresses of student
     */
    public String toString() {
        String result;

        result = "Name: " + firstName + " " + lastName + "\n";
        result += "Home Address: " + homeAddress + "\n";
        result += "School Address: " + schoolAddress + "\n";
        for (int i = 0; i < testScores.size(); i++) {
            result += "Test" + i + " Score: " + getTestScore(i) + "%\n";
        }
        result += "Test Average: " + PERCENT_FMT.format(average()) + "%";

        return result;
    }
}
