/**
 * védőfelszerelés amely az ágenseket 82,3%-os hatásfokkal tartja távol
 */
public class Gloves extends Equipment {
    int lifetime;
    /**
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setHasGloves(this);
    }

    public Gloves()
    {
        super();
        this.lifetime=3;
    }

    public void reduceLifeTime() {
        lifetime--;
    }

}
