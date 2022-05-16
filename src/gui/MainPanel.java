package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ezen a penelen jelennek meg a jatek elemeihez tartozo panelek
 */
public class MainPanel extends JPanel {
    /**
     * A jatek elemeihez tartozo panelek
     */
    private final static ArrayList<JPanel>  graphicObjects = new ArrayList<>();
    /**
     * A view amihez tartozik
     */
    private final View view;
    /**
     * A háttér panel
     */
    private final JPanel backGround = new JPanel();

    /**
     * konstruktor, inicializalja a tagvaltozokat
     */
    public MainPanel(View view){
        this.setLayout(null);
        this.view = view;
        backGround.setSize(new Dimension(1000, 492));
        backGround.setBackground(new Color(204, 204, 255,255));

    }

    /**
     * Kirajzolja a panel-t
     */
    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,1000,492);
        super.paint(g);

        for(int i = graphicObjects.size()-1; i >= 0; --i){
            this.add(graphicObjects.get(i));

            int ranY=0;
            int ranX=0;
            if(i==0)
            {
                ranY = 100;
                ranX = 100;
            }
           if(i%2==0 && i!=0 && i<7)
            {
                ranY = 100;
                ranX = 100+i*(100);
            }
            if(i%2==0 && i>=6)
            {
                ranX=800-i*100;
                ranY=300;
            }
            if(i%2==1 && i>=6)
            {
                ranX=800-i*100;
                ranY=200+100;
            }
            if(i%2==1 && i<7){
                ranY = 100+80;
                ranX = 100+100*i;
            }
            graphicObjects.get(i).setLocation(ranX, ranY  );

        }
        this.add(backGround);
    }

    /**
     * Hozzaad egy uj megjelenitendo elemet
     */
    public void AddGraphicObject(JPanel object){
        graphicObjects.add(object);
        object.addMouseListener(new GraphicPanelListener(view));
        repaint();
    }
    /**
     * Hozzaad egy uj megjelenitendo elemet, a megadott helyre a listaban
     */
    public void AddGraphicObject(JPanel object, int index){
        graphicObjects.add(index, object);
        object.addMouseListener(new GraphicPanelListener(view));
        repaint();
    }
    /**
     * Eltavolitja a megadott elemet megjelenitendo panelek kozul
     */
    public void RemoveGraphicObject(JPanel object){
        this.remove(object);
        graphicObjects.remove(object);
        repaint();
    }
    /**
     * Frissiti a szukseges elemeket
     */
    public void RemoveAllGraphicObject(){
        this.removeAll();
        graphicObjects.clear();
        repaint();
    }

    /**
     * Visszater a graphicObjects ertekevel
     */
    public ArrayList<JPanel> GetGraphicObjects() {
        return graphicObjects;
    }
}
