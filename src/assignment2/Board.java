package assignment2;

import java.util.ArrayList;

public class Board {

    ArrayList<Move> hist;

    Board () {
        hist = new ArrayList<Move>();
    }

    void addToHistory(Move m){

        hist.add(m);

    }

    public void outputHistory(){
        for(Move move : hist){
            System.out.print(move.guess.codeAsString());
            System.out.println(" " + move.feedback.toStringShorthand());
        }
    }


}
