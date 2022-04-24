package businesslogic;

import tests.Sequences;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) // static method
    {

        Game g=new Game();
        Scanner sc=new Scanner(System.in);

        int sel=-2;

        Sequences s=new Sequences();

        System.out.println("Valasz egy tesztesetet:");
        System.out.println("1. xy eset:");
        System.out.println("2. Valasz egy tesztesetet:");
        System.out.println("3. Valasz egy tesztesetet:");
        System.out.println("4. TestCreatingAgentUnknownCode:");
        System.out.println("5. TestCreatingAgentNotEnoughMaterial:");
        System.out.println("6. TestCreatingAgentSuccessfully:");
        System.out.println("7. TestRootAgentUse:");
        System.out.println("8. UseProtectAgent:");
        System.out.println("9. TestAgentWhileProtected:");
        System.out.println("10. TestDanceAgent:");
        System.out.println("11. TestForgetAgent:");
        System.out.println("-1. Kilepes...");

        do{
            sel=sc.nextInt();

            System.out.println("Valasz egy tesztesetet:");
            System.out.println("1. xy eset:");
            System.out.println("2. Valasz egy tesztesetet:");
            System.out.println("3. Valasz egy tesztesetet:");
            System.out.println("4. TestCreatingAgentUnknownCode:");
            System.out.println("5. TestCreatingAgentNotEnoughMaterial:");
            System.out.println("6. TestCreatingAgentSuccessfully:");
            System.out.println("7. TestRootAgentUse:");
            System.out.println("8. UseProtectAgent:");
            System.out.println("9. TestAgentWhileProtected:");
            System.out.println("10. TestDanceAgent:");
            System.out.println("11. TestForgetAgent:");
            System.out.println("-1. Kilepes...");

            switch (sel)
            {

                case 0:
                    //Ide teszt
                    break;
                case 1:
                    //Ide teszt
                    break;
                case 2:
                    //Ide teszt
                    break;
                case 3:
                    //Ide teszt
                    break;
                case 4:
                    s.TestCreatingAgentUnknownCode();
                    break;
                case 5:
                    s.TestCreatingAgentNotEnoughMaterial();
                    break;
                case 6:
                    s.TestCreatingAgentSuccessfully();
                    break;
                case 7:
                    s.TestRootAgentUse();
                    break;
                case 8:
                    s.UseProtectAgent();
                    break;
                case 9:
                    s.TestAgentWhileProtected();
                    break;
                case 10:
                    s.TestDanceAgent();
                    break;
                case 11:
                    s.TestForgetAgent();
                    break;
            }

        }while (sel!=-1);






        /** teszt1: businesslogic.DanceCode a virologus inventoryba */
        double protection = 0.0;
        Gloves glove=new Gloves();
        int aminoacid = 2;
        int nucleotid = 3;
        int maxamout = 10;
        /** businesslogic.Virologist inicializalasa */
        //Virologist virologist = new Virologist(protection, glove, aminoacid, nucleotid, maxamout);
        /** businesslogic.DanceCode es businesslogic.Laboratory inicializalasa */
        //DanceCode dc = new DanceCode();
        //Laboratory l = new Laboratory(dc,3);
        /** businesslogic.Virologist a businesslogic.Laboratory mezon van */
        //l.Add(virologist);
        /** businesslogic.Virologist megtanulja a GeneticCodeot ami a laboratoryban talalhato */
        //l.Action();
        //System.out.println("A businesslogic.Virologist ismert GeneticCodejainak szama:" + virologist.getKnownCodes().size());
        /** teszt2: DanceAgent a virologus inventoryba */
        //dc.create(virologist);
        //System.out.println("TESZT2:___A businesslogic.Virologist letrehozott Agenseinek a szama:" + virologist.getAgents().size());
        /** teszt3: Virologistok szama a mezon */
        //System.out.println("TESZT3:___A mezon levi virologistok szama az eltavolitas elott:" + l.virologists.size());
        /** teszt4: businesslogic.Virologist eltavolitasa a mezorol */
        //l.Remove(virologist);
        //System.out.println("TESZT4:___A mezon levi virologistok szama az eltavolitas utan:" + l.virologists.size());
        /** teszt5: Pickup Matter a virologus inventoryba */
        int amino = 10;
        int nucleo = 8;
        /** businesslogic.Storage mezo letrehozasa a teszteleshez */
        //Storage s = new Storage(amino, nucleo,5);
        /** Virologus hozzadasa */
        //s.Add(virologist);

        /**
         * Megteszi a feladatat a fuggveny vagyis noveli x-el a virologus amini es
         * nucleo szintjeit
         */
        //s.Action();
        //System.out.println("TESZT5:___A virologus aminoacid mennyisege:" + virologist.getAmino() + " nucleotid mennyisege:"
        //      + virologist.getNucleo());
        /** teszt6: Virologus mozgasa */
        //virologist.setField(s);
        //Field f = new Field(1);
        //s.neighbours.add(f);
        //virologist.Move(f);
        //System.out.println("TESZT6:___Size of virologists on new field: " + f.GetVirologists().size());
        /**Teszt7: businesslogic.Bear Code mukodese*/
        //BearCode bc=new BearCode();
        //Laboratory inf=new Laboratory(bc,2);
        glove.EffectTime=0;
        //Virologist v2=new Virologist(protection,glove,10,10,15);
        //inf.Add(v2);
        //inf.Action();
        /**Teszt8: businesslogic.Bear agenssel fertoz a virologus*/
        /**Itt lehet allitani, hogy a celpontnak van e gloveja*/

        //Virologist v3=new Virologist(protection,glove,10,10,15);
        //inf.Add(v3);
        /**Megvizsgalom hogy a fertozott virologus milyen agenseket ismer*/
        //ArrayList<Agent> agents=v2.getAgents();

        //Bear b=new Bear(0,0);
        /**Letrehozok egy dummy peldanyt es ezzel megnezem hogy van e ennek a classnak megfelelo peldany az ismert agensei kozott a fertozottnek*/
        //for(int i=0;i< agents.size();i++)
        //{
            /**Van bear agense az inventoryban es ugyan azon a mezon is van a ket virologus*/
        // if(agents.get(i).getClass().equals(b.getClass()) && inf.GetVirologists().contains(v2)&& inf.GetVirologists().contains(v3))
        // {
        //      /**A businesslogic.Bear osztalyban van qa fuggveny*/
        //      v2.GetSpecificAgent(i).Contact(v3);
        //      System.out.println("TESZT7___A virologus uj agenseinek a merete ha vedett akkor '0' lesz kiirva ha nem akkor '1': "+v3.getAgents().size());
        //   }
        }

    }

