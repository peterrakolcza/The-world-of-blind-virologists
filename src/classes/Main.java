public class Main {

    public static void main(String args[])  //static method  
    {
        /**teszt1: DanceCode a virologus inventoryba*/
        double protection=0.0;
        boolean hasGloves=false;
        int aminoacid=2;
        int nucleotid=3;
        int maxamout=10;
        /**Virologist inicializalasa*/
        Virologist virologist=new Virologist(protection, hasGloves, aminoacid, nucleotid, maxamout);
        /**DanceCode es Laboratory inicializalasa*/
        DanceCode dc=new DanceCode();
        Laboratory l=new Laboratory(dc);
        /**Virologist a Laboratory mezon van*/
        l.Add(virologist);
        /**Virologist megtanulja a GeneticCodeot ami a laboratoryban talalhato*/
        l.Action();
        System.out.println("A Virologist ismert GeneticCodejainak szama:"+virologist.getKnownCodes().size());
        /**teszt2: DanceAgent a virologus inventoryba*/
        dc.create(virologist);
        System.out.println("A Virologist letrehozott Agenseinek a szama:"+virologist.getAgents().size());
        /**teszt3: Virologistok szama a mezon*/
        System.out.println("A mezon levi virologistok szama az eltavolitas elott:"+l.virologists.size());
        /**teszt4: Virologist eltavolitasa a mezorol*/
        l.Remove(virologist);
        System.out.println("A mezon levi virologistok szama az eltavolitas utan:"+l.virologists.size());
        /**teszt5: Pickup Matter a virologus inventoryba*/
        int amino=10;
        int nucleo=8;
        /**Storage mezo letrehozasa a teszteleshez*/
        Storage s=new Storage(amino,nucleo);
        /**Virologus hozzadasa*/
        s.Add(virologist);

        /**Megteszi a feladatat a fuggveny vagyis noveli x-el a virologus amini es nucleo szintjeit*/
        s.Action();
        System.out.println("A virologus aminoacid mennyisege:"+virologist.getAmino()+" nucleotid mennyisege:"+virologist.getNucleo());
        /**teszt6: Virologus mozgasa*/
        virologist.setField(s);
        Field f=new Field();
        s.neighbours.add(f);
        virologist.Move(f);
        System.out.println("Size of virologists on new field: "+f.GetVirologists().size());

    }  

}
