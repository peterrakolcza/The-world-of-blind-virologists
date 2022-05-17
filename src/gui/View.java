package gui;

import businesslogic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {

    private static final JPanel menuContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

    /**
     * Menubar, ami tartalmazza a menut
     */
    private static final JMenuBar menuBar = new JMenuBar();

    /**
     * Jatek menu
     */
    private static final JMenu gameMenu = new JMenu("Game");

    /**
     * Menupont, amivel uj jatekot lehet kezdeni
     */
    private static final JMenuItem newMenuItem = new JMenuItem("New game");

    /**
     * Elrendezest segito panel
     */
    private static final JPanel containerPanel = new JPanel(new BorderLayout());

    /**
     * A jatekbeli vilagot megjelenito panel
     */
    private static MainPanel mainPanel;

    /**
     * Az aktualis informaciokat szovegesen megjelenito panel
     */
    private static final JPanel infoPanel = new JPanel();
    private final EventHandling eventhandling = new EventHandling(this);

    private Virologist selectedVirologist = null;
    private Field selectedField = null;
    private Equipment selectedEquipment = null;

    /**
     * A jatek amit megjelenit
     */
    private Game game;

    /** Pelda a gameben inicializalt adatok eleresere */
    public void TestDatas() {
        game.initGame();
        ArrayList<Field> fields = game.getFields();
        System.out.println(
                "Field_DATA:" + fields.get(0).GetID() + "szomszedeok" + fields.get(0).GetNeighbours().get(0).GetID());
    }

    /**
     * Az informacios resz bal oldali resze
     */
    private static final JPanel infoPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));

    /**
     * Az informacios resz jobb oldali resze
     */
    private static final JPanel infoPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private static final JPanel activeVirologistInfoPanel = new JPanel();
    private static final JLabel activeVirologistLabel = new JLabel("Active Virologist: Virologist1");
    private static final JLabel clickedObjectLabel = new JLabel("Clicked object: null");

    private static final JPanel activeVirologistInfoPanel2 = new JPanel();
    private static final JLabel activeVirologistNucleotidLabel = new JLabel("Nucleotids: 0");
    private static final JLabel activeVirologistAminoacidsLabel = new JLabel("Aminoacids: 0");
    private static final JLabel activeVirologistAxeLabel = new JLabel("Has Axe: no");

    private static final JPanel clickedObjectInfoPanel = new JPanel();
    private static final JLabel activeVirologistBearLabel = new JLabel("Is Bear: no");
    private static final JLabel activeVirologistEquipmentLabel = new JLabel("Equipments: none");
    private static final JLabel activeVirologistLearntCodesLabel = new JLabel("Learnt Codes: none");

    private static final JButton stepButton = new JButton("Step");
    private static final JButton pickUpButton = new JButton("Pick up");
    private static final JButton useButton = new JButton("Use");
    private static final JButton skipButton = new JButton("Skip");

    private static final JButton geneticCode1Button = new JButton("Genetikai kód1");
    private static final JButton geneticCode2Button = new JButton("Genetikai kód2");
    private static final JButton geneticCode3Button = new JButton("Genetikai kód3");

    private static final Color grayColor = new Color(57, 57, 57);
    private static final Color almostWhite = new Color(230, 230, 230);
    private static final Color green = Color.GREEN;

    /**
     * View konstruktora, inizializalja a megjeleno elemeket
     */
    public View(Game game) {
        super("The world of blind virologists");

        this.game = game;
        game.initGame();
        this.setMinimumSize(new Dimension(1000, 650));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        mainPanel = new MainPanel(this);

        /** Annak ellenőrzése, hogy van e ilyen mező már létrehozva */
        ArrayList<String> existing_fields = new ArrayList<String>();
        /** Sima mezők mainpanelhez adása */

        FieldPanel fp = new FieldPanel(game.getFields().get(0));
        mainPanel.AddGraphicObject(fp);
        ShelterPanel sp = new ShelterPanel(game.getShelters().get(1));
        mainPanel.AddGraphicObject(sp);
        FieldPanel fp2 = new FieldPanel(game.getFields().get(2));
        mainPanel.AddGraphicObject(fp2);
        StoragePanel st1 = new StoragePanel(game.getStorages().get(2));
        mainPanel.AddGraphicObject(st1);
        ShelterPanel shp3 = new ShelterPanel(game.getShelters().get(3));
        mainPanel.AddGraphicObject(shp3);
        LabPanel lb = new LabPanel(game.getLabs().get(1));
        mainPanel.AddGraphicObject(lb);
        ShelterPanel sp2 = new ShelterPanel(game.getShelters().get(0));
        mainPanel.AddGraphicObject(sp2);
        LabPanel lb2 = new LabPanel(game.getLabs().get(0));
        mainPanel.AddGraphicObject(lb2);
        StoragePanel st2 = new StoragePanel(game.getStorages().get(1));
        mainPanel.AddGraphicObject(st2);
        StoragePanel sp3 = new StoragePanel(game.getStorages().get(0));
        mainPanel.AddGraphicObject(sp3);
        LabPanel lb3 = new LabPanel(game.getLabs().get(2));
        mainPanel.AddGraphicObject(lb3);
        FieldPanel fp3 = new FieldPanel(game.getLabs().get(1));
        mainPanel.AddGraphicObject(fp3);
        FieldPanel pf4 = new FieldPanel(game.getFields().get(3));
        mainPanel.AddGraphicObject(pf4);
        ShelterPanel sph3 = new ShelterPanel(game.getShelters().get(2));
        mainPanel.AddGraphicObject(sph3);

        for (int k = 0; k < game.getVirologists().size(); k++) {
            VirologistPanel vp = new VirologistPanel(game.getVirologists().get(k));
            mainPanel.AddGraphicVirologist(vp);
        }

        /** Shelterek mainpanelhez adása */
        /*
         * for(int j=0;j<game.getShelters().size();j++)
         * {
         * ShelterPanel sh=new ShelterPanel(game.getShelters().get(j));
         * mainPanel.AddGraphicObject(sh);
         * }
         */
        this.add(mainPanel);

        // newMenuItem.addActionListener(e -> handlers.NewClicked());

        gameMenu.add(newMenuItem);
        menuBar.add(gameMenu);
        menuContainer.add(menuBar);

        infoPanel.setBackground(grayColor);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.LINE_AXIS));

        infoPanelLeft.setBackground(grayColor);
        infoPanelRight.setBackground(grayColor);
        infoPanel.add(infoPanelLeft);
        infoPanel.add(infoPanelRight);

        activeVirologistInfoPanel.setLayout(new BoxLayout(activeVirologistInfoPanel, BoxLayout.PAGE_AXIS));
        activeVirologistLabel.setForeground(almostWhite);
        clickedObjectLabel.setForeground(almostWhite);
        activeVirologistInfoPanel.add(activeVirologistLabel);
        activeVirologistInfoPanel.add(clickedObjectLabel);
        activeVirologistInfoPanel.setBackground(grayColor);

        activeVirologistInfoPanel2.setLayout(new BoxLayout(activeVirologistInfoPanel2, BoxLayout.PAGE_AXIS));
        activeVirologistNucleotidLabel.setForeground(almostWhite);
        activeVirologistAminoacidsLabel.setForeground(almostWhite);
        activeVirologistAxeLabel.setForeground(almostWhite);
        activeVirologistInfoPanel2.add(activeVirologistNucleotidLabel);
        activeVirologistInfoPanel2.add(activeVirologistAminoacidsLabel);
        activeVirologistInfoPanel2.add(activeVirologistAxeLabel);
        activeVirologistInfoPanel2.setBackground(grayColor);

        clickedObjectInfoPanel.setLayout(new BoxLayout(clickedObjectInfoPanel, BoxLayout.PAGE_AXIS));
        activeVirologistBearLabel.setForeground(almostWhite);
        activeVirologistEquipmentLabel.setForeground(almostWhite);
        activeVirologistLearntCodesLabel.setForeground(almostWhite);
        clickedObjectInfoPanel.add(activeVirologistEquipmentLabel);
        clickedObjectInfoPanel.add(activeVirologistLearntCodesLabel);
        clickedObjectInfoPanel.add(activeVirologistBearLabel);
        clickedObjectInfoPanel.setBackground(grayColor);

        infoPanelLeft.add(activeVirologistInfoPanel);
        infoPanelLeft.add(Box.createHorizontalStrut(20));
        infoPanelLeft.add(activeVirologistInfoPanel2);
        infoPanelLeft.add(Box.createHorizontalStrut(20));
        infoPanelLeft.add(clickedObjectInfoPanel);

        newMenuItem.addActionListener(e -> eventhandling.onNewGameClicked());
        stepButton.addActionListener(e -> eventhandling.onStepClicked());
        skipButton.addActionListener(e -> eventhandling.onSkipClicked());
        useButton.addActionListener(e -> eventhandling.onUseClicked());
        pickUpButton.addActionListener(e -> eventhandling.onPickUpClicked());
        geneticCode1Button.addActionListener(e -> eventhandling.onGeneticCode1Clicked());
        geneticCode2Button.addActionListener(e -> eventhandling.onGeneticCode2Clicked());
        geneticCode3Button.addActionListener(e -> eventhandling.onGeneticCode3Clicked());

        activeVirologistLabel.setText("Active Virologist: " + game.getActiveVirologist().getName());

        JPanel buttonsFirstRow = new JPanel(new FlowLayout());
        JPanel buttonsSecondRow = new JPanel(new FlowLayout());
        buttonsFirstRow.setBackground(grayColor);
        buttonsSecondRow.setBackground(grayColor);

        infoPanelRight.setLayout(new BoxLayout(infoPanelRight, BoxLayout.PAGE_AXIS));
        infoPanelRight.add(buttonsFirstRow);
        infoPanelRight.add(buttonsSecondRow);

        buttonsFirstRow.add(stepButton);
        buttonsFirstRow.add(pickUpButton);
        buttonsFirstRow.add(useButton);
        buttonsFirstRow.add(skipButton);
        buttonsSecondRow.add(geneticCode1Button);
        buttonsSecondRow.add(geneticCode2Button);
        buttonsSecondRow.add(geneticCode3Button);

        mainPanel.setBackground(green);
        menuContainer.setBackground(green);

        containerPanel.add(menuContainer, BorderLayout.NORTH);
        containerPanel.add(infoPanel, BorderLayout.SOUTH);
        containerPanel.add(mainPanel, BorderLayout.CENTER);
        // containerPanel.add(mainPanel, BorderLayout.CENTER);

        this.add(containerPanel);
        TestDatas();
    }

    /** Ide kellene a jatek logika */
    public void GameLoop() {

    }

    /**
     * Visszater a game ertekevel
     */
    public Game GetGame() {
        return game;
    }

    /**
     * Beallitja a kapott ertekre a game-t
     */
    public void SetGame(Game game) {
        this.game = game;
    }

    public Virologist getSelectedVirologist() {
        return selectedVirologist;
    }

    public void SetSelectedVirologist(Virologist selectedVirologist) {
        this.selectedVirologist = selectedVirologist;
    }

    public Field getSelectedField() {
        return selectedField;
    }

    public void SetSelectedField(Field selectedField) {
        this.selectedField = selectedField;
    }

    public Equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void SetSelectedEquipment(Equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

    /**
     * Beallitja a kapott ertekre a selectedVirologist-ot
     */
    public void VirologistClicked(Virologist v) {
        selectedVirologist = v;
        // Refresh();
    }

    public void EquipmentClicked(Equipment e) {
        selectedEquipment = e;
        // Refresh();
    }

    public void FieldClicked(Field f) {
        selectedField = f;
        // Refresh();
    }

    /**
     * Leszdi a jatek paneleit a mainPanel-rol
     */
    public void Clear() {
        // mainPanel.RemoveAllGraphicObject();
        // Refresh();
    }

    public void Refresh() {
        System.out.println("refresssshhh");
        
        activeVirologistLabel.setText("Active Virologist: " + game.getActiveVirologist().getName()); 
        activeVirologistNucleotidLabel.setText("Nucleotids: " + game.getActiveVirologist().getNucleo()); 
        activeVirologistAminoacidsLabel.setText("Aminoacids: " + game.getActiveVirologist().getAmino()); 
        activeVirologistAxeLabel.setText("Has Axe: " + game.getActiveVirologist().getAxe()); 
        //clickedObjectInfoPanel.setText("Active Virologist: " + game.getActiveVirologist().getName()); 
        activeVirologistEquipmentLabel.setText("Equipment: " + game.getActiveVirologist().equipmentNames()); 
        activeVirologistLearntCodesLabel.setText("Learnt Codes: " + game.getActiveVirologist().getKnownCodes().size()); 
        activeVirologistBearLabel.setText("Is Bear: " + game.getActiveVirologist().isBear()); 
        clickedObjectLabel.setText("Clicked object " + this.getSelectedField().GetID()); 
    
        
        repaint();
    }

    
}
