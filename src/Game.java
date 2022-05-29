import java.util.Random;
import java.util.ArrayList;
public class Game {

    private static String[] playableWords = new String[] {"guessing", "these", "words", "is", "very", "easy"};
    public static int MaxIncorrectGuesses = 7;
    private static Random rand = new Random();
    private static ArrayList<String> letters = new ArrayList<String>();
    private static String word = "";
    private static String guessedWord = "";

    public static String getWord() {
        word = playableWords[rand.nextInt(playableWords.length)];
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

    public static Boolean replace(char letter) {
        boolean bool = true;
        if (word.indexOf(letter) != -1) {
            for (int i = 0; i < word.length(); i++)
                if(word.charAt(i) == letter) {
                    String s = "" + letter;
                    letters.set(i, s);
                }
            } else {
                MaxIncorrectGuesses--;
                bool = false;
            }
        return bool;
        }


    public static boolean win() {
        for(int i = 0; i < letters.size(); i++) {
            word += letters.get(i);
        }

        if(word.equals(guessedWord)) {
            return true;
        }
        return false;
    }


}
