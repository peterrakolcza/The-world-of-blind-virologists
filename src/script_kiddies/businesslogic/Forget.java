/**
 * Forget ágenst, amit ha egy virológusra kennek, akkor elfelejti az össze megtanult ágensét
 */
public class Forget extends Agent {

    /**
     *
     * @param target ezen a virológuson alkalmazza
     */
    @Override
    public void AgentEffect(Virologist target) {
        target.ClearMemories();
    }

    /**
     * Beállítja, hogy mennyi anyagba kerül a létrehozása
     * @param aminoac
     * @param nucleo
     */
    public Forget(int aminoac, int nucleo) {
        super(aminoac, nucleo);
        // TODO Auto-generated constructor stub
    }
}
