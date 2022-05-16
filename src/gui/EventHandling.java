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
        System.out.println("Step Clicked");
        if (view.GetGame().getActiveVirologist() == null || view.getSelectedField() == null) { return; }
        view.GetGame().getActiveVirologist().Move(view.getSelectedField());
        view.repaint();
        //view.Refresh();
        view.GetGame().nextVirologist();
        
    }

    /**PickUp gomb esemenykezeloje */
    public void onPickUpClicked(){
        System.out.println("Pick up Clicked");
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getField().Action();
        view.GetGame().nextVirologist();
        view.Refresh();
        view.repaint();
        
    }

    /**Skip gomb esemenykezeloje */
    public void onSkipClicked(){
        view.GetGame().nextVirologist();

    }

    /**Use gomb esemenykezeloje */
    public void onUseClicked(){
        if (view.GetGame().getActiveVirologist() == null || view.getSelectedVirologist() == null) { return; }
        //a birtokaban levo elso agentet hasznalja -- 
        view.GetGame().getActiveVirologist().UseAgent(view.GetGame().getActiveVirologist().getAgents().get(0), view.getSelectedVirologist());
        view.repaint();
        view.GetGame().nextVirologist();
        System.out.println("Use Clicked");
    }

    public void onGeneticCode1Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(0).create(activeVir);
        view.GetGame().nextVirologist();
    }

    public void onGeneticCode2Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(1).create(activeVir);
        view.GetGame().nextVirologist();
    }

    public void onGeneticCode3Clicked(){
        Virologist activeVir = view.GetGame().getActiveVirologist();
        activeVir.getKnownCodes().get(2).create(activeVir);
        view.GetGame().nextVirologist();
    }

    public void onNewGameClicked() {
        view.GetGame().startGame();
    }

}
