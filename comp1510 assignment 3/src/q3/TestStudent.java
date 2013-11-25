package q3;

import java.util.Random;
import java.text.DecimalFormat;

/**
 * <p>instantiates Student instances and exercises
 * every method of the Student class.</p>
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class TestStudent {

    // instantiate supplier classes
    /** <p>used to generate random numbers.</p> */
    private static Random rnd = new Random();
    /** <p>used truncate digits two positions after decimal point.</p> */
    private static DecimalFormat fmt = new DecimalFormat("0.00");

    // declare and initialize constants
    /** <p>maximum score that a student can get.</p> */
    private static final double MAX_SCORE = 100.0;

    // ------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        // declare variables
        Student s1;
        Student s2;

        // instantiate students
        System.out.println("\n\n***INSTANTIATING STUDENTS***");
        System.out.println("SUDENT 1-------------------------");
        s1 = new Student("Eric", "Tsang",
                new Address("Saba Road", "Richmond", "British Columbia", "V6Y 4C8"),
                new Address("I Don't Know Road", "Vancouver", "British Columbia", "H0H 0H0"),
                randomScore(), randomScore(), randomScore());
        System.out.println("SUDENT 2-------------------------");
        s2 = new Student();

        // call toString methods
        System.out.println("\n\n***CALLING toString METHODS***");
        System.out.println("SUDENT 1-------------------------");
        System.out.println(s1);
        System.out.println("SUDENT 2-------------------------");
        System.out.println(s2);

        // call setter methods
        System.out.println("\n\n***CALLING SETTER METHODS***");
        System.out.println("SUDENT 1-------------------------");
        s1.setTestScore(0, randomScore());
        System.out.println("SUDENT 2-------------------------");
        s2.setFirstName("Bobby");
        s2.setLastName("Lee");
        s2.setHomeAddress(new Address("Some Road", "Surry", "British Columbia", "H8D 0K2"));
        s2.setSchoolAddress(new Address("I Don't Know Road", "Vancouver"
                , "British Columbia", "H0H 0H0"));
        s2.setTestScore(1, randomScore());

        // call getter methods
        System.out.println("\n\n***CALLING GETTER METHODS***");
        System.out.println("SUDENT 1-------------------------");
        for (int i = 0; i < s1.getTestCount(); i++) {
            System.out.println("Test" + i + " Score: " + s1.getTestScore(i) + "%");
        }
        System.out.println("SUDENT 2-------------------------");
        for (int i = 0; i < s2.getTestCount(); i++) {
            System.out.println("Test" + i + " Score: " + s2.getTestScore(i) + "%");
        }

        // call average methods
        System.out.println("\n\n***CALLING average METHODS***");
        System.out.println("SUDENT 1-------------------------");
        System.out.println("Average: " + truncateDouble(s1.average()) + "%");
        System.out.println("SUDENT 2-------------------------");
        System.out.println("Average: " + truncateDouble(s2.average()) + "%");

        // call toString methods
        System.out.println("\n\n***CALLING toString METHODS***");
        System.out.println("SUDENT 1-------------------------");
        System.out.println(s1);
        System.out.println("SUDENT 2-------------------------");
        System.out.println(s2);

        System.out.println("Question three was called and ran sucessfully.");
    }

    // ------------------------------------------------
    // SUPPORT METHOD
    // ------------------------------------------------
    /**
     * Generates a random score; returns it.
     * @return randomly generated score.
     */
    private static double randomScore() {
        double ret;
        ret = rnd.nextDouble() * MAX_SCORE;
        return truncateDouble(ret);
    }

    /**
     * <p>Takes a double number, and truncates all digits past and
     * including the third digit after the decimal point.</p>
     * @param number    double number to be truncated
     * @return          truncated double number
     */
    private static double truncateDouble(double number) {
        return Double.parseDouble(fmt.format(number));
    }

}
