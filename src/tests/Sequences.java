package tests;

import businesslogic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Sequences {
    private Game game = new Game();
    private ArrayList<Virologist> virologists = new ArrayList<Virologist>();

    /**
     * Nem vedett Virologuson root agent hasznalata
     */
    public void TestRootAgentUse() {
        int num = 7;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        RootCode rc = new RootCode();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 1);
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        v.AddCode(rc);
        rc.create(v);
        virologists.add(v);
        virologists.add(v2);
        for (int i = 0; i < v.getAgents().size(); i++) {
            if (v.getAgents().get(i) instanceof Root) {
                v.getAgents().get(i).AgentEffect(v2);
                try {
                    game.WriteJsonVirologist(virologists, num);
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            }

        }
        virologists.clear();
    }

    /**
     * Leteszteli a Protect ágenst
     */
    public void UseProtectAgent() {
        int num = 8;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        ProtectCode pc = new ProtectCode();
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        pc.create(v2);
        v2.AddCode(pc);
        virologists.add(v2);
        for (int i = 0; i < virologists.size(); i++) {
            if (v2.getAgents().get(i) instanceof Protect) {
                v2.getAgents().get(i).AgentEffect(v2);
                break;
            }
        }
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Leteszteli, hogy lehet-e ágenst használni valakin, amíg protected
     */
    public void TestAgentWhileProtected() {
        int num = 9;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        ProtectCode pc = new ProtectCode();
        RootCode rc = new RootCode();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 1);
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        pc.create(v2);
        rc.create(v);
        v.AddCode(rc);
        v2.AddCode(pc);
        virologists.add(v);
        virologists.add(v2);
        for (int i = 0; i < v.getAgents().size(); i++) {
            if (v.getAgents().get(i) instanceof Forget && (v2.isProtected() || v2.HasGloves())) {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            } else if (v.getAgents().get(i) instanceof Dance && (v2.isProtected() || v2.HasGloves())) {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            } else if (v.getAgents().get(i) instanceof Root && (v2.isProtected() || v2.HasGloves())) {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }

        }

        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Leteszteli a Dance ágenst
     */
    public void TestDanceAgent() {
        int num = 10;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        Virologist v = new Virologist(0, glove, 10, 15, 40, 1);
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        DanceCode dc = new DanceCode();
        v.AddCode(dc);
        dc.create(v);
        virologists.add(v);
        virologists.add(v2);
        Field f = new Field(0);
        Field f2 = new Field(3);
        Shelter s = new Shelter(4);
        v2.setField(f);
        f.SetNeigh(f2);
        f.SetNeigh(s);
        System.out.println("Virologist field id before move: " + v2.getField().GetID());


        for (int i = 0; i < v.getAgents().size(); i++) {
            if (v.getAgents().get(i) instanceof Dance && !v2.isProtected()) {
                v.getAgents().get(i).AgentEffect(v2);


                if (v2.IsRandomMove()) {
                    Random rand = new Random();
                    int n = rand.nextInt(v2.getField().NeighbourCount());
                    switch (n) {
                        case 0:
                            v2.Move(f2);
                            System.out.println("Virologist field id after move: " + v2.getField().GetID());
                            break;
                        case 1:
                            v2.Move(s);
                            System.out.println("Virologist field id after move: " + v2.getField().GetID());
                            break;
                    }

                }

            }
        }

        virologists.clear();
    }

    /**
     * Leteszteli a Forget ágenst
     */
    public void TestForgetAgent() {
        int num = 11;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        ForgetCode fc = new ForgetCode();
        RootCode rc = new RootCode();
        DanceCode dc = new DanceCode();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 1);
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        Field f = new Field(1);
        fc.create(v);
        rc.create(v2);
        dc.create(v2);
        v2.AddCode(rc);
        v2.AddCode(dc);
        v.AddCode(fc);
        v.setField(f);
        v2.setField(f);
        virologists.add(v);
        virologists.add(v2);
        for (int i = 0; i < v.getAgents().size(); i++) {
            if (v.getField() == v2.getField() && v.getAgents().get(i) instanceof Forget && !v2.isProtected()) {
                v.getAgents().get(i).AgentEffect(v2);
                try {
                    game.WriteJsonVirologist(virologists, num);
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
        }
    }

    /**
     * Leteszteli, hogy az ágens létrehozása sikeres volt-e.
     */
    public void TestCreatingAgentSuccessfully() {
        int num = 6;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 5);
        DanceCode dancec = new DanceCode();
        v.AddCode(dancec);
        int index = v.getKnownCodes().lastIndexOf(dancec);
        v.getKnownCodes().get(index).create(v);
        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Leteszteli, hogy létre lehet-e hozni egy ágenst az elegendő anyag nélkül.
     */
    public void TestCreatingAgentNotEnoughMaterial() {
        int num = 5;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 0, 0, 40, 7);
        DanceCode dancec = new DanceCode();
        v.AddCode(dancec);
        int index = v.getKnownCodes().lastIndexOf(dancec);
        v.getKnownCodes().get(index).create(v);
        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Létrehoz egy új ágenst, ismeretlen kódból.
     */
    public void TestCreatingAgentUnknownCode() {

        int num = 4;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 8);
        DanceCode dancec = new DanceCode();
        int index = v.getKnownCodes().lastIndexOf(dancec);

        if ((index < virologists.size()) && (index >= 0)) {
            v.getKnownCodes().get(index).create(v);

        }
        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Virologus felveszi az anyagot
     * elvaras: virologus aminoacid es nucleotid szama 10-10
     */
    public void TestPickUpMaterial() {
        int num = 12;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 0, 0, 40, 1);
        Field storage = new Storage(10, 10, 1);


        v.setField(storage);
        storage.Add(v);

        storage.Action();

        storage.Remove(v);
        v.setField(null);

        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Virologus megprobal anyagot felvenni mikozben a max limit mar el van erve
     * elvaras: virologus aminoacid es nucleotid szama marad 20-20
     */
    public void TestPickUpMaterialWithLimitReached() {
        int num = 13;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 20, 20, 20, 1);
        Field storage = new Storage(10, 10, 1);

        v.setField(storage);
        storage.Add(v);

        storage.Action();

        storage.Remove(v);
        v.setField(null);

        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * Virologus megprobal anyagot felvenni olyan mezon, ahol ez nem lehetseges
     * elvaras: nem tortenik semmi, aminoacid es nucleotid szam marad 0
     */
    public void TestPickUpMaterialOnWrongField() {
        int num = 14;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0, glove, 0, 0, 40, 1);
        Field field = new Shelter(1);

        v.setField(field);
        field.Add(v);

        field.Action();

        field.Remove(v);
        v.setField(null);

        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * A virológus megpróbál egy védőfelszerelést felvenni.
     * elvaras: nem tortenik semmi, aminoacid es nucleotid szam marad 0
     */
    public void VirologistPicksUpEquipment() {
        int num = 15;

        Virologist v = new Virologist(0, new Gloves(), 0, 0, 40, 1);
        Shelter field = new Shelter(1);

        v.setField(field);
        field.Add(v);

        field.AddEquipment(new Bag("Bag1"));

        field.Action();

        field.Remove(v);

        virologists.add(v);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    /**
     * A virológus megpróbál egy védőfelszerelést felvenni, de nincs az óvóhelyen, nem sikerül felvenni a felszerelést.
     * elvaras: nem tortenik semmi
     */
    public void VirologistTriesToPickUpEquipmentOutsideOfShelter() {
        int num = 16;
        System.out.println("Nem lehetseges.");
    }

    /**
     * A virológus megpróbál egy lebénult virológustól felszerelést vagy anyagot elvenni.
     * elvaras: nem tortenik semmi, aminoacid es nucleotid szam marad 0
     */
    public void VirologistStealsMaterialOrEquipment() {
        int num = 17;

        Virologist v = new Virologist(0, new Gloves(), 0, 0, 40, 1);
        Virologist v_rooted = new Virologist(0, new Gloves(), 0, 0, 40, 2);
        Field field = new Field(1);

        v.setField(field);
        field.Add(v);

        v_rooted.setField(field);
        field.Add(v_rooted);

        v_rooted.Root();
        Axe axe = new Axe("Axe1");
        v_rooted.AddEquipment(axe);

        v.TakeEquipmentFromVirologist(axe, v_rooted);

        field.Action();

        field.Remove(v);
        field.Remove(v_rooted);

        virologists.add(v);
        virologists.add(v_rooted);
        try {
            game.WriteJsonVirologist(virologists, num);
        } catch (IOException e) {
            System.out.println(e);
        }
        virologists.clear();
    }

    // a virologus mozog egy szomszedos mezore
    public void TestMoveToNeighbourField() {
        int num = 1;
        Gloves glove=new Gloves();
        Virologist v=new Virologist(0,glove,0,0,40,1);
        Field field = new Field(1);
        Field field2 = new Field(2);

        v.setField(field);
        field.Add(v);

        field.Remove(v);
        v.setField(field2);
        field2.Add(v);

        field2.Remove(v);
        v.setField(null);

        virologists.add(v);
        try{
            game.WriteJsonVirologist(virologists,num);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        virologists.clear();
    }

    // virologus megtanul egy kodot egy labortoriumbol, itt egy dance codeot tanul meg
    public void TestLearnGeneticCode(){
        int num = 2;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0,glove,0,0,40,1);

        DanceCode code = new DanceCode();
        Laboratory lab = new Laboratory(code, 1);

        v.setField(lab);
        lab.Add(v);
        lab.Action();
        lab.Remove(v);
        virologists.add(v);
        try{
            game.WriteJsonVirologist(virologists,num);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        virologists.clear();
    }

    // virologus magan hasznal egy agenst, itt egy protect agenst
    public void TestUseAgentOnItself(){
        int num = 3;
        Gloves glove = new Gloves();
        Virologist v = new Virologist(0,glove,0,0,40,1);
        Field field = new Field(1);

        v.setField(field);

        Agent protect = new Protect();
        v.AddAgent(protect);

        v.UseAgent(protect, v);
        virologists.add(v);
        try{
            game.WriteJsonVirologist(virologists,num);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        virologists.clear();
    }


    static private void printMenuItems() {
        System.out.println("\n1. TestMoveToNeighbourField");
        System.out.println("2. TestLearnGeneticCode");
        System.out.println("3. TestUseAgentOnItself");
        System.out.println("4. TestCreatingAgentUnknownCode:");
        System.out.println("5. TestCreatingAgentNotEnoughMaterial:");
        System.out.println("6. TestCreatingAgentSuccessfully:");
        System.out.println("7. TestRootAgentUse:");
        System.out.println("8. UseProtectAgent:");
        System.out.println("9. TestAgentWhileProtected:");
        System.out.println("10. TestDanceAgent:");
        System.out.println("11. TestForgetAgent:");
        System.out.println("12. TestPickUpMaterial:");
        System.out.println("13. TestPickUpMaterialWithLimitReached:");
        System.out.println("14. TestPickUpMaterialOnWrongField:");
        System.out.println("15. VirologistPicksUpEquipment:");
        System.out.println("16. VirologistTriesToPickUpEquipmentOutsideOfShelter:");
        System.out.println("17. VirologistStealsMaterialOrEquipment:");
        System.out.println("-1. Kilepes...\n");
    }

    public static void main(String args[]) // static method
    {

        Game g = new Game();
        Scanner sc = new Scanner(System.in);

        int sel = -2;

        Sequences s = new Sequences();


        while (true) {
            printMenuItems();
            System.out.println("Valassz egy tesztesetet:");
            sel = sc.nextInt();

            if (sel == -1 || sel > 17)
                break;

            switch (sel) {
                case 1:
                    s.TestMoveToNeighbourField();
                    break;
                case 2:
                    s.TestLearnGeneticCode();
                    break;
                case 3:
                    s.TestUseAgentOnItself();
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
                case 12:
                    s.TestPickUpMaterial();
                    break;
                case 13:
                    s.TestPickUpMaterialWithLimitReached();
                    break;
                case 14:
                    s.TestPickUpMaterialOnWrongField();
                    break;
                case 15:
                    s.VirologistPicksUpEquipment();
                    break;
                case 16:
                    s.VirologistTriesToPickUpEquipmentOutsideOfShelter();
                    break;
                case 17:
                    s.VirologistStealsMaterialOrEquipment();
                    break;
            }

        }
    }
}


