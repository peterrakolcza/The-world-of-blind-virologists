import java.util.ArrayList;

public class Map {

    private static Map single_instance = null;
    private int numberOfRNAs = 4;
    private Field[] fields;

    public void checkIfGameIsOver(ArrayList<GeneticCode> knownCodes) {
        if (knownCodes.size() == numberOfRNAs) {
            Game game = new Game();
            game.endGame();
        }
    }
}
