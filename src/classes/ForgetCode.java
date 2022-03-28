public class ForgetCode extends GeneticCode {

    @Override
    public void create(Virologist v) {
        final int amino = 3;
        final int nucleo = 3;
        Forget forget = new Forget(amino, nucleo);
        v.AddAgent(forget);
    }
}
