package businesslogic;

//import com.google.gson.annotations.Expose;

import java.util.ArrayList;

/**
 * Reprezentálja a mezőket. A mezők összessége alkotja a térképet(map). Ezen mozognak a virológusok.
 * @attribute virologists - a mezon tartozkodo virologusok
 * @attribute neighbours - a szomszedok listaja
 */
public class Field {

    //@Expose
    protected String fieldID;
    protected ArrayList<Virologist> virologists;
    protected ArrayList<Field> neighbours;
    private ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    protected int PosX, posY;


    /**
     * Konstruktor
     */
    public Field(int num) {
        virologists = new ArrayList<Virologist>();
        neighbours = new ArrayList<Field>();
        equipment=new ArrayList<Equipment>();
        this.fieldID="Field"+num;
    }

    public int getAmino()
    {
        return 0;
    }

    public int getNucleotid()
    {
        return 0;
    }

    public String GetID()
    {
        return this.fieldID;
    }

    public void SetAmino()
    {

    }

    public void SetNucleo()
    {

    }

    /**
     * Eltávólit egy felszerelést
     * @param e - a felszereles
     */
    public void RemoveEquipment(Equipment e) {
        this.equipment.remove(e);
    }

    /**
     * Hozzáad egy felszerelést
     * @param e - a felszereles
     */
    public void AddEquipment(Equipment e) {

    }

    public ArrayList<Field> GetNeigh(Field f)
    {
        return neighbours;
    }

    public void SetNeigh(Field f){this.neighbours.add(f);}

    public void AddVirologist(Virologist v){this.virologists.add(v);}

    public int NeighbourCount()
    {
        return neighbours.size();
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

    public ArrayList<Equipment> GetEquipment()
    {
        return equipment;
    }


    public void setPos(int x, int y) {
        this.posY = y;
        this.PosX = x;
    }

    public int getx() {
        return PosX;
    }

    public int gety() {
        return posY;
    }
}
