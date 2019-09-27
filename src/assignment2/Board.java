/* EE422C Assignment #2 submission by
 * Colby Janecka
 * CDJ2326
 */

package assignment2;

import java.util.ArrayList;

class Board {

    // Board class instance variables:

    private ArrayList<Move> hist;

    // Board default constructor:
    Board () {
        hist = new ArrayList<>();
    }

    // atToHistory adds respective move m to the history of moves
    void addToHistory(Move m){

        hist.add(m);

    }

    // outputHistory prints the history of moves to the console in shorthand form
    void outputHistory(){
        for(Move move : hist){
            System.out.print(move.guess.codeAsString());
            System.out.println(" " + move.feedback.toStringShorthand());
        }
    }


}
