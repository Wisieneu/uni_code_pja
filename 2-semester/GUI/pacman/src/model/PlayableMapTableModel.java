package model;

import entities.AbstractEntity;
import entities.Ghost;
import entities.Pacman;
import entities.PointPickup;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayableMapTableModel extends AbstractTableModel {
    private final int maxX;
    private final int maxY;
    private final int COLS;
    private final int ROWS;
    private final int spawnPointX;
    private final int spawnPointY;

    private final CellType[][] map;
    private final AbstractEntity[][] entityMap;
    private final List<Ghost> ghosts;

    private final Random random;

    private Pacman pacman;

    public PlayableMapTableModel(int width, int height) {
        this.maxX = width - 1;
        this.maxY = height - 1;

        this.COLS = width;
        this.ROWS = height;

        this.spawnPointX = this.maxX / 2;
        this.spawnPointY = this.maxY / 2;

        this.map = new CellType[ROWS][COLS];
        this.entityMap = new AbstractEntity[ROWS][COLS];
        this.ghosts = new ArrayList<>();

        this.random = new Random();

        initializeMapMaze();
        generateMapMaze(1, 1);
        generateGaps();
        buildSpawningPoolGeo();
        setStartPacmanLocation(spawnPointX, spawnPointY + (COLS / 4));
        initEntityMap();
        spawnGhosts();
    }

    private void initializeMapMaze() {
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLS; x++) {
                map[y][x] = CellType.WALL;
            }
        }
    }

    private void generateMapMaze(int x, int y) {
        setCellValue(x, y, CellType.POINT);

        ArrayList<int[]> directions = Directions.directionsList;
        Collections.shuffle(directions, random);

        for (int[] drc : directions) {
            int newX = x + drc[0] * 2;
            int newY = y + drc[1] * 2;

            if (newX > -1 && newX < this.maxX && newY > -1 && newY < this.maxY
                    && getCellValue(newX, newY) == CellType.WALL) {
                setCellValue(x + drc[0], y + drc[1], CellType.POINT); // check all directions
                generateMapMaze(newX, newY);
            }
        }
    }

    private void generateGaps() {
        // Top and bottom row
        for (int x = 1; x < this.maxX; x++) {
            setCellValue(x, 1, CellType.POINT);
            setCellValue(x, this.maxY - 1, CellType.POINT);
        }

        // Most left and most right columns
        for (int y = 1; y < this.maxY; y++) {
            setCellValue(1, y, CellType.POINT);
            setCellValue(this.maxX - 1, y, CellType.POINT);
        }

        // Middle columns
        for (int x = (int) Math.sqrt((double)this.maxX); x < this.maxX - 1; x += (int) Math.sqrt((double)this.maxX)) {
            for (int y = 1; y < this.maxY; y++) {
                setCellValue(x, y, CellType.POINT);
            }
        }

        // Middle rows
        for (int y = (int) Math.sqrt((double)this.maxY); y < this.maxY; y += (int) Math.sqrt((double)this.maxY)) {
            for (int x = 1; x < this.maxX; x++) {
                setCellValue(x, y, CellType.POINT);
            }
        }

        // Eliminate wide corridors
        for (int y = 1; y < this.maxY; y++) {
            for (int x = 1; x < this.maxX; x++) {
                if (getCellValue(x, y) == CellType.EMPTY || getCellValue(x, y) == CellType.POINT) {
                    // check how many tiles are not walls, including corners
                    int surroundingEmptyTilesCount = 0;
                    for (int x1 = -1; x1 < 2; x1++) {
                        for (int y1 = -1; y1 < 2; y1++) {
                            CellType cell = getCellValue(x + x1, y + y1);
                            if (cell == CellType.EMPTY || cell == CellType.POINT)
                                surroundingEmptyTilesCount++;
                        }
                    }
                    if (surroundingEmptyTilesCount > 8) {
                        setCellValue(x, y, CellType.WALL);
                    }
                }
            }
        }
    }

    private void buildSpawningPoolGeo() {
        // Spawning pool
        setCellValue(spawnPointX, spawnPointY, CellType.SPAWNING_POOL);
        setCellValue(spawnPointX + 1, spawnPointY, CellType.SPAWNING_POOL);

        // Space around the spawning pool
        setCellValue(spawnPointX, spawnPointY + 1, CellType.POINT);
        for (int dx = -1; dx < 3; dx++) {
            setCellValue(spawnPointX + dx, spawnPointY + 1, CellType.POINT);
            setCellValue(spawnPointX + dx, spawnPointY - 1, CellType.POINT);
        }

        // Center the spawning pool regardless if the maze has an even amount of columns or not
        if (COLS % 2 == 0) {
            setCellValue(spawnPointX - 1, spawnPointY, CellType.POINT);
        } else {
            setCellValue(spawnPointX - 1, spawnPointY, CellType.SPAWNING_POOL);
            setCellValue(spawnPointX - 2, spawnPointY, CellType.POINT);
            setCellValue(spawnPointX - 2, spawnPointY + 1, CellType.POINT);
        }
    }

    private void initEntityMap() {
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLS; x++) {
                if (getCellValue(x, y) == CellType.POINT) {
                    setEntityAt(x, y, new PointPickup());
                }
            }
        }
    }

    public AbstractEntity getEntityAt(int x, int y) {
        return this.entityMap[y][x];
    }

    public void setEntityAt(int x, int y, AbstractEntity entity) {
        this.entityMap[y][x] = entity;
    }

    private void setStartPacmanLocation(int x, int y) {
        if (x < 1 || y < 1 || x > maxX || y > maxY) {
            setStartPacmanLocation(spawnPointX + 1, spawnPointY + (COLS / 4) - 1);
        }
        if (getCellValue(x, y) == CellType.EMPTY || getCellValue(x, y) == CellType.POINT) {
            this.pacman = new Pacman(x, y);
            setEntityAt(x, y, this.pacman);
            setCellValue(x, y, CellType.PACMAN);
        } else {
            setStartPacmanLocation(x - 1, y);
        }
    }

    private void spawnGhosts() {
        int pos1x = COLS / 3;
        int pos2x = COLS * 2 / 3;

        int y = ROWS / 3;

        while (getCellValue(pos1x, y) == CellType.WALL && getCellValue(pos1x, 1) == CellType.WALL) {
            pos1x--;
        }

        while (getCellValue(pos2x, y) == CellType.WALL && getCellValue(pos2x, 1) == CellType.WALL) {
            pos2x--;
        }

        Ghost g1 = new Ghost(pos1x, 1);
        setCellValue(pos1x, 1, CellType.GHOST);
        setEntityAt(pos1x, 1, g1);
        ghosts.add(g1);

        Ghost g2 = new Ghost(pos2x, 1);
        setCellValue(pos2x, 1, CellType.GHOST);
        setEntityAt(pos2x, 1, g2);
        ghosts.add(g2);

        int area = COLS * ROWS;

        if (area > 250) {
            Ghost g3 = new Ghost(pos1x, y);
            setCellValue(pos1x, y, CellType.GHOST);
            setEntityAt(pos1x, y, g3);
            ghosts.add(g3);
        }
        if (area > 700) {
            Ghost g4 = new Ghost(pos2x, y);
            setCellValue(pos2x, y, CellType.GHOST);
            setEntityAt(pos2x, y, g4);
            ghosts.add(g4);
        }

    }

    public void setCellValue(int x, int y, CellType value) {
        this.map[y][x] = value;
        fireTableCellUpdated(y, x);
    }

    public AbstractEntity[][] getEntityMap() {
        return entityMap;
    }

    public List<Ghost> getGhostsArr() {
        return this.ghosts;
    }

    @Override
    public int getRowCount() {
        return this.ROWS;
    }

    @Override
    public int getColumnCount() {
        return this.COLS;
    }

    // only for lib use, we use (x, y) in the method below that one
    @Override
    public Object getValueAt(int y, int x) {
        return this.map[y][x];
    }

    public CellType getCellValue(int x, int y) {
        return this.map[y][x];
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public int[] getSpawnCords() {
        return new int[]{spawnPointX, spawnPointY};
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return CellType.class;
    }
}
