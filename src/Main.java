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
        //our process will basically be to get input from the user and a file and then validate
        // the input and update the file with the cleaned input


        // Create instances of the KeyboardInput and FileOps classes
        KeyboardInput keyboardInput = new KeyboardInput();
        FileOps fileOps = new FileOps();

        // Get keyboard input
        String userInput = keyboardInput.getInput();
        // Get file input
        String fileContent = fileOps.getFile();
        // Combine inputs for validation
        String combinedInput = userInput + fileContent;

        // Display file content
        System.out.println("File content: " + fileContent);

        // Define regex for allowed characters (a-z, A-Z, 0-9, and punctuation)
        String allowedCharsRegex = "[^a-zA-Z0-9\\s\\p{Punct}]";
        Pattern pattern = Pattern.compile(allowedCharsRegex);
        Matcher matcher = pattern.matcher(combinedInput);

        // Strip out extraneous characters
        String cleanedInput = matcher.replaceAll("");

        // Display cleaned input
        System.out.println("Cleaned input: " + cleanedInput);

        // Define regex for validation
        String validationRegex = "[a-zA-Z0-9\\s\\p{Punct}]*";
        pattern = Pattern.compile(validationRegex);
        matcher = pattern.matcher(cleanedInput);

        // Validate input
        if (!matcher.matches()) {
            System.out.println("Invalid input detected. Cleaning input...");
            cleanedInput = cleanedInput.replaceAll(allowedCharsRegex, "");
        }

        // Update file with cleaned input
        fileOps.updateFile(cleanedInput);

        // Completed message
        System.out.println("The program has completed successfully");
    }
}