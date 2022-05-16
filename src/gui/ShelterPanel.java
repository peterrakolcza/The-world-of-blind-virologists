package gui;

import businesslogic.Field;
import businesslogic.Shelter;

import javax.swing.*;
import java.awt.*;

public class ShelterPanel extends JPanel
{

    private Shelter field;
    private int panelsize = 30;

    public ShelterPanel(Shelter f) {
        this.field = f;
        this.setSize(panelsize, panelsize);
        this.setBackground(new Color(0,0,0,0));

    }

    public Field getField() {
        return field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.PINK);
        g2d.fillOval(0, 0, panelsize, panelsize);

        g2d.setPaint(Color.darkGray);
        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);
        g2d.drawString("Shelter" , 2, 12);
    }
}

