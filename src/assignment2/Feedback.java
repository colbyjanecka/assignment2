/* EE422C Assignment #2 submission by
 * Colby Janecka
 * CDJ2326
 */

package assignment2;

class Feedback {

    // Feedback class instance variables:
    private int whitePegAmount;
    private int blackPegAmount;

    //default constructor:
    Feedback() {
        whitePegAmount = 0;
        blackPegAmount = 0;
    }

    // constructor which takes in a guess and secret, then sets the white and black peg amounts for that guess.
    Feedback(Code guess, Code secret){

        whitePegAmount = 0;
        blackPegAmount = 0;
        char [] guessTemp = guess.charArray.clone();
        char [] secretTemp = secret.charArray.clone();
        char dash = '-';

        for(int i = 0; i < GameConfiguration.pegNumber; i++) {

            if (guessTemp[i] == secretTemp[i]) {
                blackPegAmount++;
                guessTemp[i] = dash;
                secretTemp[i] = dash;
            }
        }

        for(int i = 0; i < GameConfiguration.pegNumber; i++) {

            for(int j = 0; j < GameConfiguration.pegNumber; j++){

                if ((guessTemp[i] == secretTemp[j])&&(guessTemp[i]!= dash)) {
                    whitePegAmount++;
                    guessTemp[i] = dash;
                    secretTemp[j] = dash;
                }

            }

        }

    }

    // perfectGuess returns true if guessed code is identical to the secret code
    boolean perfectGuess(){
        return blackPegAmount == GameConfiguration.pegNumber;
    }

    // feedbackString method creates readable string containing amount of white and black pegs
    String feedbackString (){
        String str1, str2;

        str1 = (blackPegAmount + " black pegs. ");

        str2 = (whitePegAmount + " white pegs. ");

        String result = String.join("\n",str1, str2);
        String resText = "Result: ";
        return(resText + str1 + str2);
    }

    // toStringShorthand is used for saving a more dense version of the move history
    String toStringShorthand() {
        return (blackPegAmount + "B_" + whitePegAmount + "W");
    }

}
