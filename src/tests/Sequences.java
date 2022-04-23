package tests;

import businesslogic.*;

import java.io.IOException;
import java.util.ArrayList;


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
        virologists.add(v);
        virologists.add(v2);
        for(int i=0;i<v.getAgents().size();i++)
        {
            if(v.getAgents().get(i) instanceof Forget && v2.isProtected())
            {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }
            else if(v.getAgents().get(i) instanceof Dance && v2.isProtected())
            {
                v.getAgents().get(i).AgentEffect(v2);
                break;
            }
            else if(v.getAgents().get(i) instanceof Root && v2.isProtected())
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
    }
}


