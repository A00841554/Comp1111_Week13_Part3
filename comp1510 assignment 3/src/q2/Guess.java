package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>plays a guessing game.</p>
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class Guess {

    // instantiate supplier objects
    /** <p>used to generate numbers.</p> */
    private static final Random RND = new Random();
    /** <p>used to read user input.</p> */
    private static final Scanner SCAN = new Scanner(System.in);

    // declare constants
    /** <p>range of the number to be generated.</p> */
    private static final int MAX_NUM = 100;


    // ----------------------------------------------------
    // MAIN METHOD
    // ----------------------------------------------------
    /**
     * <p>picks a random number between 1 and 100 (inclusive).
     * repeatedly prompt the user to guess the number.
     * On each guess, report to the user that he or she is correct,
     * or the guess is high or low. Continue accepting guesses
     * until the user guesses correctly or chooses to quit.
     * Count the number of guesses and report that value when the
     * user guesses correctly. At the end of each game (by quitting
     * or guessing correctly), prompts to determine whether the
     * player wants to play again. Continue playing games until
     * the user chooses to stop.</p>
     * @param args    unused.
     */
    public static void main(String[] args) {
        // declare variables
        boolean continueGame;
        int targetNum;
        int guessCount;
        Integer guess;
        String input;

        // initialize variables
        input = "";
        guess = null;

        do {
            // reset/initialize guess count
            guessCount = 0;

            // pick a number between 1 and 100, inclusive
            targetNum = RND.nextInt(MAX_NUM) + 1;       // generates a number between 1 and 100
            System.out.println("I've picked a number between 1 and 100.\n"
                    + "Guess what I picked.\n"
                    + "You may also type \"quit\" to terminate the program.");


            // prompts for input and re-prompts until input is valid then reads
            input = getValidInput();
            if (!input.equals("quit")) {
                guess = Integer.parseInt(input);
                guessCount++;
            }

            // lets user guess until they win or quit
            continueGame = true;
            while (continueGame) {

                // check if user quits
                if (!input.equals("quit")) {

                    // checks if user wins
                    if (guess == targetNum) {

                        // prints feedback, ends game
                        System.out.println("CONGRATZ!!!!Q!!!! YOU WINN!!!!!!!!!!!!");
                        continueGame = false;

                    } else {

                        // prints feedback
                        if (guess > targetNum) {
                            System.out.println("Your guess is too high. Try again.");
                        } else {
                            System.out.println("Your guess is too low. Try again.");
                        }                

                        // prompts for input and re-prompts until input is valid then reads
                        input = getValidInput();
                        if (!input.equals("quit")) {
                            guess = Integer.parseInt(input);
                            guessCount++;
                        }
                    }
                } else {

                    System.out.println("You quit!");
                    continueGame = false;

                }
            }
            System.out.println("You guessed " + guessCount + " times.");
            System.out.println("Would you like to play again? [\"yes\"/\"no\"]");
            input = SCAN.nextLine();
        } 
        while(input.equals("yes"));
        System.out.println("See you later!");
    }

    // ----------------------------------------------------
    // SUPPORT METHODS
    // ----------------------------------------------------
    /**
     * <p>continuously prompt for input until input is valid.
     * an input is valid if:
     *     it may be parsed into an integer between 1 and 100 (inclusive)
     *         OR
     *     the String is equal to &quot;quit&quot;</p>
     * @return          valid input.
     */
    private static String getValidInput() {
        // declare variables
        String ret;
        String string;

        // initialize variables
        ret = null;
        string = SCAN.nextLine();

        // continually prompt for input until input is deemed valid
        if (isValidInteger(string)) {
            ret = string;
        } else {
            if (string.equals("quit")) {
                ret = string;
            } else {
                System.out.println("Invalid input! Please enter "
                        + "an integer value from 1 to 100. Or type \"quit\" to quit.");
                ret = getValidInput();
            }
        }

        // returns valid input
        return ret;
    }

    /**
     * <p>checks if given string can be parsed into an integer.
     * if the integer can be parsed, checks if it is between 1 and 100 (inclusive).
     * if it is between 1 and 100 (inclusive), return <code>true</code>;
     * <code>false</code> otherwise.</p>
     * @param integerString    string to be evaluated
     * @return                 <code>true</code> if the string can be parsed to an
     *                         integer and falls between 1 and 100 (inclusive);
     *                         <code>false</code> otherwise.
     */
    private static boolean isValidInteger(String integerString) {
        // instantiate supplier objects
        Scanner scan = new Scanner(integerString);

        // declare variables
        boolean ret;

        // initialize variables
        ret = (scan.hasNextInt() && Integer.parseInt(integerString) >= 1
                && Integer.parseInt(integerString) <= MAX_NUM);

        // return results
        scan.close();
        return ret; 
    }
}
