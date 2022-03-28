public class DanceCode extends GeneticCode {

    public DanceCode() {
    };

    @Override
    public void create(Virologist v) {
        final int amino = 5;
        final int nucleo = 4;
        Dance dance = new Dance(amino, nucleo);
        v.AddAgent(dance);

    }
}
