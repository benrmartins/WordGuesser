import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
public class Game {

    private static String[] playableWords = new String[] {"guessing", "these", "words", "is", "very", "easy"};
    private static int MaxIncorrectGuesses = 7;
    private static Random rand = new Random();
    private static ArrayList<String> letters = new ArrayList<String>();
    private static String word = "";
    private static String guessedWord = "";

    public static String getWord() {
        word =  playableWords[rand.nextInt(playableWords.length)];
        return word;
    }

    public static void createWord(String word) {
        for(int i = 0; i < word.length(); i++) {
            letters.add("_");
        }
    }

    public static String displayWord() {
        String str = "";
        for(String letter : letters) {
            str += letter + " ";
        }
        return str;
    }

    public static String replace(String letter) {
        if(word.indexOf(letter) != -1 && letter.length() == 1) {
            for(int i = 0; i < word.length(); i++) {
                if(Objects.equals(word.charAt(i), letter)) {
                    letters.set(i, letter);
                    return "You Guessed the correct letter!";
                }
            }
        }
        MaxIncorrectGuesses--;
        return "You Guessed A Incorrect letter!";
    }

    public static String win() {
        for(int i = 0; i < letters.size(); i++) {
            word += letters.get(i);
        }

        if(word.equals(guessedWord)) {
            return "You win!!";
        }
        return "Please guess another letter again";
    }


}
