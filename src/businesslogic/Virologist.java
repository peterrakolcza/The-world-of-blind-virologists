package businesslogic;

//import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Ez az osztály reprezentálja a virológusokat (játékosokat) a játékban.
 * A virológus mozog a pálya mezőin, feladata, hogy elsőként megtanulja az összes ágenstípushoz tartozó
 * genetikai kódokat, vándorlása során lehetősége van anyagot gyűjteni, amiből ágenseket készíthet a
 * kódok alapján. Az ágenseket magukra vagy másokra kenhetik védelem, illetve támadás céljából.
 * Bizonyos mezőkön védőfelszerelést vehet magához, amiknek különböző hatásuk van. Ha le van bénulva a virológus,
 * más játékos megfoszthatja őt az anyaggyűjteményétől, illetve felszerelésétől.
 */
public class Virologist {

    
    private String activeVirologist;

    private int id;
    
    
    /** A vedettseget hatasfokat jelzo double ertek */
    private double protection = 0;


    private boolean  randommoves = false, rooted = false;


    private Gloves glove;

    private boolean bear;
    private boolean hasActiveAx = false;

    /** A virologus anyag fajtai es a megengedheto maximum ertekuk */

    private int aminoacid, nucleotid, maxAmount;

    /** A virologus ismert genetika kodjat tartalmazo lista */

    private ArrayList<GeneticCode> knownCodes;
    /** A virologus altal letrehozott agenseket tartalmazo lista */

    private ArrayList<Agent> agents;
    /** Melyik mezon talalhato a virologus jelenleg */

    private Field onField;
    /** A virologus felszereleseit tartalmazo lista */

    private ArrayList<Equipment> equipment;

    /**Jeloli, hogy o van-e soron vagy sem */
    private boolean theirTurn;

    /** Parameteres konstruktora a virologusnak */
    public Virologist(double protection, Gloves glove, int aminoacid, int nucleotid, int maxamout,int id) {

        this.activeVirologist="Virologist"+id;
        this.id = id;
        this.protection = protection;
        this.glove = glove;
        this.aminoacid = aminoacid;
        this.nucleotid = nucleotid;
        this.maxAmount = maxamout;
        randommoves = false;
        rooted = false;
        agents = new ArrayList<Agent>();
        equipment = new ArrayList<Equipment>();
        knownCodes = new ArrayList<GeneticCode>();
        hasActiveAx = false;
        this.onField=null;
        theirTurn = false;
        //equipment.add(glove);
        bear = false;
    }

    public void setTurn(boolean value) {
        theirTurn = value;
    }

    public boolean getTurn() {
        return theirTurn;
    }

    public boolean GetRooted()
    {
        return rooted;
    }

    public String equipmentNames() {
        String equipmentName = "";
        if (equipment.size()==0)
            equipmentName = "none";
        for (int i = 0; i < equipment.size(); i++) {
            String temp = equipment.get(i).getName();
            equipmentName = equipmentName + ", " + temp;
        }

        return equipmentName;
    }

    public boolean isBear() {
        return bear;
    }

    public boolean getAxe() {
        return hasActiveAx;
    }

    public String getName()
    {
        return activeVirologist;
    }

