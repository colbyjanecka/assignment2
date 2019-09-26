package assignment2;

public class Feedback {


    int whitePegAmount;
    int blackPegAmount;

    Feedback() {
        whitePegAmount = 0;
        blackPegAmount = 0;
    }

    Feedback(Code guess, Code secret){

        whitePegAmount = 0;
        blackPegAmount = 0;
        char [] guessTemp = guess.charArray.clone();
        char [] secretTemp = secret.charArray.clone();
        char dash = new Character('-');

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

    boolean perfectGuess(){
        if(blackPegAmount == GameConfiguration.pegNumber){
            return(true);
        }
        return(false);
    }

    String feedbackString (){
        String str1, str2;

        str1 = (blackPegAmount + " black pegs. ");

        str2 = (whitePegAmount + " white pegs. ");

        String result = String.join("\n",str1, str2);
        String resText = "Result: ";
        return(resText + str1 + str2);
    }

    String toStringShorthand() {
        String result = (blackPegAmount + "B_" + whitePegAmount + "W");
        return result;
    }

}
