package api.GUI.elements.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MatrixHighlightRenderer extends DefaultTableCellRenderer {
    private final MatrixSelection matrixSelection;

    public MatrixHighlightRenderer(MatrixSelection matrixSelection) {
        this.matrixSelection = matrixSelection;
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (matrixSelection.contains(row, column)) {
            c.setBackground(Color.ORANGE);
        }else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }
}
