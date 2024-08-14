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


// src/Main.java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        // Create instances of the KeyboardInput and FileOps classes
        KeyboardInput keyboardInput = new KeyboardInput();
        FileOps fileOps = new FileOps();


        // Get keyboard input method
        String userInput = keyboardInput.getInput();
        // Get file input method
        String fileContent = fileOps.getFile();
        // Combine inputs for validation
        String combinedInput = userInput + fileContent;

        //display file content
        System.out.println("File content: " + fileContent);

        // Define regex for allowed characters (a-z, A-Z, 0-9, and punctuation)
        String allowedCharsRegex = "[^a-zA-Z0-9\\s\\p{Punct}]";


        //Compile regex pattern
        Pattern pattern = Pattern.compile(allowedCharsRegex);
        //Create matcher object
        Matcher matcher = pattern.matcher(combinedInput);



        // Strip out extraneous characters
        String cleanedInput = matcher.replaceAll("");
        // Define regex for validation
        String validationRegex = "[a-zA-Z0-9\\s\\p{Punct}]*";



        // Compile regex pattern
        pattern = Pattern.compile(validationRegex);
        // Create matcher object
        matcher = pattern.matcher(cleanedInput);


        // Display cleaned input
        System.out.println("Cleaned input: " + cleanedInput);


        // Validate input
        // Check if input matches the regex pattern
        if (matcher.matches()) {
            System.out.println("The input is valid");
        } else {
            System.out.println("The input is not valid");
        }

        //have system update file with cleaned input
        fileOps.updateFile(cleanedInput);


        // Display message to user that program has completed successfully
        System.out.println("The program has completed successfully");
    }
}