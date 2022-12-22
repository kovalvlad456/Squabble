/**
 * Letter
 * @author Vlad Koval
 * CS1027
 * Assignment 2
 */

public class Letter {
    private char letter;
    private int label;
    //setting constant variables
    private final int UNSET = 1;
    private final int UNUSED = 2;
    private final int USED = 3;
    private final int CORRECT = 4;

    /**
     * default Constructor
     * @param c letter to be intialized
     */
    public Letter(char c) {
        this.label = UNSET;
        this.letter = c;
    }

    /**
     * Equals 
     * @param otherObject object to be compared to
     * @return true or false depending on whether other object is an instance of the Letter class
     */
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetterObject = (Letter)otherObject;  // cast to letter
            if (this.letter == otherLetterObject.letter) { //comparing both objects
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * decorator method
     * @return label for the letter selected
     */
    public String decorator() {
        if (label == USED) {
            return "+";
        } else if (label == UNUSED) {
            return "-";
        } else if (label == CORRECT) {
            return "!";
        } else if (label == UNSET) {
            return " ";
        } else {
            return "";
        }
    }

    /**
     * toString method
     * @return string representation of labeled letter
     */
    @Override
    public String toString() {
        return decorator() + this.letter + decorator();  // returns decorated label
    }

    // Setters
    public void setUnused() {
        label = UNUSED;
    }

    public void setUsed() {
        label = USED;
    }

    public void setCorrect() {
        label = CORRECT;
    }

    /**
     * isUnused method
     * @return true or false depending on whether label is unused
     */
    public boolean isUnused() {
        if (label == UNUSED) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * fromStrings method
     * creates an array of Letter objects
     * @param s takes in the string to transform
     * @return letterArray, array of letters
     */
    public static Letter[] fromString(String s) {
        Letter[] letterArray = new Letter[s.length()];  // creates an array of size of string parameter

        for (int i = 0; i < letterArray.length; i++) {  // loops through array
            letterArray[i] = new Letter(s.charAt(i));  // creates a letter object for each index of the string
        }
        return letterArray;
    }
}
