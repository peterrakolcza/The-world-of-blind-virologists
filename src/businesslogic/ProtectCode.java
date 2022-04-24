package businesslogic;

/**
 * A protect ágens genetikai kódja.
 */
public class ProtectCode extends GeneticCode {

    /**
     * Létrehoz egy businesslogic.Protect ágenst, majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki leolvasta a falról
     */
    @Override
    public void create(Virologist v) {
        final int amino = 7;
        final int nucleo = 2;
        if(v.useMatters(amino, nucleo)) {
            Protect protect = new Protect();
            v.AddAgent(protect);
        }
    }
}
