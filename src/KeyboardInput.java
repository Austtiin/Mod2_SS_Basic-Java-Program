//KeypboardInput.java
// class is used to get all keyboard input from the user

//Austin Stephens
//Rasmussen University
//Professor Zayas
//08/12/2024

//
import java.util.Scanner;

    public class KeyboardInput {
        public String getInput() {

            //start scanner
            Scanner scanner = new Scanner(System.in);
            //ask user for input
            System.out.println("Enter some input here to test: ");
            return scanner.nextLine();
        }
    }