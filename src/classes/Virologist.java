import java.util.ArrayList;
import java.util.Random;

public class Virologist {

    /** A vedettseget hatasfokat jelzo double ertek */
    private double protection = 0;

    private boolean hasGloves = false, randommoves = false, rooted = false;

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

    /** Parameteres konstruktora a virologusnak */
    public Virologist(double protection, boolean hasGloves, int aminoacid, int nucleotid, int maxamout) {
        this.protection = protection;
        this.hasGloves = hasGloves;
        this.aminoacid = aminoacid;
        this.nucleotid = nucleotid;
        this.maxAmount = maxamout;
        randommoves = false;
        rooted = false;
        agents = new ArrayList<Agent>();
        equipment = new ArrayList<Equipment>();
        knownCodes = new ArrayList<GeneticCode>();

    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public void setField(Field f) {
        this.onField = f;
    }

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
        this.maxAmount = val;
    }

    public void setHasGloves(boolean input) {
        this.hasGloves = input;
    }

    public boolean isProtected(int randomNumber) {
        return randomNumber < protection;
    }

    public boolean HasGloves() {
        return hasGloves;
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
        Random r = new Random();
        if (onField.GetVirologists().contains(v) && (this.agents.contains(a) && !v.HasGloves() && v.isProtected(r.nextInt(101)))) {
            a.AgentEffect(v);
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

    public void MoveRandomly() {
        this.randommoves = true;
    }

    public void Move(Field next) {
        /**
         * Ellenorzese annak hogy a virologus tud e mozogni a parameterkent megkapott
         * mezore
         */
        if (!rooted && onField.neighbours.contains(next)) {
            System.out.println("Nem rootolt es szomszedos a mozgasra kijelolt mezo!");
            this.onField.virologists.remove(this);
            this.onField = next;
            next.virologists.add(this);
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
        this.equipment.remove(e);
    }

    /** Virologus felveszi az equipmentet a shelter mezorol */
    public void TakeEquipment(Equipment e, Shelter from) {
        this.equipment.add(from.GetEquipment());
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
}
