import java.util.ArrayList;

public class Main {

    public static void main(String args[]) // static method
    {
        /** teszt1: DanceCode a virologus inventoryba */
        double protection = 0.0;
        Gloves glove=new Gloves();
        int aminoacid = 2;
        int nucleotid = 3;
        int maxamout = 10;
        /** Virologist inicializalasa */
        Virologist virologist = new Virologist(protection, glove, aminoacid, nucleotid, maxamout);
        /** DanceCode es Laboratory inicializalasa */
        DanceCode dc = new DanceCode();
        Laboratory l = new Laboratory(dc);
        /** Virologist a Laboratory mezon van */
        l.Add(virologist);
        /** Virologist megtanulja a GeneticCodeot ami a laboratoryban talalhato */
        l.Action();
        System.out.println("A Virologist ismert GeneticCodejainak szama:" + virologist.getKnownCodes().size());
        /** teszt2: DanceAgent a virologus inventoryba */
        dc.create(virologist);
        System.out.println("TESZT2:___A Virologist letrehozott Agenseinek a szama:" + virologist.getAgents().size());
        /** teszt3: Virologistok szama a mezon */
        System.out.println("TESZT3:___A mezon levi virologistok szama az eltavolitas elott:" + l.virologists.size());
        /** teszt4: Virologist eltavolitasa a mezorol */
        l.Remove(virologist);
        System.out.println("TESZT4:___A mezon levi virologistok szama az eltavolitas utan:" + l.virologists.size());
        /** teszt5: Pickup Matter a virologus inventoryba */
        int amino = 10;
        int nucleo = 8;
        /** Storage mezo letrehozasa a teszteleshez */
        Storage s = new Storage(amino, nucleo);
        /** Virologus hozzadasa */
        s.Add(virologist);

        /**
         * Megteszi a feladatat a fuggveny vagyis noveli x-el a virologus amini es
         * nucleo szintjeit
         */
        s.Action();
        System.out.println("TESZT5:___A virologus aminoacid mennyisege:" + virologist.getAmino() + " nucleotid mennyisege:"
                + virologist.getNucleo());
        /** teszt6: Virologus mozgasa */
        virologist.setField(s);
        Field f = new Field();
        s.neighbours.add(f);
        virologist.Move(f);
        System.out.println("TESZT6:___Size of virologists on new field: " + f.GetVirologists().size());
        /**Teszt7: Bear Code mukodese*/
        BearCode bc=new BearCode();
        Laboratory inf=new Laboratory(bc);
        glove.lifetime=0;
        Virologist v2=new Virologist(protection,glove,10,10,15);
        inf.Add(v2);
        inf.Action();
        /**Teszt8: Bear agenssel fertoz a virologus*/
        /**Itt lehet allitani, hogy a celpontnak van e gloveja*/

        Virologist v3=new Virologist(protection,glove,10,10,15);
        inf.Add(v3);
        /**Megvizsgalom hogy a fertozott virologus milyen agenseket ismer*/
        ArrayList<Agent> agents=v2.getAgents();

        Bear b=new Bear(0,0);
        /**Letrehozok egy dummy peldanyt es ezzel megnezem hogy van e ennek a classnak megfelelo peldany az ismert agensei kozott a fertozottnek*/
        for(int i=0;i< agents.size();i++)
        {
            /**Van bear agense az inventoryban es ugyan azon a mezon is van a ket virologus*/
            if(agents.get(i).getClass().equals(b.getClass()) && inf.GetVirologists().contains(v2)&& inf.GetVirologists().contains(v3))
            {
                /**A Bear osztalyban van qa fuggveny*/
                v2.GetSpecificAgent(i).Contact(v3);
                System.out.println("TESZT7___A virologus uj agenseinek a merete ha vedett akkor '0' lesz kiirva ha nem akkor '1': "+v3.getAgents().size());
            }
        }

    }

}
