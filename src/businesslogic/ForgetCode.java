package businesslogic;

/**
 * businesslogic.Forget ágens genetikai kódja.
 */
public class ForgetCode extends GeneticCode {

    public ForgetCode()
    {
        super();
        this.name="ForgetCode";
    }

    /**
     * Létrehoz egy businesslogic.Forget ágenst, majd hozzaadja a virologushoz aki letrehozta.
     * @param v virologist aki leolvasta a falról
     */
    @Override
    public void create(Virologist v) {
        final int amino = 3;
        final int nucleo = 6;
        if(v.useMatters(amino, nucleo)) {
            Forget forget = new Forget();
            v.AddAgent(forget);
        }
    }
}
