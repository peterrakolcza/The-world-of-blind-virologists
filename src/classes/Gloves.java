/**
 * védőfelszerelés amely az ágenseket 82,3%-os hatásfokkal tartja távol
 */
public class Gloves extends Equipment {
    /**
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setHasGloves(true);
    }
}
