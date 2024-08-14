//KeypboardInput.java
// class is used to get all keyboard input from the user

//Austin Stephens
//Rasmussen University
//Professor Zayas
//08/12/2024


import java.util.Scanner;

    public class KeyboardInput {
        public String getInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter some input: ");
            return scanner.nextLine();
        }
    }

}