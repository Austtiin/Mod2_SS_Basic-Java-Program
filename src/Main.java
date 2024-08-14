//main.java
//this is the main class of the project which will be executed first



//Austin Stephens
//Rasmussen University
//Professor Zayas
//08/12/2024



//Instructions

//
//
//We will make our classes and methods to handle the different tasks for this week's project

//Create a Java program that can:
//take a file as input, using appropriate error handling (try/catch)
//take keyboard input
//perform some type of data validation, for example
//allows only a-z, A-Z, 0-9, and punctuation
//strips out extraneous characters
//display a message to the user
//
//We will create a couple of classes
//FileOps - handle all file operations
//KeyboardInput - hanlde all keyboard input
//main - the main class of the project everything else



import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        KeyboardInput keyboardInput = new KeyboardInput();
        FileOps fileOps = new FileOps();

        // Get keyboard input
        String userInput = keyboardInput.getInput();

        // Get file input
        String fileContent = fileOps.getFile();

        // Combine inputs for validation
        String combinedInput = userInput + fileContent;

        // Define regex for validation
        String regex = "[a-zA-Z0-9\\s\\p{Punct}]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(combinedInput);

        // Validate input
        if (matcher.matches()) {
            System.out.println("The input is valid");
        } else {
            System.out.println("The input is not valid");
        }

        System.out.println("The program has completed successfully");
    }
}