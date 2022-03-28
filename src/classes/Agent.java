/**
 * Reprezentálja a játékban található ágenseknek, ősosztálya a Dance, Forget, Protect és Root osztályoknak.
 * @attribute aminoacid - ennyi aminoacidba kerül
 * @attribute nucleotid - ennyi nucleotidba kerül
 */
public abstract class Agent {

    protected int aminoacid, nucleotid;

    /**
     * Alkalkmazza az ágens hatását.
     *
     * @param target ezen a virológuson alkalmazza
     */
    public abstract void AgentEffect(Virologist target);

    /**
     * A konstruktor.
     *
     * @param aminoacid
     * @param nucleotid
     */
    public Agent(int aminoacid,int nucleotid)
    {
        this.aminoacid = aminoacid;
        this.nucleotid = nucleotid;
    }

    public Agent() {};
}
