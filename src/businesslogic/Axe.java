package businesslogic;

/**
 * védőfelszerelés amellyel megölhető a medve
 */
public class Axe extends Equipment{
    private boolean used;
    /**
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setHasActiveAx(true);
    }

    public Axe(String name) {
        super();
        this.used = false;
        this.name = name;
    }
}
