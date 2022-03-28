/**
 * Dance agens.
 */
public class Dance extends Agent {

    /**
     * Beállítja, hogy mennyi anyagba kerül a létrehozása
     * @param aminoac
     * @param nucleo
     */
    public Dance(int aminoac, int nucleo) {
        super(aminoac, nucleo);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @param target ezen a virológuson alkalmazza
     */
    @Override
    public void AgentEffect(Virologist target) {
        target.MoveRandomly();
    }
}
