package businesslogic;

public class Bear extends Agent{

    public Bear()
    {
        super();
        this.aminoacid=0;
        this.nucleotid=0;
        this.name="Bear";

    }

    public void AgentEffect(Virologist target)
    {
        if(target.getField().getAmino()>0 && target.getField().getNucleotid()>0) {
            target.getField().SetAmino();
            target.getField().SetNucleo();
            System.out.println("Amino a mezon bear eseten:"+target.getField().getAmino());
        }
    }

    public void Contact(Virologist target)
    {
        System.out.println("A celpont kesztulye:"+target.HasGloves());
        if(target.HasGloves()==false && target.isProtected()==false)
        {
            target.AddAgent(this);
            target.MoveRandomly();
            System.out.println("Megfertozodott a virologus a medve cuccal:");
        }
    }
}
