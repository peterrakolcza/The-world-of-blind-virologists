package businesslogic;

import java.util.ArrayList;

/**
 * A felszereleseket tartalmazo mezon ahonnan felveheti oket egy ilyen mezore
 * lepo virologus
 * @attribute equipment - a felszerelesek listaja
 */
public class Shelter extends Field {

    private ArrayList<Equipment> equipment = new ArrayList<Equipment>();

    public Shelter(int num)
    {
        super(num);
    }

    /**
     * Eltávólit egy felszerelést
     * @param e - a felszereles
     */
    public void RemoveEquipment(Equipment e) {
        equipment.remove(e);
    }

    /**
     * Hozzáad egy felszerelést
     * @param e - a felszereles
     */
    public void AddEquipment(Equipment e) {
        equipment.add(e);
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
        for (int i = 0; i < GetVirologists().size(); i++) {
            if (equipment.size() != 0) {
                GetVirologists().get(i).TakeEquipment(equipment.get(0), this);
            }
            break;
        }
    }




    /**
     * A felszerelesek listaja
     * @return - a felszerelesek listaja
     */
    public ArrayList<Equipment> getEquipment() {
        if (!equipment.isEmpty())
            return equipment;
        else
            return equipment;
    }
    
}
