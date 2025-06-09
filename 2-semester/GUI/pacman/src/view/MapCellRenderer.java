package view;

import controller.GameController;
import model.CellType;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;


public class MapCellRenderer extends JLabel implements TableCellRenderer {
    private CellType cellType;

    private Map<CellType, ImageIcon> icons;

    public MapCellRenderer(Map<CellType, ImageIcon> icons) {
        this.icons = icons;
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.cellType = (CellType) value;
        ImageIcon icon = icons.get(cellType);

        if (icon != null) {
            setIcon(icon);
            setText("");
        } else {
            setIcon(null);
        }

        if (cellType == CellType.SPAWNING_POOL) {
            setBackground(Color.PINK);
        } else {
            setBackground(Color.DARK_GRAY);
        }

        return this;
    }
}
