/* EE422C Assignment #2 submission by
 * Colby Janecka
 * CDJ2326
 */

package assignment2;

import java.util.Scanner;

class Game {

    // Defining instance variable:

    private boolean testMode = false;
    private Code secretCode = new Code();
    private Scanner input = new Scanner(System.in);
    private int remainingGuesses;
    private String [] colors = GameConfiguration.colors;
    private Board board;
    private boolean winner;

    // Default Game constructor
    Game(){
        welcomeMessage();
    }

    // runGame method handles resetting values and getting new secret code for each time the user plays
    void runGame(){

        winner = false;
        remainingGuesses = GameConfiguration.guessNumber;
        System.out.println("\nGenerating secret code ... ");
        secretCode.getRandomCode();
        board  = new Board();

        if(testMode){
            System.out.print("Secret Code: " + secretCode.codeAsString() + "\n");   // outputs secret code in testMode
        }

        while(remainingGuesses!=0){
            iterateTurn();
        }

        if(winner) {
            System.out.println("You win !! \n");
        } else {
            System.out.println("Sorry, you are out of guesses. You loose. \n");

        }

        String answer;
        System.out.print("Are you ready for another game? (Y/N) : ");
        answer = input.nextLine().toLowerCase();

        while(!answer.equals("y") && !answer.equals("n")) {

            System.out.println("Invalid Input. \n");
            System.out.print("Are you ready for another game? (Y/N) : ");
            answer = input.nextLine().toLowerCase();
        }

        if (answer.equals("y")) {
            this.runGame();
        }

    }

    // iterateTurn takes in a guess, calculates peg feedback, saves move history, and outputs results
    private void iterateTurn(){

        printRemainingGuesses();
        Move currentMove = new Move();
        currentMove.guess = getNewGuess();

        // Calculate pegs, output results, decrement remaining guesses:

        currentMove.feedback = new Feedback(currentMove.guess, secretCode);

        board.addToHistory(currentMove);

        System.out.println("\n" + currentMove.guess.codeAsString() + " --> " + currentMove.feedback.feedbackString() + "\n");

        if(currentMove.feedback.perfectGuess()){
            remainingGuesses = 0;
            winner = true;
        } else {
            remainingGuesses -= 1;          // Decrement remaining guesses
        }


    }

    // getNewGuess takes in an input and validates it as a legal guess or request to see history
    private Code getNewGuess(){

        System.out.print("What is your next guess? \nType in the characters for your guess and press enter: \n" +
                "Enter guess: ");
        String s = input.nextLine();

        if (s.toLowerCase().equals("history")) {
            board.outputHistory();

        } else if(!isValidGuess(s)){
            System.out.print(s + " -> INVALID GUESS\n\n");
            return(getNewGuess());
        } else {
            return (new Code(s));
        }
        return(getNewGuess());

    }

    // isValidGuess is a helper function that checks the validity of a given guess
    private boolean isValidGuess(String s){
        int pegNumber = GameConfiguration.pegNumber;
        if(s.length() != pegNumber){
            return(false);
        }
        char [] chars = s.toCharArray();
        for(char ch : chars){
            if(!isCharInStrArray(colors,ch)){
                return(false);
            }
        }
        return(true);
    }

    // isCharInStrArray scans a given array of strings to find any instance of char c within
    private boolean isCharInStrArray(String[] s, char ch){
        boolean result = false;
        for(String str : s){
            if(str.contains(String.valueOf(ch))){
                result = true;
                break;
            }
        }
        return(result);
    }

    // setTestMode takes in an argument, and sets the test mode of the game.
    void setTestMode(String s){
        if(Integer.parseInt(s) == 1){
            testMode = true;
        }
    }

    // printRemainingGuesses outputs the amount of guesses the user has left to the console
    private void printRemainingGuesses(){
        System.out.println("\nYou have " + remainingGuesses + " guesses lefts.");
    }

    // welcomeMessage displays the initial game instructions when the program starts.
    private void welcomeMessage() {

        System.out.println("Welcome to Mastermind.  Here are the rules.\n" +
                "\n" +
                "This is a text version of the classic board game Mastermind.\n" +
                "\n" +
                "The computer will think of a secret code.  The code consists of 4\n" +
                "colored pegs.  The pegs MUST be one of six colors: blue, green,\n" +
                "orange, purple, red, or yellow.  A color may appear more than once in\n" +
                "the code.  You try to guess what colored pegs are in the code and\n" +
                "what order they are in.  After you make a valid guess the result\n" +
                "(feedback) will be displayed.\n" +
                "\n" +
                "The result consists of a black peg for each peg you have guessed\n" +
                "exactly correct (color and position) in your guess.  For each peg in\n" +
                "the guess that is the correct color, but is out of position, you get\n" +
                "a white peg.  For each peg, which is fully incorrect, you get no\n" +
                "feedback.\n" +
                "\n" +
                "Only the first letter of the color is displayed.  B for Blue, R for\n" +
                "Red, and so forth.  When entering guesses you only need to enter the\n" +
                "first character of each color as a capital letter.\n");

    }

    // isReadyToPlay asks the user if he is ready to play and returns boolean value with the answer
    boolean isReadyToPlay(){
        System.out.print("You have 12 guesses to figure out the secret code or you lose the\n" +
                "game.  Are you ready to play? (Y/N) : ");
        String in = input.nextLine();
        if (in.toLowerCase().equals("y")){
            return(true);
        } else if(in.toLowerCase().equals("n")) {
            return(false);
        }
        System.out.println("Invalid Input. ");
        return(isReadyToPlay());
    }


}
