package view;

import controller.GameController;
import entities.Pacman;
import model.CellType;
import model.GameScore;
import model.PlayableMapTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class GameView extends JPanel {
    private static final int ROWS = 25;
    private static final int COLS = 40;

    private Map<CellType, ImageIcon> icons;

    private PlayableMapTableModel mapModel;

    private final JFrame frame;
    private JTable mapTable;
    private JScrollPane scrollPane;

    private GameScore score;
    private JLabel scoreLabel;
    private GameController gameController;

    private Pacman pacman;

    public GameView(RootView rootView) {
        this.frame = rootView.getFrame();

        initImages();
        generateScoreLabel();
        generateMap();
        styleComponents();
        requestFocusInWindow();
        this.gameController = new GameController(mapModel, score, pacman, this.mapModel.getGhostsArr(), rootView);
        this.gameController.initAll();
    }

    private void generateMap() {
        this.mapModel = new PlayableMapTableModel(COLS, ROWS);
        this.pacman = mapModel.getPacman();
        this.mapTable = new JTable(this.mapModel) {
            @Override
            public int getRowHeight() {
                return getColumnModel().getColumn(0).getWidth();
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mapTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.scrollPane = new JScrollPane();

        mapTable.setTableHeader(null);
        mapTable.setDefaultRenderer(Enum.class, new MapCellRenderer(this.icons));

        JPanel tableHolder = new JPanel();
        tableHolder.setLayout(new BoxLayout(tableHolder, BoxLayout.X_AXIS));
        tableHolder.setBackground(Color.BLACK);
        tableHolder.add(Box.createHorizontalGlue()); // for auto padding left, to center the table horizontally
        tableHolder.add(mapTable);
        tableHolder.add(Box.createHorizontalGlue()); // auto padding right

        scrollPane.setViewportView(tableHolder);
        scrollPane.setFocusable(false);

        ResizeHandler resizeListener = new ResizeHandler(mapTable, scrollPane);
        scrollPane.addComponentListener(resizeListener);
        this.dispatchEvent(new ComponentEvent(this, ComponentEvent.COMPONENT_RESIZED));
    }

    private void generateScoreLabel() {
        this.scoreLabel = new JLabel("NASDAQ", SwingConstants.CENTER);
        this.score = new GameScore(scoreLabel);
    }

    private void styleComponents() {
        // Placement and initialization
        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Table
        mapTable.setShowGrid(false);
        mapTable.setBackground(Color.BLACK);
        setBackground(Color.BLACK);
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setBorder(null);

        // Score label
        scoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBackground(Color.BLACK);

        // Frame
        this.setBackground(Color.BLACK);
        this.frame.setSize(1200, 800);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
    }

    private void initImages() {
        this.icons = new HashMap<>();
        icons.put(CellType.WALL, new ImageIcon("pacman.png"));
    }
}
