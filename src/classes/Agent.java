public abstract class Agent {

    protected int aminoacid, nucleotid;

    public abstract void AgentEffect(Virologist target);

    public Agent(int aminoacid,int nucleotid)
    {
        this.aminoacid = aminoacid;
        this.nucleotid = nucleotid;
    }

    public Agent() {};
}