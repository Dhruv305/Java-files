import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String randomWord = randomWord();
        // System.out.println(randomWord); // to be removed

        char[] wordArray = randomWord.toCharArray(); // String To Array

        char[] placeHolder = new char[wordArray.length];

        for (int i = 0; i < wordArray.length; i++) {
            placeHolder[i] = '_';
        }

        char[] missedGuesses = new char[6];
        int miss = 0;

        while (miss < 6) {
            System.out.println(gallows[miss]);

            System.out.print("Word : ");

            printPlaceholder(placeHolder);

            System.out.print("\nMisses : ");
            printMissedGuesses(missedGuesses);

            System.out.print("\nGuess : ");

            char guess = scan.nextLine().charAt(0);// charAt(0) takes value of string at position 0.

            if (checkGuess(wordArray, guess)) {
                updatePlaceHolder(guess, placeHolder, wordArray);
            } else {
                missedGuesses[miss] = guess;
                miss++;
            }

            if (Arrays.equals(wordArray, placeHolder)) {
                System.out.println(gallows[miss]);

                System.out.print("\nWord : ");

                printPlaceholder(placeHolder);

                System.out.println("\n Good Work!!");
                break;
            }
        }

        if (miss == 6) {
            System.out.println(gallows[miss]);
            System.out.println("RIP!!");
            System.out.println("\nWord was : '" + randomWord + "'");
        }

        scan.close();
    }

    /**
     * Function Name : randomWord
     * 
     * @return (String)
     * 
     *         Inside the function :
     *         1. Select random number
     *         2. Return String using Random number from array
     */
    public static String randomWord() {
        int number = words.length;
        double randomNumber = Math.random() * number;

        return words[(int) randomNumber];
    }

    /**
     * Function name : chechGuess
     * 
     * @param array  (char[])
     * @param guess  (char)
     * @return  (boolean)
     * 
     *         Inside the function :
     *         1. returns true if the user guessed a letter from the word correctly.
     */
    public static boolean checkGuess(char[] array, char guess) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == guess) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function name : updatePlaceHolder
     * 
     * @param guess  (char)
     * @param placeHolder  (char[])
     * @param wordArray  (char[])
     * 
     *                    Inside the function :
     *                    1.updates the placeholders when the user makes a correct
     *                    guess.
     */
    public static void updatePlaceHolder(char guess, char[] placeHolder, char[] wordArray) {
        for (int i = 0; i < placeHolder.length; i++) {
            if (guess == wordArray[i]) {
                placeHolder[i] = guess;
            }
        }
    }

    /**
     * Function name : printPlaceholder
     * 
     * @param placeHolder  (char[])
     * 
     *                            Inside the the function :
     *                            1.prints the placeholder.
     */
    public static void printPlaceholder(char[] placeHolder) {
        for (int i = 0; i < placeHolder.length; i++) {
            System.out.print(placeHolder[i] + " ");
        }
        System.out.print("\n");
    }

    /**
     * Function name : printmissedGuesses
     * 
     * @param missedGuesses  (char[])
     * 
     *                              Inside the function :
     *                              1.prints guesses that the user missed.
     */
    public static void printMissedGuesses(char[] missedGuesses) {
        for (int i = 0; i < missedGuesses.length; i++) {
            System.out.print(missedGuesses[i]);
        }
        System.out.println("");
    }

}
