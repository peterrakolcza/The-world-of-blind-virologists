package gui;

import businesslogic.Field;
import businesslogic.Laboratory;
import businesslogic.Storage;

import javax.swing.*;
import java.awt.*;

public class LabPanel extends JPanel {

    private Laboratory field;
    private int panelsize = 60;

    public LabPanel(Laboratory f) {
        this.field = f;
        this.setSize(panelsize, panelsize);
        this.setBackground(new Color(0, 0, 0, 0));

    }

    public Field getField() {
        return field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.GREEN);
        g2d.fillOval(0, 0, panelsize, panelsize);

        g2d.setPaint(Color.darkGray);
        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);
        g2d.drawString("Lb" + field.GetID(), 10, 20);
    }
}