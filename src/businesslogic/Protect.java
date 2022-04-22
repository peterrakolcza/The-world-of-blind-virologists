package businesslogic;

/**
 * businesslogic.Protect ágenst reprezentálja, ami védettséget biztosít a virológusnak.
 */
public class Protect extends Agent {

    /**
     * Beállítja, hogy mennyi anyagba kerül a létrehozása
     * @param aminoacid
     * @param nucleotid
     */
    public Protect(int aminoacid, int nucleotid) {
        super(aminoacid, nucleotid);
        // TODO Auto-generated constructor stub
    }

    /**
     * védettséget biztosít a virológusnak
     * @param target ezen a virológuson alkalmazza
     */
    @Override
    public void AgentEffect(Virologist target) {
        target.setProtection(1);
    }
}
