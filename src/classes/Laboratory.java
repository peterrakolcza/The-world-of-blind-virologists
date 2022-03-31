import java.util.ArrayList;
import java.util.Random;

/**
 * Speciális mező, ahol genetikai kódot tudunk leolvasni.
 * @attribute code - a laborban megtalálható kód
 */
public class Laboratory extends Field {

    private GeneticCode code;
    private int chance_of_bear=0;

    /**
     * A virológus megismeri a genetikai kódot
     */
    @Override
    public void Action() {
        super.Action();

        Map map = new Map();
        if(chance_of_bear==1)
        {
            for (int i = 0; i < virologists.size(); i++) {
                virologists.get(i).MoveRandomly();
                virologists.get(i).AddCode(code);
                Bear bear=new Bear(0,0);
                virologists.get(i).AddAgent(bear);
                System.out.println("A virologus megfertozodott a bear virussal!");
                map.checkIfGameIsOver(virologists.get(i).getKnownCodes());
            }
        }
        else {
            for (int i = 0; i < virologists.size(); i++) {
                virologists.get(i).AddCode(code);
                System.out.println("A virologushoz nem fertozodott meg bear agenssel mast tanult meg!");
                map.checkIfGameIsOver(virologists.get(i).getKnownCodes());
            }
        }

    }

    /**
     * Konstruktor
     * @param code - a laborban megtalálható kód
     */
    public Laboratory(GeneticCode code) {
        this.code = code;
        virologists = new ArrayList<Virologist>();
        neighbours = new ArrayList<Field>();
        Random r=new Random();
        int val=r.nextInt(2);
        if(val==1)
        {
            this.chance_of_bear=1;
        }

    }

}
