package gui;
import businesslogic.*;

public class EventHandling {
    
     /**
     * A view, aminek a komponenseinek az eseményihez a függvényeket hozzárendeljük
     */
    private final View view;
    

    public EventHandling(View view) {
        this.view = view;
    }

    public void onStepClicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.printStatus();
        System.out.println("Step Clicked");
        if (view.GetGame().getActiveVirologist() == null || view.getSelectedField() == null) { return; }
        activeVir.Move(view.getSelectedField());
        view.repaint();
        //view.Refresh();
        activeVir.printStatus();
        if (activeVir.getKnownCodes().size() == view.GetGame().getMap().getNumberOfRNAs())
            view.GetGame().endGame();
        view.GetGame().nextVirologist();
        view.Refresh();
        //System.out.println("step utan aktiv virologus: " + view.GetGame().getActiveVirNum());
       

        
    }

    /**PickUp gomb esemenykezeloje */
    public void onPickUpClicked(){
        System.out.println("Pick up Clicked");
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.printStatus();
        activeVir.getField().Action();
        view.GetGame().nextVirologist();
        //activeVir.setTurn(false);
        System.out.println("pivk utan aktiv virologus: " + view.GetGame().getActiveVirNum());
        view.Refresh();
        view.repaint();
        
    }

    /**Skip gomb esemenykezeloje */
    public void onSkipClicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.printStatus();
        view.GetGame().nextVirologist();
        System.out.println("Skip utan aktiv virologus: " + view.GetGame().getActiveVirNum());
        view.Refresh();
    }

    /**Use gomb esemenykezeloje */
    public void onUseClicked(){
        if (view.GetGame().getActiveVirologist() == null || view.getSelectedVirologist() == null) { return; }
        //a birtokaban levo elso agentet hasznalja -- 
        view.GetGame().getActiveVirologist().UseAgent(view.GetGame().getActiveVirologist().getAgents().get(0), view.getSelectedVirologist());
        view.repaint();
        view.GetGame().nextVirologist();
        System.out.println("Use Clicked");
        //System.out.println("use utan aktiv virologus: " + view.GetGame().getActiveVirNum());
        view.Refresh();
    }

    public void onGeneticCode1Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(0).create(activeVir);
        view.GetGame().nextVirologist();
        view.Refresh();
    }

    public void onGeneticCode2Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(1).create(activeVir);
        view.GetGame().nextVirologist();
        view.Refresh();
    }

    public void onGeneticCode3Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(2).create(activeVir);
        view.GetGame().nextVirologist();
        view.Refresh();
    }

    public void onNewGameClicked() {
        view.GetGame().startGame();
        
    }

}
