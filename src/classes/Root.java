
public class Root extends Agent {

    public Root(int aminoacid, int nucleotid) {
        super(aminoacid, nucleotid);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void AgentEffect(Virologist target) {
        target.Root();
    }
}
