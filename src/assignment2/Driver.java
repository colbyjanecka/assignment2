package assignment2;

public class Driver {

    public static void main(String[] args) {

        Game g = new Game();
        if(args.length > 0) {
            g.setTestMode(args[0]);
        }
        if(g.isReadyToPlay()){
            g.runGame();
        }


    }
}
