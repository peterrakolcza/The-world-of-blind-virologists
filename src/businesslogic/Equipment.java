package businesslogic;

/**
 * Felszerelest leiro ososztaly.
 */
public abstract class Equipment {

    protected String name;

    /**
     * Hozzárendeli a felszerelest egy virologushoz.
     * @param by - virologus akié lesz a felszerelés
     */
    public void taken(Virologist by) {};

    public String getName() {
        return name;
    }

    public Equipment() {};
}
