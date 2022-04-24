package businesslogic;

/**
 * Felszerelest leiro ososztaly.
 */
public abstract class Equipment {

    /**
     * Hozzárendeli a felszerelest egy virologushoz.
     * @param by - virologus akié lesz a felszerelés
     */
    public void taken(Virologist by) {};

    public Equipment() {};


}
