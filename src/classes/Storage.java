import java.util.ArrayList;

public class Storage extends Field{

    private int aminoacid, nucleotid;

    @Override
    public void Action() {
        super.Action();

        for (int i = 0; i < virologists.size(); i++) {
            virologists.get(i).pickUp(aminoacid,nucleotid);
        }
        //actionje
    }

    public Storage(int aminoacid,int nucleotid)
    {
        this.aminoacid=aminoacid;
        this.nucleotid=nucleotid;
        virologists=new ArrayList<Virologist>();
        neighbours=new ArrayList<Field>();
    }
}
