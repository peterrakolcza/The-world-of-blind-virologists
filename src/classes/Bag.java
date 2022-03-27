public class Bag extends Equipment {

    public void taken(Virologist by) {
        int bag_szie_increase=10;
        by.setMax(bag_szie_increase);
    }
}
