/**
 * Word
 * generates a word for the progrsm
 * @author Vlad Koval
 * CS1027
 */
public class Word {
    private LinearNode<Letter> firstLetter;

    /**
     * Word Constructor, builds linked list for array of letters
     * @param letters
     */
    public Word(Letter[] letters) {
        LinearNode<Letter> current = null;  // creates current node
        LinearNode<Letter> prev = null;  // creates previous node

        current = new LinearNode<Letter>(letters[0]);  // sets head node to the first letter in letter array
        this.firstLetter = current;  // sets firstLetter to the head node
        prev = current;  //  initialize previous node to current value

        for (int i = 1; i < letters.length; i++) {  // loop through letters array starting from 2nd node
            current = new LinearNode<Letter>(letters[i]);  // creates a new node for the ith element
            prev.setNext(current);  // sets current node to previous nodes next
            prev = current;  // links previous node to current node
        }
    }

    /**
     * toString method
     * @return string representation of linked list
     */
    public String toString() {
        String printLetters = "";  // creates string to store nodes
        LinearNode<Letter> current = firstLetter;  // intiliaze linked list

		while (current != null) {
            printLetters += current.getElement().toString() + " ";  // adds node to the string
            current = current.getNext();
		}
        return "Word: " + printLetters;  // return formatted string
    }

    /**
     * helper method to check if a letter is in a word
     * @param checkLetter letters to be checked whether it is in a linked list
     * @return true or false depending on if the checkLetter is in the linked list
     */
    private boolean contains(LinearNode<Letter> checkLetter) {
        LinearNode<Letter> current = firstLetter;  // intiliaze linked list
        boolean contains = false;  // variable to store whether element is contained in the list
        while (current != null) {
            if (current.getElement().equals(checkLetter.getElement())) {  // comapres current node to parameter
                contains = true;  // sets contains to true if element is in the list
            }
            current = current.getNext(); 
        }
        return contains;
    }

    /**
     * label word method, labels a word with respect to the mystery word
     * @param mystery mystery word
     * @return correctWord, true if word is correct, false if not
     */
    public boolean labelWord(Word mystery) {
        LinearNode<Letter> guessCurr = this.firstLetter;  // initializes node for this objects firstLetter
        LinearNode<Letter> mysteryCurr = mystery.firstLetter;  // initializes node for Word objects firstLetter
        boolean correctWord = true;  // variable to check whether word is correct
        boolean over = false;  // variable that checks whether label word is done executing
        boolean reset = false; // variable that check if mystery word has been reset to first letter

        while (over == false) {
            if (guessCurr == null || mysteryCurr == null) {  // if one of the nodes are null
                if (guessCurr == null && mysteryCurr == null) {  // if both nodes are null, meaning there are no more letter to check
                    over = true;  // sets over to true, so loop stops and word is no longer checked
                    break;
                } else if (guessCurr == null && mysteryCurr != null) { // mystery word is longer than guess
                    correctWord = false;  // word is not correct
                    over = true;  
                    // ends loop
                    break;
                } else if (guessCurr != null && mysteryCurr == null) { // guess is longer than mystery word
                    correctWord = false;  // word is not correct
                    mysteryCurr = mystery.firstLetter; // sets node back to the first letter so that remaining letters of guess can be checked if they are contained in the mystery word
                    reset = true;  // sets reset to true to prevent mismatching correct letters
                }
            }
            
            if (guessCurr.getElement().equals(mysteryCurr.getElement()) && reset == false) {  // only checks if elements are equal if the mystery word has not been reset to its first letter
                guessCurr.getElement().setCorrect();  // sets element of this class to correct
            } else if (mystery.contains(guessCurr) == true) {  // if guessed letter is in the mystery word
                guessCurr.getElement().setUsed();  // sets element of this class to used
                correctWord = false;  // word is incorrect because not all elements are correct
            } else if (mystery.contains(guessCurr) == false) {  // if guessed letter is not in the mystery word
                guessCurr.getElement().setUnused();  // sets element of this class to unused
                correctWord = false;  // word is incorrect because not all elements are correct
            }

            // gets next nodes for both nodes
            guessCurr = guessCurr.getNext();
            mysteryCurr = mysteryCurr.getNext();
        }
        return correctWord; // returns the correct word
    }
}