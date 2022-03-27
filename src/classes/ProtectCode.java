public class ProtectCode extends GeneticCode {

    @Override
    public void create(Virologist v) {
        final int amino = 8;
        final int nucleo = 2;
        Protect protect = new Protect(amino, nucleo);
        v.AddAgent(protect);
        
    }
}
