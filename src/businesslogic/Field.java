package businesslogic;

import java.util.ArrayList;

/**
 * Reprezentálja a mezőket. A mezők összessége alkotja a térképet(map). Ezen mozognak a virológusok.
 * @attribute virologists - a mezon tartozkodo virologusok
 * @attribute neighbours - a szomszedok listaja
 */
public class Field {

    protected ArrayList<Virologist> virologists;
    protected ArrayList<Field> neighbours;

    /**
     * Konstruktor
     */
    public Field() {
        virologists = new ArrayList<Virologist>();
        neighbours = new ArrayList<Field>();
    }

    public int getAmino()
    {
        return 0;
    }

    public int getNucleotid()
    {
        return 0;
    }

    public void SetAmino()
    {

    }

    public void SetNucleo()
    {

    }

    /**
     * Hozzáad egy virologust a mezőhöz
     * @param v - virologus akit hozzáadni akarunk
     */
    public void Add(Virologist v) {
        virologists.add(v);
    }

    /**
     * Eltávolít egy virologust a mezőről
     * @param v - a virologus akit eltávolítjuk
     */
    public void Remove(Virologist v) {
        virologists.remove(v);
    }

    /**
     * Lekérdezi a mező szomszédait
     * @return a mező szomszédainak listája
     */
    public ArrayList<Field> GetNeighbours() {
        return neighbours;
    }

    /**
     * Lekérdezi a mezőn lévő virologusokat
     * @return a mezőn lévő virologusok listája
     */
    public ArrayList<Virologist> GetVirologists() {
        return virologists;
    }

    /**
     * Végrehajtja az adott mezőn lehetséges cselekedetek
     */
    public void Action() {
        // action
    }
}
