package businesslogic;

/**
 * businesslogic.Dance agens.
 */
public class Dance extends Agent {



    public Dance() {
        super();
        this.aminoacid=4;
        this.nucleotid=5;
        this.name="Dance";
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
