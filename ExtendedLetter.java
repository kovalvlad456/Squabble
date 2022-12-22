/**
 * ExtendedLetter
 * @author Vlad Koval
 * CS1027
 */
public class ExtendedLetter extends Letter{
    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;

    /**
     * ExtendedLetter Constrcutor
     * @param s string
     */
    public ExtendedLetter(String s) {
        super('c');  // call letter constructor
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }

    /**
     * Overloaded ExtendedLetter Constrcutor
     * @param s string
     * @param fam integer
     */
    public ExtendedLetter(String s, int fam) {
        super('c');
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    /**
     * Equals method
     * @param other object to be compared to ExtendedLetter
     * @return true or false depending on whether other is an instance of the ExtendedLetter class
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof ExtendedLetter) {
            ExtendedLetter otherExtendedLetterObject = (ExtendedLetter)other; // cast other object to ExtendedLetter

            if (this.family == otherExtendedLetterObject.family) {
                this.related = true;
            } else {
                return false;
            }
            
            if (this.content.equals(otherExtendedLetterObject.content)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * toString method
     * @return string representation of the extended letter object
     */
    @Override
    public String toString() {
        if ((this.isUnused()) && (this.related == true)) {  // if label is unused and related is true
            return "." + this.content + ".";  // returns extended letter object

        }
        return decorator() + this.content + decorator();  // returns labeled letter
    }

    /**
     * fromStrings method that creates an array of Letter objects
     * @param content string array
     * @param codes int array
     * @return array of Letter objects
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {  
        Letter[] letters = new Letter[content.length];  // creates array of size of the content array

        if (codes == null) {  // if codes array is null
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);  // creates ExtendedLetter objects initialized with content parameter
            }
        } else if (codes != null) {  // if codes array is not null
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);  // creates ExtendedLetter objects initialized with the content parameter and codes parameter
            }
        }
        return letters;  // returns letter array
    }
}
