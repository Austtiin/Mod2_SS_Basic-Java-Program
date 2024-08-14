//FileOps.java
//class to handle all file operations

//Austin Stephens
//Rasmussen University
//Professor Zayas
//08/12/2024


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileOps {


    public String getFile() {
        //start scanner
        Scanner scanner = new Scanner(System.in);

        //ask user for file name
        System.out.println("Please enter the name of the file: ");
        String fileName = scanner.nextLine();

        //read file
        StringBuilder fileContent = new StringBuilder();
//

        //try to read file - this is where we will use try/catch
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //if file is not empty, read file
            while ((line = br.readLine()) != null) {
                //append file content to string builder
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            //error out if file is not found
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        //return file content / string builder as string to main
        return fileContent.toString();
    }

    public void updateFile(String cleanedInput) {
        //start scanner
        Scanner scanner = new Scanner(System.in);

        //ask user for file name
        System.out.println("Please enter the name of the file you would like to update: ");
        String fileName = scanner.nextLine();

        //try to write to file - this is where we will use try/catch
        try {
            //write to file
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
            fileWriter.write(cleanedInput);
            fileWriter.close();
            System.out.println("File updated successfully!");
        } catch (IOException e) {
            //error out if file is not found
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}