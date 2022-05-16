package businesslogic;

import gui.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Kezeli az egész játékot. Létrehozza a szükséges elemeket, elindítja, majd ha
 * valamelyik játékos nyert, befejezi a játékot.
 * 
 * @attribute single_instance a játék egyetlen példánya
 */
public class Game {
    private static Game single_instance = null;

    /** Az equipmenteket tartalmazza ezek mennek majd panelnek adatnak */
    private ArrayList<Equipment> equipments;
    /** A mezőket tartalmazza ezek mennek majd panelnek adatnak */
    private ArrayList<Field> fields;

    private ArrayList<Shelter> shelters;

    private ArrayList<Laboratory> labs;

    private ArrayList<Storage> storages;

    private Map map;

    private boolean gameIsOn = false;

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Laboratory> getLabs() {
        return labs;
    }

    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    public ArrayList<Storage> getStorages() {
        return storages;
    }

    public ArrayList<Virologist> getVirologists() {
        return virologists;
    }

    public Virologist getActiveVirologist() {
        return activeVirologist;
    }

    /** Avirologistokat tartalmazza ezek mennek majd panelnek adatnak */
    private ArrayList<Virologist> virologists;

    private Virologist activeVirologist;
    /** Az aktiv virologus sorszama a virologusok listaban */
    private int activeVirologistNumber;

    public Game() {
        gameIsOn = true;
        map = new Map();
        map.setGame(this);
        view = new View(this);
        equipments = new ArrayList<Equipment>();
        fields = new ArrayList<Field>();
        shelters = new ArrayList<Shelter>();
        labs = new ArrayList<Laboratory>();
        storages = new ArrayList<Storage>();
        virologists = new ArrayList<Virologist>();
    }

