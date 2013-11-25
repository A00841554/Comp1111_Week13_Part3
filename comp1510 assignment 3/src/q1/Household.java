package q1;

import java.text.DecimalFormat;

/**
 * <p>This class is used to contain data for one household:
 * a four-digit integer identification number;
 * the annual income for the household;
 * the number of members in the household.</p>
 *
 * @author Eric Tsang, 1A, A00841554
 * @version 1.0
 */
public class Household {

    // instantiate supplier objects
    /** <p>used to format identification numbers in toString methods.</p> */
    private static final DecimalFormat ID_FMT = new DecimalFormat("0000");
    /** <p>used to format monetary numbers in toString methods.</p> */
    private static final DecimalFormat MONEY_FMT = new DecimalFormat("$0.00");

    // declare constants
    /** <p>desired length of a string. used in toString support method</p> */
    private static final int IDNUM_N_WHITESPACE_LENGTH = 25;
    /** <p>desired length of a string. used in toString support method</p> */
    private static final int ANNUALINCOME_N_WHITESPACE_LENGTH = 17;

    // declare variables
    /** <p>identification number for the household.</p> */
    private int idNum;
    /** <p>annual income for the household.</p> */
    private double annualIncome;
    /** <p>number of members in the household.</p> */
    private int memberCount;

    // ----------------------------------------------------
    // CONSTRUCTOR METHOD
    // ----------------------------------------------------
    /**
     * CONSTRUCTOR: instantiates a Household.
     * sets the identification number, annual salary, and
     * member count of a Household.
     * @param idNum           identification number for the household.
     * @param annualIncome    annual income of the household.
     * @param memberCount     number of members in the household.
     */
    public Household(int idNum, double annualIncome, int memberCount) {
        this.idNum = idNum;
        this.annualIncome = annualIncome;
        this.memberCount = memberCount;
    }

    // ----------------------------------------------------
    // MAIN METHOD
    // ----------------------------------------------------
    // why is it here? nobody knows...
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * @param args    unused.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        System.out.println("Question one was called and ran sucessfully.");
    }

    // ----------------------------------------------------
    // GETTER METHODS
    // ----------------------------------------------------
    /**
     * <p>returns the identification number for this household.</p>
     * @return    identification number for this household.
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * <p>returns the annual income for this household.</p>
     * @return    annual income of the household.
     */
    public double getAnnualIncome() {
        return annualIncome;
    }

    /**
     * <p>returns the number of members in this household.</p>
     * @return    number of members in this household.
     */
    public int getMemberCount() {
        return memberCount;
    }

    // ----------------------------------------------------
    // SETTER METHODS
    // ----------------------------------------------------
    /**
     * <p>assigns a new identification number to this household.</p>
     * @param idNum    new identification number of this household.
     */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /**
     * <p>assigns a new annual income to this household.</p>
     * @param annualIncome    new annual income of this household.
     */
    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     * <p>assigns a new amount of members in the household
     * to the household.</p>
     * @param memberCount    new amount of members in the household.
     */
    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    // ----------------------------------------------------
    // toString METHODS
    // ----------------------------------------------------
    /**
     * <p>prints out all information about the household.
     * information is separated by whitespace.</p>
     * @return    information about the household, separated by whitespace.
     */
    public String toString() {
        // declare variables
        String strIdNum;
        String strAnnualIncome;

        // create strings
        strIdNum = ID_FMT.format(idNum);
        strIdNum = appendWhiteSpace(strIdNum, IDNUM_N_WHITESPACE_LENGTH);
        strAnnualIncome = MONEY_FMT.format(annualIncome);
        strAnnualIncome = appendWhiteSpace(strAnnualIncome, ANNUALINCOME_N_WHITESPACE_LENGTH);

        return (strIdNum + strAnnualIncome + memberCount);
    }

    /**
     * <p>prints out desired information about the household.
     * information is separated by whitespace.</p>
     * @param prntIdNum           <code>true</code> to print identification number of household;
     *                            <code>false</code> otherwise.
     * @param prntAnnualIncome    <code>true</code> to print annual income of household;
     *                            <code>false</code> otherwise.
     * @param prntMemberCount     <code>true</code> to print number of members in household;
     *                            <code>false</code> otherwise.
     * @return                    information about the household, separated by whitespace.
     */
    public String toString(boolean prntIdNum, boolean prntAnnualIncome, boolean prntMemberCount) {
        // declare variables
        String strIdNum;
        String strAnnualIncome;
        String strMemberCount;

        // create strings
        if (prntIdNum) {
            strIdNum = ID_FMT.format(idNum);
            strIdNum = appendWhiteSpace(strIdNum, IDNUM_N_WHITESPACE_LENGTH);
        } else {
            strIdNum = "";
        }
        if (prntAnnualIncome) {
            strAnnualIncome = MONEY_FMT.format(annualIncome);
            strAnnualIncome = appendWhiteSpace(strAnnualIncome
                    , ANNUALINCOME_N_WHITESPACE_LENGTH);
        } else {
            strAnnualIncome = "";
        }
        if (prntMemberCount) {
            strMemberCount = Integer.toString(memberCount);
        } else {
            strMemberCount = "";
        }

        return (strIdNum + strAnnualIncome + strMemberCount);
    }

    // ----------------------------------------------------
    // toString SUPPORT METHOD
    // ----------------------------------------------------
    /**
     * <p>appends spaces to a string until it has
     * reached the desired length.</p>
     * @param string                string to be lengthened with whitespace.
     * @param targetStringLength    desired length of the string including whitespace.
     * @return                      modified string with whitespace.
     */
    private String appendWhiteSpace(String string, int targetStringLength) {
        while (string.length() < targetStringLength) {
            string = string + " ";
        }
        return string;
    }
}
