/**
 * Root ágenst reprezentálja, ami cselekvésképtelenné teszi a virológust 1 körig
 */
public class Root extends Agent {

    /**
     * Beállítja, hogy mennyi anyagba kerül a létrehozása
     * @param aminoacid
     * @param nucleotid
     */
    public Root(int aminoacid, int nucleotid) {
        super(aminoacid, nucleotid);
        // TODO Auto-generated constructor stub
    }

    /**
     * Cselekvésképtelenné teszi a virológust 1 körig
     * @param target ezen a virológuson alkalmazza
     */
    @Override
    public void AgentEffect(Virologist target) {
        target.Root();
    }
}