    public void initGame() {
        equipments = new ArrayList<Equipment>();
        fields = new ArrayList<Field>();
        shelters = new ArrayList<Shelter>();
        labs = new ArrayList<Laboratory>();
        storages = new ArrayList<Storage>();
        virologists = new ArrayList<Virologist>();

        Random rand = new Random();
        Gloves glove = new Gloves("gloves");
        glove.SetEffectTime(0);

        /** Sima fieldek generalasa */
        for (int i = 0; i < 4; i++) {
            Field f = new Field(i);
            fields.add(f);
            System.out.println("Fn" + fields.get(i).GetID());
        }

        // for(int i=0;i<rand.nextInt(1,5);i++) {
        for (int i = 0; i < 5; i++) {
            Virologist v = new Virologist(0, glove, 10, 10, 50, i);
            int fieldnum = rand.nextInt(3);
            for (int j = 0; j < fields.size(); j++) {
                if (fields.get(j).fieldID == String.valueOf(fieldnum)) {
                    v.setField(fields.get(j));
                }
            }
            virologists.add(v);
        }

        /** Aktiv virolous beallitasa */
        activeVirologist = virologists.get(0);
        activeVirologistNumber = 0;

        /** Equipmentek létrehozása a shelterekhez */
        Cape cape = new Cape("cape");
        Bag bg = new Bag("bag");
        Axe ax = new Axe("axe");
        Gloves gl = new Gloves("gloves");

        /** Shelter mezok letrehozasa */
        for (int i = 4; i < 8; i++) {
            Shelter sh = new Shelter(i);
            shelters.add(sh);
            switch (i) {
                case 4:
                    sh.AddEquipment(cape);
                    break;

                case 5:
                    sh.AddEquipment(bg);
                    break;

                case 6:
                    sh.AddEquipment(ax);
                    break;

                case 7:
                    sh.AddEquipment(gl);
                    break;
            }

        }
        System.out.println("Az equipmentek:" + shelters.get(3).GetEquipment().name);

        for (int i = 8; i < 11; i++) {
            /*
             * int num= rand.nextInt(10,20);
             * int num2= rand.nextInt(10,20);
             */
            int num = 15;
            int num2 = 15;
            Storage st = new Storage(num, num2, i);
            storages.add(st);
        }
        System.out.println("A Storage ertekek:" + storages.get(2).getAmino() + storages.get(0).getNucleotid());

        DanceCode dc = new DanceCode();
        ProtectCode pc = new ProtectCode();
        RootCode rc = new RootCode();

        Laboratory lab = new Laboratory(dc, 12);
        Laboratory lab2 = new Laboratory(pc, 13);
        Laboratory lab3 = new Laboratory(rc, 14);
        labs.add(lab);
        labs.add(lab2);
        labs.add(lab3);

        /** Szomszédos mezők beállítása */

        /** Field0 szomszedjai */
        fields.get(0).neighbours.add(fields.get(1));
        fields.get(0).neighbours.add(shelters.get(1));
        /** Shelter5 szomszedjai */
        shelters.get(1).neighbours.add(fields.get(0));
        shelters.get(1).neighbours.add(fields.get(1));
        shelters.get(1).neighbours.add(storages.get(1));
        shelters.get(1).neighbours.add(labs.get(2));

        /** Field2 szomszedjai */
        fields.get(1).neighbours.add(shelters.get(0));
        fields.get(1).neighbours.add(storages.get(2));

        /** Storage10 szomszédjai */
        storages.get(2).neighbours.add(fields.get(1));
        storages.get(2).neighbours.add(shelters.get(3));
        storages.get(2).neighbours.add(labs.get(2));
        storages.get(2).neighbours.add(fields.get(2));

        /** Shelter7 szomszedjai */
        shelters.get(3).neighbours.add(storages.get(2));
        shelters.get(3).neighbours.add(labs.get(1));

        /** Lab13 szomszédjai */
        labs.get(1).neighbours.add(shelters.get(3));
        labs.get(1).neighbours.add(shelters.get(0));

        /** Shelter4 szomszédjai */
        shelters.get(0).neighbours.add(labs.get(1));

        /** Storage9 szomszédjai */
        storages.get(1).neighbours.add(storages.get(0));
        storages.get(1).neighbours.add(shelters.get(1));

        /** Storage 8 szomszédjai */
        storages.get(0).neighbours.add(storages.get(1));
        storages.get(0).neighbours.add(labs.get(2));

        /** Lab14 szomszédjai */
        labs.get(2).neighbours.add(storages.get(0));
        labs.get(2).neighbours.add(shelters.get(1));
        labs.get(2).neighbours.add(fields.get(3));
        labs.get(2).neighbours.add(storages.get(2));

        /** Field13 szomszédjai */
        fields.get(3).neighbours.add(labs.get(2));
        fields.get(3).neighbours.add(fields.get(2));

        /** Field3 szomszédjai */
        fields.get(2).neighbours.add(fields.get(3));
        fields.get(2).neighbours.add(storages.get(2));
        fields.get(2).neighbours.add(shelters.get(2));
        fields.get(2).neighbours.add(labs.get(1));

        /** Shelter6 szomszédjai */
        shelters.get(2).neighbours.add(fields.get(2));
        shelters.get(2).neighbours.add(labs.get(0));

        /** Lab12 szomszédjai */
        labs.get(0).neighbours.add(shelters.get(2));
        labs.get(1).neighbours.add(labs.get(1));

        fields.get(2).neighbours.add(shelters.get(0));
        fields.get(2).neighbours.add(storages.get(0));
        storages.get(1).neighbours.add(fields.get(2));

        fields.get(3).neighbours.add(shelters.get(1));
    }

    /**
     * A kirajzolasert felelos peldany
     */
    private static View view;

    /**
     * Elindítja a játékot.
     */
    public void startGame() {
        // jatek kezdes
        initGame();
    }

    /**
     * Befejezi a játékot.
     */
    public void endGame() {
        // jatek vege
        gameIsOn = false;
    }

    public void nextVirologist() {
        if (activeVirologistNumber < virologists.size() - 1) {
            activeVirologistNumber++;
        } else {
            activeVirologistNumber = 0;
        }
        activeVirologist = virologists.get(activeVirologistNumber);
    }

    /**
     * Belépési pont
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        view.setVisible(true);
    }
}
