import java.util.ArrayList;

public class Field {

    protected ArrayList<Virologist> virologists;
    protected ArrayList<Field> neighbours;

    public Field()
    {
        virologists=new ArrayList<Virologist>();
        neighbours=new ArrayList<Field>();
    }


    public void Add(Virologist v) {
        virologists.add(v);
    }

    public void Remove(Virologist v) {
        virologists.remove(v);
    }

    public ArrayList<Field> GetNeighbours() {
        return neighbours;
    }

    public ArrayList<Virologist> GetVirologists() {
        return virologists;
    }

    public void Action() {
        //action
    }
}
