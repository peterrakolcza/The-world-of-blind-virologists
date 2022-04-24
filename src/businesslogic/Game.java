package businesslogic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



/**
 * Kezeli az egész játékot. Létrehozza a szükséges elemeket, elindítja, majd ha valamelyik játékos nyert, befejezi a játékot.
 * @attribute single_instance a játék egyetlen példánya
 */
public class Game {
    private static Game single_instance = null;

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

    public void WriteJsonVirologist(ArrayList<Virologist> virologists,int testnum) throws IOException {
        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("teszt_virologist" + testnum + ".json");
        for (int i = 0; i < virologists.size(); i++) {
            //writer.write(gson.toJson(virologists.get(i)));
            System.out.println(gson.toJson(virologists.get(i)));
        }
        //System.out.println("ismert agensek"+virologists.get(1).getKnownCodes().size());
        //virologists.get(1).ClearMemories();
        //writer.write(gson.toJson(virologists.get(1)));

        writer.close();

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
    }

    public void WriteField(int testnum,Field f) throws IOException {
        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("teszt_field" + testnum + ".json");
        System.out.println(f.GetID());
        writer.write(gson.toJson(f));
        writer.close();
    }

}

