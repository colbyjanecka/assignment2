/* EE422C Assignment #2 submission by
 * Colby Janecka
 * CDJ2326
 */

package assignment2;

class Move {

    //initializing Move class instance variables:

    Code guess;
    Feedback feedback;

    // Move constructor sets guess to blank, and creates empty feedback
    Move(){
        guess = new Code("----");
        feedback = new Feedback();
    }

}