    public int getid(){
        return id;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public boolean IsRandomMove(){return randommoves;}

    public Agent GetSpecificAgent(int i)
    {
        return this.agents.get(i);
    }

    public void setField(Field f) {
        this.onField = f;
    }

    public Field getField(){return this.onField;}

    public int getAmino() {
        return aminoacid;
    }

    public int getNucleo() {
        return nucleotid;
    }

    public int maxMatter() {
        return maxAmount;
    }

    public void setMax(int val) {
        this.maxAmount += val;
    }

    public void setHasGloves(Gloves input) {
        this.glove = input;
    }
    public void setHasActiveAx(boolean val) {
        this.hasActiveAx = val;
    }

    /**
     * Itt azt változtattam, hogy ha a védettség nagyobb mint 82% vagy van glove-ja, amelyiknek a lifetimeja nem 0.
     * */
    public boolean isProtected() {
        return 0.823 < protection || this.glove.EffectTime > 0;
    }

    public boolean HasGloves() {
        if(glove.EffectTime>0)
        {
            return true;
        }
        return false;
    }

    public ArrayList<GeneticCode> getKnownCodes() {
        return knownCodes;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public Virologist() {
    };

    public void UseAgent(Agent a, Virologist v) {
        if (onField.GetVirologists().contains(v) && (this.agents.contains(a) && !v.HasGloves() && v.isProtected()==false)) {
            a.AgentEffect(v);
        }
        else if(v.HasGloves() == true)
        {
            glove.reduceLifeTime();
            a.AgentEffect(this);
            System.out.println("Csokkent eggyel a kesztyu lifetime-ja!");
        }
    }

    /**
     * A Virologus letrehozott agenteit tartalmazo listahoz hozzadodik a
     * parameterkent kapott agent
     */
    public void AddAgent(Agent a) {
        agents.add(a);
    }

    /** A virologus cselekveskeptelen lesz */
    public void Root() {
        this.rooted = true;
    }

    /** A virologus veletlendszeruen fog mozogni */
    public void MoveRandomly() {
        this.randommoves = true;
    }

    /** A virologus mozog a mezok kozott marad */
    public void Move(Field next) {
        /**
         * Ellenorzese annak hogy a virologus tud e mozogni a parameterkent megkapott
         * mezore
         */

        System.out.println("A virologus root tulajdonsaga: "+this.rooted);
        int i=0;
        while(i!=this.onField.neighbours.size())
        {
            System.out.println("A virologus mezojenek szomszedjai: "+this.onField.neighbours.get(i).GetID());
            i++;
        }
        if (!rooted && onField.GetNeigh(this.getField()).contains(next)) {
            this.onField.GetVirologists().remove(this);
            this.onField = next;
            next.GetVirologists().add(this);
        }

    }

    /** A Virologus eddig ismert genetic codejait elfelejti */
    public void ClearMemories() {
        this.knownCodes.clear();
    }

    /** Virologus Euipmentjeihez hozzadodik egy equipment */
    public void AddEquipment(Equipment e) {
        this.equipment.add(e);
    }

    /** Virologustol el lesz veve egy equipment az inventoryabol */
    public void RemoveEquipment(Equipment e) {
        this.onField.GetEquipment().remove(e);
    }

    /** Virologus felveszi az equipmentet a shelter mezorol */
    public void TakeEquipment(Equipment e, Field from) {
        this.equipment.add(from.GetEquipment().get(0));
        from.RemoveEquipment(e);
        e.taken(this);
    }

    /** Virologus ellop egy equipmentet a masiktol */
    public void TakeEquipmentFromVirologist(Equipment e, Virologist from) {
        this.equipment.add(e);
        from.RemoveEquipment(e);
        e.taken(this);
    }

    /** A virologist megtanulja a genetic codeot */
    public void AddCode(GeneticCode c) {
        this.knownCodes.add(c);
    }

    public void learn(Laboratory l) {
        // this.knownCodes.add(l.getCode());
        // folytatni kell checkifgameisover stb
    }

    /** Ha van eleg matter-je a virologusnak, akkor letre tudja hozni az agenst */
    public boolean useMatters(int a, int n) {
        if (aminoacid > a && nucleotid > n) {
            aminoacid -= a;
            nucleotid -= n;

            for (int i = 0; i < 3; i++) {

            }
            // agentet kell krealni, illetve hozzaadni az agents tombhoz
            return true;
        } else
            return false;
    }

    /**
     * A virologist felveszi a storage mezorol az ott levo amino es nucleotidokat es
     * hozzadodik a jelenlegi anyagjaihoz
     */
    public void pickUp(int aminoacid, int nucleotid) {
        /** Ellenorzese annak hogy ne legyen tobb a amino vagy nucleo mint a max */
        if (this.aminoacid < maxAmount) {
            this.aminoacid += aminoacid;
            if (maxAmount < this.aminoacid) {
                this.aminoacid = maxAmount;
            }
        }

        if (this.nucleotid < maxAmount) {
            this.nucleotid += nucleotid;
            if (maxAmount < this.nucleotid) {
                this.nucleotid = maxAmount;
            }
        }

    }

    public ArrayList<Equipment> getEquipment()
    {
        return this.equipment;
    }

    public void printStatus() {
        System.out.println("Virologus: " + activeVirologist );
        System.out.println("hol: " + this.getField().GetID() );
    }


}
