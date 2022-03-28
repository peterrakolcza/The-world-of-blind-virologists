public class Cape extends Equipment {

    @Override
    public void taken(Virologist by) {
        by.setProtection(0.823);
    }
}
