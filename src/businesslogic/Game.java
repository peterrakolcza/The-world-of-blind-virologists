package businesslogic;


import gui.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Kezeli az egész játékot. Létrehozza a szükséges elemeket, elindítja, majd ha valamelyik játékos nyert, befejezi a játékot.
 * @attribute single_instance a játék egyetlen példánya
 */
public class Game {
    private static Game single_instance = null;

    /**Az equipmenteket tartalmazza ezek mennek majd panelnek adatnak*/
    private ArrayList<Equipment> equipments;
    /**A mezőket tartalmazza ezek mennek majd panelnek adatnak*/
    private ArrayList<Field> fields;

    private ArrayList<Shelter> shelters;

    private ArrayList<Laboratory> labs;

    private ArrayList<Storage> storages;

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

    /**Avirologistokat tartalmazza ezek mennek majd panelnek adatnak*/
    private ArrayList<Virologist> virologists;

    public Game() {
        view = new View(this);
        equipments=new ArrayList<Equipment>();
        fields=new ArrayList<Field>();
        shelters=new ArrayList<Shelter>();
        labs=new ArrayList<Laboratory>();
        storages=new ArrayList<Storage>();
        virologists=new ArrayList<Virologist>();
        Field f=new Field(1);
        Field f2=new Field(2);

        fields.add(f);
        f.SetNeigh(f2);
        fields.add(f2);

        /*initGame();


        }*/


        //Init();
    }

    public void initGame()
    {

        equipments=new ArrayList<Equipment>();
        fields=new ArrayList<Field>();
        shelters=new ArrayList<Shelter>();
        labs=new ArrayList<Laboratory>();
        storages=new ArrayList<Storage>();
        virologists=new ArrayList<Virologist>();

        Random rand=new Random();
        Gloves glove=new Gloves("gloves");
        glove.SetEffectTime(0);

        /**Sima fieldek generalasa*/
        for(int i=0;i<4;i++)
        {
            Field f=new Field(i);
            fields.add(f);
            System.out.println("Fn"+fields.get(i).GetID());
        }

        fields.get(0).neighbours.add(fields.get(1));



        for(int i=0;i<rand.nextInt(1,5);i++) {
            Virologist v = new Virologist(0, glove, 10, 10, 50, i);
            int fieldnum = rand.nextInt(3);
            for (int j = 0; j < fields.size(); j++) {
                if (fields.get(j).fieldID == String.valueOf(fieldnum)) {
                    v.setField(fields.get(j));
                }

            }
            virologists.add(v);
        }

        /**Equipmentek létrehozása a shelterekhez*/
        Cape cape=new Cape("cape");
        Bag bg=new Bag("bag");
        Axe ax=new Axe("axe");
        Gloves gl=new Gloves("gloves");

        /**Shelter mezok letrehozasa*/
        for(int i=4;i<8;i++)
        {
            Shelter sh=new Shelter(i);
            shelters.add(sh);
            switch (i)
            {
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
        System.out.println("Az equipmentek:"+shelters.get(3).GetEquipment().name);

        for(int i=8;i<11;i++)
        {
            int num= rand.nextInt(10,20);
            int num2= rand.nextInt(10,20);
            Storage st=new Storage(num,num2,i);
            storages.add(st);

        }
        System.out.println("A Storage ertekek:"+storages.get(2).getAmino()+storages.get(0).getNucleotid());

        DanceCode dc=new DanceCode();
        ProtectCode pc=new ProtectCode();
        RootCode rc=new RootCode();

        Laboratory lab=new Laboratory(dc,12);
        Laboratory lab2=new Laboratory(pc,13);
        Laboratory lab3=new Laboratory(rc,14);
        labs.add(lab);
        labs.add(lab2);
        labs.add(lab3);

        lab2.neighbours.add(fields.get(1));
        lab2.neighbours.add(shelters.get(2));

        lab.neighbours.add(fields.get(0));
        lab.neighbours.add(storages.get(2));
        lab.neighbours.add(labs.get(1));

        lab3.neighbours.add(lab2);




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
    }

    /**
     * Befejezi a játékot.
     */
    public void endGame() {
        // jatek vege
    }



    /*public void WriteJsonVirologist(ArrayList<Virologist> virologists, int testnum) throws IOException {
        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting();
        Gson gson = builder.create();
        // FileWriter writer = new FileWriter("teszt_virologist" + testnum + ".json");
        for (int i = 0; i < virologists.size(); i++) {
            //writer.write(gson.toJson(virologists.get(i)));
            System.out.println(gson.toJson(virologists.get(i)));
        }
        //System.out.println("ismert agensek"+virologists.get(1).getKnownCodes().size());
        //virologists.get(1).ClearMemories();
        //writer.write(gson.toJson(virologists.get(1)));

        // writer.close();
    }

    public void WriteFieldToJson(ArrayList<Virologist> virologists,int testnum,Field f) throws IOException {
        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting()
                ;
        Gson gson = builder.create();
        System.out.println("Field:"+f.GetID());
        FileWriter writer = new FileWriter("teszt_field" + testnum + ".json");
        writer.write(gson.toJson(virologists.get(0)));
        writer.close();
    }*/

    /**
     * Belépési pont
     */
    public static void main(String[] args) {
        Game game = new Game();
        view.setVisible(true);
    }

}

