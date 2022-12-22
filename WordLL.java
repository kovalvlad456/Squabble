/**
 * WordLL
 * @author Vlad Koval
 * CS1027
 */
public class WordLL {
    private Word mysteryWord; // creating a word object
    private LinearNode<Word> history;

    /**
     * WordLL Constructor
     * @param mystery mystery word
     */
    public WordLL(Word mystery) {
        history = null;
        this.mysteryWord = mystery;
    }

    /**
     * try word method, checks whether word is correct or not
     * @param guess
     * @return true or false depending on whether guess matches mystery word
     */
    public boolean tryWord(Word guess) {
        LinearNode<Word> userGuess = new LinearNode<Word>(guess);  // initializes node to guess parameter
        boolean correctGuess = guess.labelWord(mysteryWord);  // labels the guess according to the mystery word

        userGuess.setNext(history);  // puts guess at the front of the list
        history = userGuess;  // sets current to the guess
        return correctGuess;  // returns true if word is correct, false is not
    }

    /**
     * toString method
     * @return string representation of history of guesses
     */
    public String toString() {
        LinearNode<Word> current = history;  // initializes node to history
        String printHistory = "";  // creates string to store histoy

        while (current != null) {
            printHistory += current.getElement().toString() + "\n";  // adds guesses stored in history to string
            current = current.getNext();  // get next node
        }
        return printHistory;  // return guesses
    }
    
}
