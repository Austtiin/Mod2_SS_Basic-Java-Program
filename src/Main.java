//main.java
//this is the main class of the project which will be executed first


//
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
        // Create instances of the KeyboardInput and FileOps classes
        KeyboardInput keyboardInput = new KeyboardInput();
        FileOps fileOps = new FileOps();

        // Get keyboard input
        String userInput = keyboardInput.getInput();
        // Get file input
        String fileContent = fileOps.getFile();
        // Combine inputs for validation
        String combinedInput = userInput + fileContent;


        //debug print to show combined input
        System.out.println("Combined Input: " + combinedInput);


        //show the user the combined input
        String disallowedCharsRegex = "[^a-zA-Z0-9\\s.,?!'\"-]";
        Pattern pattern = Pattern.compile(disallowedCharsRegex);
        Matcher matcher = pattern.matcher(combinedInput);

        //this is how we will strip out the disallowed characters
        String cleanedInput = matcher.replaceAll("");

        //cleaned input debug print
        System.out.println("Cleaned input: " + cleanedInput);


        // Validate input - only allow a-z, A-Z, 0-9, and punctuation
        if (cleanedInput.matches("[a-zA-Z0-9\\s.,?!'\"-]*")) {
            System.out.println("The input is valid");
        } else {
            System.out.println("The input is not valid");
        }

        //update file with cleaned input
        fileOps.updateFile(cleanedInput);

        //end
        System.out.println("The program has completed successfully");
    }
}
