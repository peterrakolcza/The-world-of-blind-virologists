public class BearCode extends GeneticCode
{
    public BearCode() {
    };

    /**
     * Létrehoz egy új ágenst majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki létrehozza
     */
    @Override
    public void create(Virologist v) {
        final int amino = 0;
        final int nucleo = 0;
        Bear bear = new Bear(amino, nucleo);
        v.AddAgent(bear);
    }
}
