package businesslogic;

/**
 * védőfelszerelés amely az ágenseket 82,3%-os hatásfokkal tartja távol
 */
public class Cape extends Equipment {

    public Cape(String name) {
        super();
        this.name = name;
    }

    /**
     * Hozzárendeli egy virologushoz
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setProtection(0.823);
    }
}
