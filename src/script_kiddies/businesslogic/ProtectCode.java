/**
 * A protect ágens genetikai kódja.
 */
public class ProtectCode extends GeneticCode {

    /**
     * Létrehoz egy Protect ágenst, majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki leolvasta a falról
     */
    @Override
    public void create(Virologist v) {
        final int amino = 8;
        final int nucleo = 2;
        Protect protect = new Protect(amino, nucleo);
        v.AddAgent(protect);

    }
}
