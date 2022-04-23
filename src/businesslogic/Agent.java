package businesslogic;

/**
 * Reprezentálja a játékban található ágenseknek, ősosztálya a businesslogic.Dance, businesslogic.Forget, businesslogic.Protect és businesslogic.Root osztályoknak.
 * @attribute aminoacid - ennyi aminoacidba kerül
 * @attribute nucleotid - ennyi nucleotidba kerül
 */
public abstract class Agent {

    protected String name;
    protected int aminoacid, nucleotid;

    /**
     * Alkalkmazza az ágens hatását.
     *
     * @param target ezen a virológuson alkalmazza
     */
    public abstract void AgentEffect(Virologist target);


    public Agent()
    {

    }

    public void Contact(Virologist target)
    {
    }

}
