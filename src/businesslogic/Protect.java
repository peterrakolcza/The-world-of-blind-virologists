package businesslogic;

/**
 * businesslogic.Protect ágenst reprezentálja, ami védettséget biztosít a virológusnak.
 */
public class Protect extends Agent {


    public Protect() {
        super();
        this.aminoacid=7;
        this.nucleotid=2;
        this.name="Protect";
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
