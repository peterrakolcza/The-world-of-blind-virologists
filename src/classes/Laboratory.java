import java.util.ArrayList;

public class Laboratory extends Field{

    private GeneticCode code;

    @Override
    public void Action() {
        super.Action();
        for (int i = 0; i < virologists.size(); i++) {
            virologists.get(i).AddCode(code);
        }
        
    }

    public Laboratory(GeneticCode code){
        this.code=code;
        virologists=new ArrayList<Virologist>();
        neighbours=new ArrayList<Field>();
    }


}
