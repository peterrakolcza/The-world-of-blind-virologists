/**
 * Védőfelszerelés ami megnöveli a virológus anyaggyűjtő képességét a kétszeresére
 */
public class Bag extends Equipment {

    /**
     * Hozzárendeli egy virologushoz
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        int bag_szie_increase = 10;
        by.setMax(bag_szie_increase);
    }
}
