package businesslogic;


/**
 * Reprezentálja a genetikai kódokat
 */
public abstract class GeneticCode {

    /**
     * Létrehoz egy genetikai kódot
     * @param v virologist aki leolvasta a falról
     */


    protected String name;
    public abstract void create(Virologist v);

}
