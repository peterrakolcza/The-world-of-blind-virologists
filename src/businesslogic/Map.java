package businesslogic;

import java.util.ArrayList;

/**
 * Ez a játékterület, itt mozognak a virológusok. Mezőkből áll. A térkép tartja számon a nyeréshez szükséges RNA-k számát.
 * @attribute single_instance - egyetlen példányt tárolja
 * @attribute numberOfRNAs - a térképen lévő RNA-k száma
 * @attribute fields - a térképen lévő mezők
 */
public class Map {

    private static Map single_instance = null;
    private int numberOfRNAs = 4;
    private ArrayList<Field> fields;
    private Game onGoingGame;


    public void setGame(Game g) {
        onGoingGame = g;
    }
    /**
     * Megnézi, hogy van-e olyan virológus aki összegyűjtötte-e az összes RNA-t, és ezáltal megnyerte a játékot
     * @param knownCodes
     */
    public void checkIfGameIsOver(ArrayList<GeneticCode> knownCodes) {
        if (knownCodes.size() == numberOfRNAs) {
           
            onGoingGame.endGame();
        }
    }
}
