package tests;

import businesslogic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Sequences {
    private Game game=new Game();
    private ArrayList<Virologist> virologists=new ArrayList<Virologist>();

    /**Nem vedett Virologuson root agent hasznalata*/
    public void TestRootAgentUse()
    {
        int num=7;
        Gloves glove=new Gloves();
        glove.SetEffectTime(0);
        RootCode rc=new RootCode();
        Virologist v=new Virologist(0,glove,10,15,40,1);
        Virologist v2=new Virologist(0,glove,10,20,30,2);
        v.AddCode(rc);
        rc.create(v);
        virologists.add(v);
        virologists.add(v2);
        for(int i=0;i<v.getAgents().size();i++)
        {
            if(v.getAgents().get(i) instanceof Root)
            {
                v.getAgents().get(i).AgentEffect(v2);
                try{
                    game.WriteJsonVirologist(virologists,num);
                }catch (IOException e)
                {
                    System.out.println(e);
                }
                break;
            }

        }
        virologists.clear();
    }

    public void UseProtectAgent()
    {
        int num=8;
        Gloves glove=new Gloves();
        glove.SetEffectTime(0);
        ProtectCode pc=new ProtectCode();
        Virologist v2=new Virologist(0,glove,10,20,30,2);
        pc.create(v2);
        v2.AddCode(pc);
        virologists.add(v2);
        for(int i=0;i<virologists.size();i++)
        {
            if(v2.getAgents().get(i) instanceof Protect)
            {
                v2.getAgents().get(i).AgentEffect(v2);
                break;
            }
        }
        try{
            game.WriteJsonVirologist(virologists,num);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        virologists.clear();
    }

    public void TestAgentWhileProtected()
    {
        int num=9;
        Gloves glove=new Gloves();
        glove.SetEffectTime(0);
        ProtectCode pc=new ProtectCode();
        RootCode rc=new RootCode();
        Virologist v=new Virologist(0,glove,10,15,40,1);
        Virologist v2=new Virologist(0,glove,10,20,30,2);
        pc.create(v2);
        rc.create(v);
        v.AddCode(rc);
        v2.AddCode(pc);
        virologists.add(v);
        virologists.add(v2);
        for(int i=0;i<v.getAgents().size();i++)
        {
            if(v.getAgents().get(i) instanceof Forget && (v2.isProtected() ||v2.HasGloves()))
            {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }
            else if(v.getAgents().get(i) instanceof Dance && (v2.isProtected() ||v2.HasGloves()))
            {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }
            else if(v.getAgents().get(i) instanceof Root && (v2.isProtected() ||v2.HasGloves()))
            {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }

        }

        try{
            game.WriteJsonVirologist(virologists,num);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        virologists.clear();
    }

    public void TestDanceAgent()
    {
        int num=10;
        Gloves glove=new Gloves();
        glove.SetEffectTime(0);
        Virologist v=new Virologist(0,glove,10,15,40,1);
        Virologist v2=new Virologist(0,glove,10,20,30,2);
        DanceCode dc=new DanceCode();
        v.AddCode(dc);
        dc.create(v);
        virologists.add(v);
        virologists.add(v2);
        Field f=new Field(0);
        Field f2=new Field(3);
        v2.setField(f);
        v2.getField().SetNeigh(f2);


        for(int i=0;i<v.getAgents().size();i++)
        {
            if(v.getAgents().get(i) instanceof Dance && !v2.isProtected())
            {
                v.getAgents().get(i).AgentEffect(v2);


                if(v2.IsRandomMove())
                {
                    Random rand = new Random();
                    int n = rand.nextInt(v2.getField().NeighbourCount());
                    switch (n)
                    {
                        case 0:
                            v2.Move(f2);
                            try{
                                game.WriteField(num,f2);
                            }catch (IOException e)
                            {
                                System.out.println(e);
                            }
                            break;
                    }

                }

            }
        }

        virologists.clear();
    }

    public void TestForgetAgent()
    {
        int num=11;
        Gloves glove=new Gloves();
        glove.SetEffectTime(0);
        ForgetCode fc=new ForgetCode();
        Virologist v=new Virologist(0,glove,10,15,40,1);
        Virologist v2=new Virologist(0,glove,10,20,30,2);
        Field f=new Field(1);
        fc.create(v);
        v.AddCode(fc);
        //fc.create(v2);
        v2.AddCode(fc);
        v.setField(f);
        v2.setField(f);
        virologists.add(v);
        virologists.add(v2);
        for(int i=0;i<v.getAgents().size();i++)
        {
            if(v.getField()==v2.getField() && v.getAgents().get(i) instanceof Forget && !v2.isProtected())
            {
                v.getAgents().get(i).AgentEffect(v2);
                try
                {
                    game.WriteJsonVirologist(virologists,num);
                }catch (IOException e)
                {
                    System.out.println(e);
                }

            }
        }
    }
}


