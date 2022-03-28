
public class Forget extends Agent {

    @Override
    public void AgentEffect(Virologist target) {
        target.ClearMemories();
    }

    public Forget(int aminoac, int nucleo) {
        super(aminoac, nucleo);
        // TODO Auto-generated constructor stub
    }
}
