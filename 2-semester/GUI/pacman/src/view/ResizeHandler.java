package view;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizeHandler extends ComponentAdapter {
    private JTable mapTable;
    private JScrollPane scrollPane;
    private int COLS;
    private int ROWS;

    public ResizeHandler(JTable mapTable, JScrollPane scrollPane) {
        this.mapTable = mapTable;
        this.scrollPane = scrollPane;
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
    }
}
