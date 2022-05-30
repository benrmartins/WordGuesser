import javax.xml.transform.stream.StreamSource;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO THE WORD GUESSER GAME - CLI EDITION\n\n");
        Game.createWord(Game.getWord());

        while (true) {
            System.out.println("\nMAIN MENU\n");
            System.out.println("1) Play game");
            System.out.println("2) Exit program");
            int userChoice = input.nextInt();
            if (userChoice == 1) {
                start();
                Game.clear();
                Game.createWord(Game.getWord());
                Game.displayWord();
            } else if (userChoice == 2) {
                break;
            } else {
                System.out.println("ERROR: invalid user selection detected in Main.menu() ");
            }
        }

        System.out.println("\n\n\nTHANK YOU FOR USING THIS PROGRAM...");
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        while(bool) {
            System.out.println("");
            System.out.println("");
            System.out.println("You have " + Game.MaxIncorrectGuesses + " wrong guesses left");
            System.out.println(Game.displayWord());
            System.out.println("Please guess a letter");
            char letter = scan.next(".").charAt(0);
            if(Game.replace(letter)) {
                System.out.println("You guessed the correct letter");
            } else {
                System.out.println("There is no " + letter + " in that word");
            }
            if(Game.win()) {
                Game.win();
                System.out.println("");
                System.out.println(Game.displayWord());
                System.out.println("You win!!!");
                bool = false;
                break;
            }
            if(Game.MaxIncorrectGuesses == 0) {
                bool = false;
            }
        }

    }
}