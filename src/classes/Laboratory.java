import java.util.ArrayList;

/**
 * Speciális mező, ahol genetikai kódot tudunk leolvasni.
 * @attribute code - a laborban megtalálható kód
 */
public class Laboratory extends Field {

    private GeneticCode code;

    /**
     * A virológus megismeri a genetikai kódot
     */
    @Override
    public void Action() {
        super.Action();

        Map map = new Map();

        for (int i = 0; i < virologists.size(); i++) {
            virologists.get(i).AddCode(code);

            map.checkIfGameIsOver(virologists.get(i).getKnownCodes());
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
    }

}
