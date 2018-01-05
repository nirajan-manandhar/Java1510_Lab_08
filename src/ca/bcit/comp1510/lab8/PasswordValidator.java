package ca.bcit.comp1510.lab8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * PasswordValidator Takes user's password and validates it.
 * 
 * @author Nirajan Manandhar
 * @version 1.0
 */
public class PasswordValidator extends Application {
    
    /**
     * Holds the TextField with the first password.
     */
    private TextField password;
    
    /**
     * Holds the TextField witht the second password.
     */
    private TextField password2;
    
    /**
     * Holds the result for the result.
     */
    private Label result;
    
    /**
     * Instantiates ForbiddenWords object.
     */
    private ForbiddenWords wordList;

    /**
     * Start method.
     * @param primaryStage a stage
     * @throws Exception unused
     */
    public void start(Stage primaryStage) throws Exception {
 
        final int appWidth = 230;
        final int appHeight = 100;
        final int width = 120;
        
        wordList = new ForbiddenWords("src/ca/bcit/comp1510/lab8/wordlist.txt");
        
        GridPane grid = new GridPane();

        Label inputLabel = new Label("Enter Password: ");
        GridPane.setHalignment(inputLabel, HPos.LEFT);

        Label inputLabel2 = new Label("Confirm Password: ");
        GridPane.setHalignment(inputLabel2, HPos.LEFT);

        password = new TextField();
        password.setPrefWidth(width);

        password2 = new TextField();
        password2.setPrefWidth(width);

        result = new Label("---");
        GridPane.setHalignment(result, HPos.CENTER);

        Button submit = new Button("Submit");
        GridPane.setHalignment(submit, HPos.CENTER);
        submit.setOnAction(this::validatePassword);

        grid.add(inputLabel, 0, 0);
        grid.add(password, 1, 0);
        grid.add(inputLabel2, 0, 1);
        grid.add(password2, 1, 1);
        grid.add(submit, 0, 2);
        grid.add(result, 1, 2);
        
        Scene scene = new Scene(grid, appWidth, appHeight);
        primaryStage.setTitle("Password Validator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Event handler for the submit button.
     * 
     * @param event
     *            invokes this method
     */
    public void validatePassword(ActionEvent event) {
     
        String first = password.getText();
        String second = password2.getText();
        
        if (!first.equals(second) 
                || !upperCaseTest(first) 
                || !lowerCaseTest(first) 
                || wordList.containsWord(first)
                || !digitTest(first) 
                || !passwordLength(first) 
                || !specialCharTest(first)) {
            result.setText("INVALID");
            
            if (wordList.containsWord(first)) {
                System.out.println("Forbidden Word!");
            }
            
            if (!first.equals(second)) {
                System.out.println("The passwords do not match.");
            }
            
            if (!upperCaseTest(first)) {
                System.out.println("You need at least one Upper Case letter!");
            }
            
            if (!lowerCaseTest(first)) {
                System.out.println("You need at least one Lower Case letter!");
            }
            
            if (!digitTest(first)) {
                System.out.println("You need at least one number!");
            }
            
            if (!passwordLength(first)) {
                System.out.println("Between 8 and 10 characters.");
            }
            
            if (!specialCharTest(first)) {
                System.out.println("Missing a special character.");
            }
            
        } else {
            result.setText("VALID");
        }
        
    }
    
    /**
     * Tests if a String contains an upper case letter.
     * @param input a String.
     * @return a boolean.
     */
    private boolean upperCaseTest(String input) {
        boolean hasUpperCase;
        String testPassword = input.toLowerCase();
        if (!input.equals(testPassword)) {
            hasUpperCase = true;
        } else {
            hasUpperCase = false;
        }
        return hasUpperCase;        
    }
    
    /**
     * Tests if a String contains a lower-case letter.
     * @param input a String.
     * @return a boolean.
     */
    private boolean lowerCaseTest(String input) {
        boolean hasLowerCase;
        String testPassword = input.toUpperCase();
        if (!input.equals(testPassword)) {
            hasLowerCase = true;
        } else {
            hasLowerCase = false;
        }
        return hasLowerCase;        
    }    
    
    /**
     * Test if a String has a number in it.
     * @param input a String.
     * @return a boolean.
     */
    private boolean digitTest(String input) {
        
        int passwordLength = input.length();
        int index = 0;
        int digitCount = 0;
        boolean hasDigit = false;
        
        for (int count = 1; count <= passwordLength; count++) {
           
            char testChar = input.charAt(index);
            index++; 
            if (Character.isDigit(testChar)) {
                digitCount++;
            }
        }
        
        if (digitCount > 0) {
            hasDigit = true;
        }
        return hasDigit;
    }
    
    /**
     * Checks if a String has length between 8 and 10
     * characters, inclusive.
     * @param input a String.
     * @return a boolean.
     */
    private boolean passwordLength(String input) {
        int passwordLength = input.length();
        final int min = 8;
        final int max = 10;
        boolean hasLength = false;
        if (passwordLength >= min && passwordLength <= max) {
            hasLength = true;
        }
        return hasLength; 
    }
    
    /**
     * Tests if String has a Special Character.
     * @param input String.
     * @return a boolean.
     */
    private boolean specialCharTest(String input) {
        
        int passwordLength = input.length();
        int index = 0;
        int digitCount = 0;
        boolean hasChar = true;
        
        for (int count = 1; count <= passwordLength; count++) {
           
            char testChar = input.charAt(index);
            index++; 
            if (testChar == '#' || testChar == '!' || testChar == '?' 
                    || testChar == '"' || testChar == '$' 
                    || testChar == '(' || testChar == ')' 
                    || testChar == '\'' || testChar == '%') {
                digitCount++;
            }
        }
        
        if (digitCount == 0) {
            hasChar = false;
        }  
        return hasChar;
    }

    /**
     * Runs the program.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
