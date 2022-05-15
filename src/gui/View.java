package gui;

import businesslogic.Field;
import businesslogic.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {

    private static final JPanel menuContainer = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));

    /**
     * Menubar, ami tartalmazza a menut
     */
    private static final JMenuBar menuBar = new JMenuBar();

    /**
     * Jatek menu
     */
    private static final JMenu  gameMenu = new JMenu("Game");

    /**
     * Menupont, amivel uj jatekot lehet kezdeni
     */
    private static final JMenuItem  newMenuItem = new JMenuItem("New game");

    /**
     * Elrendezest segito panel
     */
    private static final JPanel containerPanel = new JPanel(new BorderLayout());

    /**
     * A jatekbeli vilagot megjelenito panel
     */
    //private static MainPanel mainPanel;

    /**
     * Az aktualis informaciokat szovegesen megjelenito panel
     */
    private static final JPanel infoPanel = new JPanel();



    /**Pelda a gameben inicializalt adatok eleresere*/
    public void TestDatas()
    {
        game.initGame();
        ArrayList<Field> fields=game.getFields();
        System.out.println("Field_DATA:"+ fields.get(0).GetID()+"szomszedeok"+fields.get(0).GetNeighbours().get(0).GetID());
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

    private static final JButton placeGateButton = new JButton("Genetikai kód1");
    private static final JButton buildGateButton = new JButton("Genetikai kód2");
    private static final JButton buildRobotButton = new JButton("Genetikai kód3");

    private static final Color grayColor = new Color(57, 57, 57);
    private static final Color almostWhite = new Color(230, 230, 230);
    private static final Color green = Color.GREEN;

    /**
     * A jatek amit megjelenit
     */
    private Game game;

    /**
     * View konstruktora, inizializalja a megjeleno elemeket
     */
    public View(Game game) {
        super("The world of blind virologists");

        this.game = game;
        this.setMinimumSize(new Dimension(1000, 650));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        //mainPanel = new MainPanel(this);

        //newMenuItem.addActionListener(e -> handlers.NewClicked());

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


        /*drillButton.addActionListener(e -> handlers.DrillClicked());
        mineButton.addActionListener(e -> handlers.MineClicked());
        moveButton.addActionListener(e -> handlers.MoveClicked());
        placeMaterialButton.addActionListener(e -> handlers.PlaceMaterialClicked());
        placeGateButton.addActionListener(e -> handlers.PlaceGateClicked());
        skipButton.addActionListener(e -> handlers.SkipClicked());
        buildRobotButton.addActionListener(e -> handlers.BuildRobotClicked());
        buildGateButton.addActionListener(e -> handlers.BuildGateClicked());*/

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
        buttonsSecondRow.add(placeGateButton);
        buttonsSecondRow.add(buildGateButton);
        buttonsSecondRow.add(buildRobotButton);

        //mainPanel.setBackground(spaceBlue);
        menuContainer.setBackground(green);

        containerPanel.add(menuContainer, BorderLayout.NORTH);
        containerPanel.add(infoPanel, BorderLayout.SOUTH);
        //containerPanel.add(mainPanel, BorderLayout.CENTER);

        this.add(containerPanel);
        TestDatas();
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

    /**
     * Leszdi a jatek paneleit a mainPanel-rol
     */
    public void Clear(){
        //mainPanel.RemoveAllGraphicObject();
        //Refresh();
    }
}
