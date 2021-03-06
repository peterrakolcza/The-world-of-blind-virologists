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
        super();
        this.name="DanceCode";
    };

    /**
     * Létrehoz egy új ágenst majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki létrehozza
     */
    @Override
    public void create(Virologist v) {
        final int amino = 4;
        final int nucleo = 5;
        if(v.useMatters(amino, nucleo)) {
            Dance dance = new Dance();
            v.AddAgent(dance);
        }
    }
}
