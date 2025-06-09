package view;

import controller.GameController;
import entities.Pacman;
import model.CellType;
import model.GameScore;
import model.PlayableMapTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GameView extends JPanel {
    private final int ROWS;
    private final int COLS;
    private int cellSize = 24;

    private Map<CellType, ImageIcon> icons;

    private PlayableMapTableModel mapModel;

    private final JFrame frame;
    private JTable mapTable;
    private JScrollPane scrollPane;

    private GameScore score;
    private JLabel scoreLabel;
    private GameController gameController;

    private Pacman pacman;

    public GameView(RootView rootView, int width, int height) {
        this.COLS = width;
        this.ROWS = height;

        this.frame = rootView.getFrame();

        loadImages();
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

        ResizeHandler resizeListener = new ResizeHandler(mapTable, scrollPane, this);
        scrollPane.addComponentListener(resizeListener);
        this.dispatchEvent(new ComponentEvent(this, ComponentEvent.COMPONENT_RESIZED));
    }

    private void generateScoreLabel() {
        this.scoreLabel = new JLabel("", SwingConstants.CENTER);
        this.score = new GameScore(scoreLabel);
    }

    private void styleComponents() {
        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        mapTable.setShowGrid(false);
        mapTable.setBackground(Color.BLACK);
        setBackground(Color.BLACK);
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setBorder(null);

        scoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBackground(Color.BLACK);

        this.setBackground(Color.BLACK);
        this.frame.setSize(1200, 800);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
    }

    private ImageIcon loadAndScaleImageIcon(String imageFileName) {
        URL url = getClass().getResource("/images/" + imageFileName);
        int size = this.cellSize;
        if (imageFileName != "wall.png") size = (size / 3) * 2;
        else size = (int) (1.5 * size);
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void loadImages() {
        this.icons = new HashMap<>();

        icons.put(CellType.WALL, loadAndScaleImageIcon("wall.png"));

        // entities
        icons.put(CellType.GHOST, loadAndScaleImageIcon("ghost.png"));
        icons.put(CellType.GHOST_HARMLESS, loadAndScaleImageIcon("ghost-harmless.png"));
        icons.put(CellType.PACMAN, loadAndScaleImageIcon("pacman.png"));
        icons.put(CellType.POINT, loadAndScaleImageIcon("point.png"));

        // powerups
        icons.put(CellType.POWERUP_EXTRA_LIFE, loadAndScaleImageIcon("heart.png"));
        icons.put(CellType.POWERUP_FREEZE, loadAndScaleImageIcon("snowflakes.png"));
        icons.put(CellType.POWERUP_SLOW_GHOSTS, loadAndScaleImageIcon("snail.png"));
        icons.put(CellType.POWERUP_HARMLESS_GHOSTS, loadAndScaleImageIcon("knife.png"));
        icons.put(CellType.POWERUP_SPEED_UP, loadAndScaleImageIcon("speedup.png"));
    }

    public void setCellSize(int value){
        this.cellSize = value;
    }
}
