package gui;

import businesslogic.*;
import javax.swing.*;
import java.awt.*;

public class EquipmentPanel extends JPanel {
    
    private Equipment equipment;
    private int panelsize = 16;

    public EquipmentPanel(Equipment e) {
        this.equipment = e;
        this.setSize(panelsize, panelsize);
        this.setBackground(new Color(0,0,0,0));
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.blue);
        g2d.fillOval(0, 0, panelsize, panelsize);

        g2d.setPaint(Color.darkGray);
        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);
        g2d.drawString("Equipment" , 2, 12);

    }
}

