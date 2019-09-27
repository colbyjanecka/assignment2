/* EE422C Assignment #2 submission by
 * Colby Janecka
 * CDJ2326
 */

package assignment2;

public class Driver {

    public static void main(String[] args) {

        Game g = new Game();            // Creates new instance of a game/
        if(args.length > 0) {           // If there is an argument, it is passed to setTestMode method of Game class.
            g.setTestMode(args[0]);
        }
        if(g.isReadyToPlay()){          // Checks to see if player is ready to play, and if so starts the game.
            g.runGame();
        }

    }
}
