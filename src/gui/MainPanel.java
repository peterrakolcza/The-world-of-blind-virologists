package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ezen a penelen jelennek meg a jatek elemeihez tartozo panelek
 */
public class MainPanel extends JPanel {
    /**
     * A jatek elemeihez tartozo panelek
     */
    private final static ArrayList<FieldPanel>  graphicObjects = new ArrayList<>();
    /**
     * A view amihez tartozik
     */
    private final View view;
    /**
     * A háttér panel
     */
    private final JPanel backGround = new JPanel();
    private final static ArrayList<VirologistPanel>  graphicVirologists = new ArrayList<>();

    /**
     * konstruktor, inicializalja a tagvaltozokat
     */
    public MainPanel(View view) {
        this.setLayout(null);
        this.view = view;
        backGround.setSize(new Dimension(1000, 492));
        backGround.setBackground(new Color(204, 204, 255, 255));
    }

    /**
     * Kirajzolja a panel-t
     */
    @Override
    public void paint(Graphics g) {
        
        g.clearRect(0,0,1000,492);
        super.paint(g);
        int ct = 0;

        for(int i = graphicObjects.size()-1; i >= 0; --i){
           
            this.add(graphicObjects.get(i));

            int ranY = 0;
            int ranX = 0;
            if (i == 0) {
                ranY = 100;
                ranX = 100;
            }
            if (i % 2 == 0 && i != 0 && i < 7) {
                ranY = 100;
                ranX = 100 + i * (100);
            }

            if (i == 7) {
                ranX = 700;
                ranY = 270;
            }

            if (i % 2 == 1 && i < 7) {
                ranY = 100 + 80;
                ranX = 100 + 100 * i;
            }
            if (i > 7 && i % 2 == 0) {
                ct++;
                ranY = 350 - 80;
                ranX = 700 - ct * 100;
            }
            if (i > 7 && i % 2 == 1) {
                ct++;
                ranY = 350;
                ranX = 700 - ct * 100;
            }

            graphicObjects.get(i).setLocation(ranX, ranY );
            graphicObjects.get(i).getField().setPos(ranX, ranY);
            //System.out.print("ez lenne az ertek: " +  graphicObjects.get(i).getField().getx());
            
           

        }
        for (int j = 0; j < graphicVirologists.size(); j++) {
            graphicVirologists.get(j).getVirologist().setField(graphicObjects.get(j).getField());
        }

        for (int k = 0; k < graphicVirologists.size()-1; k++) {
            //System.out.print("lefutott: " + graphicVirologists.size());
            //System.out.print("lefutott k erteke: " + k);
            //int ranY = (int)graphicObjects.get(k).getLocation().getX();
            //int ranX = (int)graphicObjects.get(k).getLocation().getY();

            
            int ranY = graphicVirologists.get(k).getVirologist().getField().gety() + 50;
            int ranX = graphicVirologists.get(k).getVirologist().getField().gety() + 50;
            

            this.add(graphicVirologists.get(k));

            graphicVirologists.get(k).setLocation(ranX, ranY);
            

        }
        this.add(backGround);
    }

    /**
     * Hozzaad egy uj megjelenitendo elemet
     */
    public void AddGraphicObject(FieldPanel object){
        graphicObjects.add(object);
        object.addMouseListener(new GraphicPanelListener(view));
        repaint();
    }

    /**
     * Hozzaad egy uj megjelenitendo elemet, a megadott helyre a listaban
     */
    public void AddGraphicObject(FieldPanel object, int index){
        graphicObjects.add(index, object);
        object.addMouseListener(new GraphicPanelListener(view));
        repaint();
    }

    /**
     * Eltavolitja a megadott elemet megjelenitendo panelek kozul
     */
    public void RemoveGraphicObject(JPanel object) {
        this.remove(object);
        graphicObjects.remove(object);
        repaint();
    }

    /**
     * Frissiti a szukseges elemeket
     */
    public void RemoveAllGraphicObject() {
        this.removeAll();
        graphicObjects.clear();
        repaint();
    }

    /**
     * Visszater a graphicObjects ertekevel
     */
    public ArrayList<FieldPanel> GetGraphicObjects() {
        return graphicObjects;
    }

    public ArrayList<VirologistPanel> GetGraphicVirolosits() {
        return graphicVirologists;
    }

    public void AddGraphicVirologist(VirologistPanel vir){
        
        graphicVirologists.add(vir);
        vir.addMouseListener(new GraphicPanelListener(view));
        repaint();
    }
}
