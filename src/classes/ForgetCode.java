/**
 * Forget ágens genetikai kódja.
 */
public class ForgetCode extends GeneticCode {

    /**
     * Létrehoz egy Forget ágenst, majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki leolvasta a falról
     */
    @Override
    public void create(Virologist v) {
        final int amino = 3;
        final int nucleo = 3;
        Forget forget = new Forget(amino, nucleo);
        v.AddAgent(forget);
    }
}
