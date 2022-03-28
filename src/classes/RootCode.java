public class RootCode extends GeneticCode {

    @Override
    public void create(Virologist v) {
        final int amino = 1;
        final int nucleo = 2;
        Root root = new Root(amino, nucleo);
        v.AddAgent(root);

    }
}
