package gui;

import businesslogic.Virologist;

import javax.swing.*;
import java.awt.*;

/**
 * virologust megjelenito panel
 */
public class VirologistPanel extends JPanel {
    /**
     * A megjelenitendo virologus
     * */
    private final Virologist virologist;

    /**
     * panel merete
     */
    private int panelsize = 16;

    /**
     * beallitja az alap ertekeket
     * @param virologist a kirajzolando virologus
     */
    public VirologistPanel(Virologist virologist) {
        this.virologist = virologist;
        this.setSize(panelsize, panelsize);
        this.setBackground(new Color(0,0,0,0));
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * rajzolo fuggveny felulirasa
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.yellow);
        g2d.fillOval(0, 0, panelsize, panelsize);

        g2d.setPaint(Color.darkGray);
        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);
        g2d.drawString("V" + virologist.getid(), 2, 12);

    }
}
