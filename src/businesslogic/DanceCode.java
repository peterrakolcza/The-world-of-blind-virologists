package businesslogic;

/**
 * businesslogic.Dance agens genetikai kodja.
 */
public class DanceCode extends GeneticCode {

    /**
     * Konstruktor.
     *
     */
    public DanceCode() {
    };

    /**
     * Létrehoz egy új ágenst majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki létrehozza
     */
    @Override
    public void create(Virologist v) {
        final int amino = 5;
        final int nucleo = 4;
        Dance dance = new Dance();
        v.AddAgent(dance);
    }
}
