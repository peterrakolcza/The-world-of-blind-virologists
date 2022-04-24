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
        v2.setField(f);
        v2.getField().SetNeigh(f2);


        for (int i = 0; i < v.getAgents().size(); i++) {
            if (v.getAgents().get(i) instanceof Dance && !v2.isProtected()) {
                v.getAgents().get(i).AgentEffect(v2);


                if (v2.IsRandomMove()) {
                    Random rand = new Random();
                    int n = rand.nextInt(v2.getField().NeighbourCount());
                    switch (n) {
                        case 0:
                            v2.Move(f2);
                            try {
                                game.WriteField(num, f2);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                            break;
                    }

                }

            }
        }

        virologists.clear();
    }

    public void TestForgetAgent() {
        int num = 11;
        Gloves glove = new Gloves();
        glove.SetEffectTime(0);
        ForgetCode fc = new ForgetCode();
        Virologist v = new Virologist(0, glove, 10, 15, 40, 1);
        Virologist v2 = new Virologist(0, glove, 10, 20, 30, 2);
        Field f = new Field(1);
        fc.create(v);
        v.AddCode(fc);
        //fc.create(v2);
        v2.AddCode(fc);
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

    static private void printMenuItems() {
        System.out.println("1. xy eset:");
        System.out.println("2. Valassz egy tesztesetet:");
        System.out.println("3. Valassz egy tesztesetet:");
        System.out.println("4. TestCreatingAgentUnknownCode:");
        System.out.println("5. TestCreatingAgentNotEnoughMaterial:");
        System.out.println("6. TestCreatingAgentSuccessfully:");
        System.out.println("7. TestRootAgentUse:");
        System.out.println("8. UseProtectAgent:");
        System.out.println("9. TestAgentWhileProtected:");
        System.out.println("10. TestDanceAgent:");
        System.out.println("11. TestForgetAgent:");
        System.out.println("-1. Kilepes...");
    }

    public static void main(String args[]) // static method
    {

        Game g = new Game();
        Scanner sc = new Scanner(System.in);

        int sel = -2;

        Sequences s = new Sequences();



        while(true) {
            printMenuItems();
            System.out.println("Valassz egy tesztesetet:");
            sel = sc.nextInt();

            if(sel == -1 || sel > 11)
                break;

            switch (sel) {

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

        }
    }
}


