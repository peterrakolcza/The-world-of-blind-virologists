import java.util.ArrayList;

/**
 * A felszereleseket tartalmazo mezon ahonnan felveheti oket egy ilyen mezore
 * lepo virologus
 * @attribute equipment - a felszerelesek listaja
 */
public class Shelter extends Field {

    private ArrayList<Equipment> equipment;

    /**
     * Eltávólit egy felszerelést
     * @param e - a felszereles
     */
    public void RemoveEquipment(Equipment e) {
        equipment.remove(e);
    }

    /**
     * A virolügus felveszi a felszerelést
     */
    @Override
    public void Action() {
        super.Action();
        /**
         * Ide kell majd valami check hogy vett e mar fel equipmentet ami hasonlo
         * effektet biztosit
         */
        for (int i = 0; i < virologists.size(); i++) {
            if (equipment.size() != 0) {
                virologists.get(i).TakeEquipment(equipment.get(0), this);
            }
            break;
        }
    }



    /**
     * A felszerelesek listaja
     * @return - a felszerelesek listaja
     */
    public Equipment GetEquipment() {
        if (!equipment.isEmpty())
            return equipment.get(0);
        else
            return null;
    }
}
