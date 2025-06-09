package view;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizeHandler extends ComponentAdapter {
    private final JTable mapTable;
    private final JScrollPane scrollPane;
    private final GameView gameView;
    private final int COLS;
    private final int ROWS;

    private int lastRenderedAt;

    public ResizeHandler(JTable mapTable, JScrollPane scrollPane, GameView gameView) {
        this.mapTable = mapTable;
        this.scrollPane = scrollPane;
        this.gameView = gameView;
        this.COLS = mapTable.getColumnCount();
        this.ROWS = mapTable.getRowCount();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension viewportSize = scrollPane.getViewport().getExtentSize();

        int cellWidth = viewportSize.width / COLS;
        int cellHeight = viewportSize.height / ROWS;

        // Take the shorter side as square size:
        int cellSize = Math.min(cellWidth, cellHeight);
        gameView.setCellSize(cellSize);
        if (this.lastRenderedAt == cellSize) return; // to avoid rendering multiple times at the same time with the same effect
        this.lastRenderedAt = cellSize;


        int tableWidth = cellSize * COLS;
        int tableHeight = cellSize * ROWS;

        // Set row heights and column widths
        mapTable.setRowHeight(cellSize);
        TableColumnModel columnModel = mapTable.getColumnModel();
        for (int i = 0; i < COLS; i++) {
            columnModel.getColumn(i).setPreferredWidth(cellSize);
            columnModel.getColumn(i).setMinWidth(cellSize);
            columnModel.getColumn(i).setMaxWidth(cellSize);
        }

        mapTable.setPreferredScrollableViewportSize(new Dimension(tableWidth, tableHeight));

        mapTable.revalidate();

        gameView.loadImages();
    }
}
