import java.util.ArrayList;

/**
 * Mező ahol a virológus anyaghoz tud jutni
 * @attribute aminoacid - a tárolt aminoacidok mennyisége
 * @attribute nucleotid - a tárolt nucleotidok mennyisége
 */
public class Storage extends Field {

    private int aminoacid, nucleotid;

    /**
     * A virológus felveszi a tárolt anyagot.
     */
    @Override
    public void Action() {
        super.Action();

        for (int i = 0; i < virologists.size(); i++) {
            virologists.get(i).pickUp(aminoacid, nucleotid);
        }
        // actionje
    }

    /**
     * Konstruktor
     * @param aminoacid - a tárolt aminoacidok mennyisége
     * @param nucleotid - a tárolt nucleotidok mennyisége
     */
    public Storage(int aminoacid, int nucleotid) {
        this.aminoacid = aminoacid;
        this.nucleotid = nucleotid;
        virologists = new ArrayList<Virologist>();
        neighbours = new ArrayList<Field>();
    }

    public int getAmino()
    {
        return aminoacid;
    }

    public int getNucleotid()
    {
        return nucleotid;
    }

    public void SetAmino()
    {
        this.aminoacid=0;
    }

    public void SetNucleo()
    {
        this.nucleotid=0;
    }
}
