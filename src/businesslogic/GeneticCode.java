package businesslogic;


/**
 * Reprezentálja a genetikai kódokat
 */
public abstract class GeneticCode {
    protected String name;

    /**
     * Létrehoz egy genetikai kódot
     * @param v virologist aki leolvasta a falról
     */
    public abstract void create(Virologist v);

}
