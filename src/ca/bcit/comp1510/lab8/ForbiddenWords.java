package ca.bcit.comp1510.lab8;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * States all the forbidden words for the PasswordValidator 
 * class.
 * @author Nirajan Manandhar
 * @version 1.0
 *
 */
public class ForbiddenWords {
    /**
     * Instantiates an ArrayList String object.
     */
    private ArrayList<String> forbiddenWords;
    
    /**
     * Creates a new Scanner object.
     */
    private Scanner scan;
    
    /**
     * Constructs a new ArrayList and 
     * a new Scanner that scans a text file.
     * @param filename a String.
     * @throws IOException used.
     */
    ForbiddenWords(String filename) throws IOException {
        forbiddenWords = new ArrayList<String>();
        scan = new Scanner(new File(filename));
        String str;
        while (scan.hasNext()) {
            str = scan.nextLine();
            forbiddenWords.add(str);
        }
    }
    
    /**
     * Checks if string contains
     * one of the words in the text
     * file, and returns boolean value.
     * 
     * @param input a String.
     * @return a boolean.
     */
    public boolean containsWord(String input) {
        if (forbiddenWords.contains(input)) {
            return true;
        }
        return false;
    }

}
