package businesslogic;

/**
 * businesslogic.Root ágenst reprezentálja, ami cselekvésképtelenné teszi a virológust 1 körig
 */
public class Root extends Agent {


    public Root() {
        super();
        this.name="Root";
        this.aminoacid=3;
        this.nucleotid=2;
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
