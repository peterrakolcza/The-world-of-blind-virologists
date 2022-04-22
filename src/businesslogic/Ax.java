package businesslogic;

/**
 * védőfelszerelés amellyel megölhető a medve
 */
public class Ax extends Equipment{
    private boolean used;
    /**
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setHasActiveAx(true);
    }

    public Ax() {
        super();
        this.used = false;
    }
}
