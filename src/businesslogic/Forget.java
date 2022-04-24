package businesslogic;

/**
 * businesslogic.Forget ágenst, amit ha egy virológusra kennek, akkor elfelejti az össze megtanult ágensét
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


    public Forget() {
        super();
        this.aminoacid=3;
        this.nucleotid=6;
        this.name="Forget";
    }
}
