package q1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

import java.text.DecimalFormat;

/**
 * <p>count the number of households included in the survey; prints number.</p>
 * 
 * <p>prints three-column table displaying everything about each household.
 * calculate the average household income; prints average.</p>
 * 
 * <p>prints two-column table displaying the identification number and annual
 * income of each household that exceeds the average.</p>
 * 
 * <p>determine the percentage of households with incomes below the
 * low income cut-off (LICO) level; prints percentage.</p>
 * 
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class Survey {

    // instantiate supplier objects
    /** <p>file containing survey results.</p> */
    private static final File FILE = new File("survey.txt");
    /** <p>used to format double types into a currency format.</p> */
    private static final DecimalFormat MONEY_FMT = new DecimalFormat("$0.00");
    /** <p>used to format double types into a percentage format.</p> */
    private static final DecimalFormat PERCENT_FMT = new DecimalFormat("0.00%");

    // declare constants
    // i really wanted to use an array, but they were post-chapter seven...so i didn't use it
    /** <p>low income cut-off level for households with zero members.</p> */
    private static final int ZERO_MEMBER_LICO_LEVEL = 0;
    /** <p>low income cut-off level for households with one member.</p> */
    private static final int ONE_MEMBER_LICO_LEVEL = 22229;
    /** <p>low income cut-off level for households with two members.</p> */
    private static final int TWO_MEMBER_LICO_LEVEL = 27674;
    /** <p>low income cut-off level for households with three members.</p> */
    private static final int THREE_MEMBER_LICO_LEVEL = 34022;
    /** <p>low income cut-off level for households with four members.</p> */
    private static final int FOUR_MEMBER_LICO_LEVEL = 41307;
    /** <p>low income cut-off level for households with five members.</p> */
    private static final int FIVE_MEMBER_LICO_LEVEL = 46850;
    /** <p>low income cut-off level for households with six members.</p> */
    private static final int SIX_MEMBER_LICO_LEVEL = 52838;
    /** <p>low income cut-off level for households with seven members.</p> */
    private static final int SEVEN_MEMBER_LICO_LEVEL = 58827;
    /** <p>low income cut-off level increment for households beyond seven members.</p> */
    private static final int POST_SEVEN_MEMBER_LICO_LEVEL_INCREMENT = 5989;
    /** <p>possible number of members in a household.</p> */
    private static final int ZERO_MEMBERS = 0;
    /** <p>possible number of members in a household.</p> */
    private static final int ONE_MEMBER = 1;
    /** <p>possible number of members in a household.</p> */
    private static final int TWO_MEMBERS = 2;
    /** <p>possible number of members in a household.</p> */
    private static final int THREE_MEMBERS = 3;
    /** <p>possible number of members in a household.</p> */
    private static final int FOUR_MEMBERS = 4;
    /** <p>possible number of members in a household.</p> */
    private static final int FIVE_MEMBERS = 5;
    /** <p>possible number of members in a household.</p> */
    private static final int SIX_MEMBERS = 6;
    /** <p>possible number of members in a household.</p> */
    private static final int SEVEN_MEMBERS = 7;

    // ----------------------------------------------------
    // MAIN METHOD
    // ----------------------------------------------------
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * @param args    unused.
     */
    public static void main(String[] args) {
        try {
            // declare variables
            ArrayList<Household> survey;    // contains all households in the survey
            int householdCount;             // number of households in the survey
            double totalAnnualIncome;       // total annual income of combined households
            double averageAnnualIncome;     // average annual income of combined households
            int lowIncomeHouseholdCount;    // number of households under the LICO


            // initiate variables
            householdCount = 0;
            lowIncomeHouseholdCount = 0;
            totalAnnualIncome = 0;
            survey = new ArrayList<Household>();


            // populate survey ArrayList, calculate total annual income, count number of households
            System.out.println("***POPULATING survey ArrayList***");
            Scanner fileScan = new Scanner(FILE);
            
            
            while (fileScan.hasNextLine()) {
                // declare variables
                int idNum;
                double annualIncome;
                int memberCount;
                String string;


                // read from text file
                string = fileScan.next();
                string = filterString(string, "0123456789");
                idNum = Integer.parseInt(string); 

                string = fileScan.next();
                string = filterString(string, ".0123456789");
                annualIncome = Double.parseDouble(string);
                totalAnnualIncome += annualIncome;

                string = fileScan.next();
                string = filterString(string, "0123456789");
                memberCount = Integer.parseInt(string);


                // add Household to survey ArrayList
                survey.add(new Household(idNum, annualIncome, memberCount));
                householdCount++;
            }
            fileScan.close();
            System.out.println("done");


            // printing number of households in the survey
            System.out.println("\n\n***PRINTING NUMBER OF HOUSEHOLDS***");
            System.out.println("Number of Households: " + householdCount);
            System.out.println("done");


            // print out all households
            System.out.println("\n\n***PRINTING ALL HOUSEHOLDS***");
            System.out.println("Identification Number    Annual Income    Household Members");
            for (int i = 0; i < householdCount; i++) {
                Household household = survey.get(i);
                System.out.println(household);
            }
            System.out.println("done");


            // calculate and print average annual income
            System.out.println("\n\n***CALCULATE AND PRINT AVERAGE ANNUAL INCOME***");
            averageAnnualIncome = totalAnnualIncome / householdCount;
            System.out.println("Average Annual Income: " + MONEY_FMT.format(averageAnnualIncome));
            System.out.println("done");


            // print all households above average incomes
            System.out.println("\n\n***PRINTING HOUSEHOLDS WITH ABOVE AVERAGE ANNUAL INCOME***");
            System.out.println("Identification Number    Annual Income");
            for (int i = 0; i < householdCount; i++) {
                Household household = survey.get(i);
                if (household.getAnnualIncome() >= averageAnnualIncome) {
                    System.out.println(household.toString(true, true, false));
                }
            }
            System.out.println("done");


            // calculate and print percentage of households under the LICO
            System.out.println("\n\n***CALCULATE AND PRINT HOUSEHOLDS BELOW LICO***");
            for (int i = 0; i < householdCount; i++) {
                Household household = survey.get(i);
                if (isUnderLICO(household)) {
                    lowIncomeHouseholdCount++;
                }
            }
            System.out.println("Percentage of households under LICO: "
                    + PERCENT_FMT.format((double) lowIncomeHouseholdCount / householdCount));
            System.out.println("done"); 
        } catch (FileNotFoundException e) {
            System.out.println("***CANNOT FIND FILE***");
            e.printStackTrace();
        }

    }

    // ----------------------------------------------------
    // SUPPORT METHODS
    // ----------------------------------------------------
    /**
     * <p>removes all invalid characters from a string and returns it.</p>
     * @param string        string to be manipulated.
     * @param validChars    string of all valid characters.
     * @return              manipulated string that contains only valid characters.
     */
    private static String filterString(String string, String validChars) {
        char character;
        String newString;
        newString = "";
        for (int i = 0; i < string.length(); i++) {
            character = string.charAt(i);
            if (validChars.indexOf(character) != -1) {
                newString += string.substring(i, i + 1);
            }
        }
        return newString;
    }

    /**
     * <p>returns <code>true</code> if the annual income if household
     * is above the low income cut off rate; <code>false</code> otherwise.</p>
     * @param household    household to be assessed.
     * @return             <code>true</code> if the household is above LICO;
     *                     <code>false</code> otherwise.
     */
    private static boolean isUnderLICO(Household household) {
        // declare variables
        int householdLICO;

        // initiate variables
        switch (household.getMemberCount()) {
        case ZERO_MEMBERS:
            householdLICO = ZERO_MEMBER_LICO_LEVEL;
            break;
        case ONE_MEMBER:
            householdLICO = ONE_MEMBER_LICO_LEVEL;
            break;
        case TWO_MEMBERS:
            householdLICO = TWO_MEMBER_LICO_LEVEL;
            break;
        case THREE_MEMBERS:
            householdLICO = THREE_MEMBER_LICO_LEVEL;
            break;
        case FOUR_MEMBERS:
            householdLICO = FOUR_MEMBER_LICO_LEVEL;
            break;
        case FIVE_MEMBERS:
            householdLICO = FIVE_MEMBER_LICO_LEVEL;
            break;
        case SIX_MEMBERS:
            householdLICO = SIX_MEMBER_LICO_LEVEL;
            break;
        case SEVEN_MEMBERS:
            householdLICO = SEVEN_MEMBER_LICO_LEVEL;
            break;
        default:
            householdLICO = SEVEN_MEMBER_LICO_LEVEL;
            householdLICO += (household.getMemberCount() - SEVEN_MEMBERS)
                   * POST_SEVEN_MEMBER_LICO_LEVEL_INCREMENT;
            break;
        }
        return (household.getAnnualIncome() < householdLICO);
    }

}
