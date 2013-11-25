package q4;

import java.util.ArrayList;

/**
 * <p>represents a course taken at a school.</p>
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class Course {

    // declare constants
    /** <p>maximum amount of students for a course.</p> */
    private static final int MAX_STUDENTS = 5;

    // declare variables
    /** <p>list of students in the course.</p> */
    private ArrayList<Student> attenders;
    /** <p>name of the course.</p> */
    private String name;

    // -----------------------------------------
    // CONSTRUCTOR METHODS
    // -----------------------------------------
    /**
     * <p>initializes variables.
     * sets the name of the course given the name.</p>
     * @param courseName    name of the course.
     */
    public Course(String courseName) {
        attenders = new ArrayList<Student>(MAX_STUDENTS);
        name = courseName;
    }

    // -----------------------------------------
    // GETTER METHODS
    // -----------------------------------------
    /**
     * <p>returns the name of the course.</p>
     * @return    name of the course.
     */
    public String getName() {
        return name;
    }

    // -----------------------------------------
    // UNCATEGORIZED INTERFACE METHODS
    // -----------------------------------------
    /**
     * <p>if the course isn't full, add student to the course;
     * throws exception otherwise.</p>
     * @param student                      Student to be added.
     * @throws IllegalArgumentException    throws if array is full.
     */
    public void addStudent(Student student) {
        if (attenders.size() < MAX_STUDENTS) {
            attenders.add(student);
        } else {
            throw new IllegalArgumentException("The course is full!");
        }
    }

    /**
     * <p>calculates and returns the average mark of
     * all students in the course combined.</p>
     * @return    average mark of all students
     *            in the course combined.
     */
    public double average() {
        // declare variables
        double total;
        int studentCount;

        // initiate variables
        total = 0;
        studentCount = 0;

        // calculate sum of individual student averages
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (attenders.get(i) instanceof Student) {
                total += attenders.get(i).average();
                studentCount++;
            }
        }

        // calculate and return average of student averages
        return (total / studentCount);
    }

    /**
     * <p>prints all the students in the course.</p>
     */
    public void roll() {
        // print header
        System.out.println("printing student roll of " + name);

        // print student information
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (attenders.get(i) instanceof Student) {
                System.out.println("\nStudent" + i + ":");
                System.out.println(attenders.get(i));
            }
        }
    }
}
