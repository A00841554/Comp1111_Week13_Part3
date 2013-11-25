package q4;

import java.util.Random;
import java.text.DecimalFormat;

/**
 * <p>driver class for the Course class.
 * instantiates a Course instance.
 * exercises every method of the Course instance.</p>
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class TestCourse {

    /** <p>used to generate random numbers.</p> */
    private static Random rnd = new Random();
    /** <p>used truncate digits two positions after decimal point.</p> */
    private static DecimalFormat fmt = new DecimalFormat("0.00");

    /** <p>maximum score that a student can get.</p> */
    private static final double MAX_SCORE = 100.0;

    /**
     * instantiates a Course instance.
     * instantiates five Student instances.
     * adds all Student instances to the Course instance.
     * calls roll method.
     * calls average method.
     * @param args    unused.
     */
    public static void main(String[] args) {
        // declare variables
        Course course;
        Student s1;
        Student s2;
        Student s3;
        Student s4;
        Student s5;
        Student s6;

        // instantiate a Course
        System.out.println("\n\n***INSTANTIATE COURSE***");
        course = new Course("COMP1510");

        // instantiate Students
        System.out.println("\n\n***INSTANTIATE STUDENTS***");
        s1 = new Student("Marco", "Lam",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());
        s2 = new Student("Bob", "Tang",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());
        s3 = new Student("Joe", "Huen",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());
        s4 = new Student("Cassie", "Kwan",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());
        s5 = new Student("Nicole", "Lee",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());
        s6 = new Student("Vanessa", "Poon",
                new Address("Some Road", "City", "Province", "Zip code"),
                new Address("Another Road", "City", "Province", "Zip code"),
                randomScore(), randomScore(), randomScore());

        // add Students
        System.out.println("\n\n***ADD STUDENTS***");
        addStudent(course, s1);
        addStudent(course, s2);
        addStudent(course, s3);
        addStudent(course, s4);
        addStudent(course, s5);
        addStudent(course, s6);

        // print roll
        System.out.println("\n\n***PRINT ROLL***");
        course.roll();

        // print average
        System.out.println("\n\n***PRINT AVERAGE***");
        System.out.println("student average of " + course.getName()
                + " is " + truncateDouble(course.average()) + "%");

    }

    // ---------------------------------------------
    // SUPPORT METHOD
    // ---------------------------------------------
    /**
     * <p>adds a Student instance to specified Course instance.</p>
     * @param course     Course instance Student instance is to be added to
     * @param student    Student instance to be added to Course instance
     */
    private static void addStudent(Course course, Student student) {
        try {
            System.out.println("adding student to " + course.getName());
            course.addStudent(student);
        } catch (IllegalArgumentException e) {
            System.out.println("course full!\n"
                    + "student not added.");
        }
    }

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
