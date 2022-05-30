import java.util.Random;
import java.util.ArrayList;
import java.lang.*;
import java.util.Arrays;


public class Game {
    private static String[] playableWords = new String[] {"guessing", "these", "words", "is", "very", "easy"};
    public static int MaxIncorrectGuesses = 7;
    private static Random rand = new Random();
    private static String word = "";
    private static ArrayList<String> correctLetters = new ArrayList<String>();
    private static ArrayList<String> allLetters = new ArrayList<String>();
    private static String guessedWord = "";

    public static String getWord() {
        word = playableWords[rand.nextInt(playableWords.length)];
        return word;
    }

    public static void createWord(String word) {
        for(int i = 0; i < word.length(); i++) {
            correctLetters.add("_");
        }
    }

    public static String displayWord() {
        String str = "";
        for(String letter : correctLetters) {
            str += letter + " ";
        }
        return str;
    }

    public static boolean repeat(String str) {
        for(String letter : allLetters) {
            if(letter.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean replace(char letter) {
        String let = Character.toString(letter).toLowerCase();
        boolean bool = true;
        try {
            if(repeat(let)) {
                System.out.println("You already played this letter");
                return true;
            }
            allLetters.add(let);
            if (word.indexOf(let) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toString(Character.toLowerCase(word.charAt(i))).equals(let.replaceAll("\\s", ""))) {
                        guessedWord += let;
                        correctLetters.set(i, let.replaceAll("\\s", "").toLowerCase());
                    }
                }
            } else {
                MaxIncorrectGuesses--;
                bool = false;
            }
        } catch(Exception e) {
            return true;
        }
        return bool;
    }


    public static boolean win() {
        char[] arrWord = word.toCharArray();
        Arrays.sort(arrWord);
        String newWord = new String(arrWord);

        char[] arrGuessedWord = guessedWord.toCharArray();
        Arrays.sort(arrGuessedWord);
        String newGuessedWord = new String(arrGuessedWord);

        if(newWord.equals(newGuessedWord)) {
            return true;
        }
        return false;
    }
    public static void clear() {
        MaxIncorrectGuesses = 7;
        word = "";
        guessedWord = "";
        correctLetters.clear();
    }
}
