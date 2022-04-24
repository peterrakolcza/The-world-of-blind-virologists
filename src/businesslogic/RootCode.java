package businesslogic;

/**
 * A businesslogic.Root ágens genetikai kódja.
 */
public class RootCode extends GeneticCode {

    public RootCode()
    {
        super();
        this.name="RootCode";
    }

    /**
     * Létrehoz egy businesslogic.Root ágenst, majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki leolvasta a falról
     */
    @Override
    public void create(Virologist v) {
        final int amino = 3;
        final int nucleo = 2;
        if(v.useMatters(amino, nucleo)) {
            Root root = new Root();
            v.AddAgent(root);
        }
    }
}
