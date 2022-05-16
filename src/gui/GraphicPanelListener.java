package gui;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicPanelListener implements MouseListener {
    /**
     * Referencia a view objektumra
     */
    private final View view;
    public GraphicPanelListener(View view) {
        this.view = view;
    }
    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass() == VirologistPanel.class) {
            view.SetSelectedVirologist(((VirologistPanel)e.getSource()).getVirologist());
            view.VirologistClicked(((VirologistPanel)e.getSource()).getVirologist());
            
        }
        if (e.getSource().getClass() == FieldPanel.class) {
            view.SetSelectedField(((FieldPanel)e.getSource()).getField());
            view.FieldClicked(((FieldPanel)e.getSource()).getField());
        }
        if (e.getSource().getClass() == EquipmentPanel.class) {
            view.SetSelectedEquipment(((EquipmentPanel)e.getSource()).getEquipment());
            view.EquipmentClicked(((EquipmentPanel)e.getSource()).getEquipment());
        }
        view.repaint();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
