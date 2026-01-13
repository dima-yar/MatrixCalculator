package api.GUI.elements.table;

import api.GUI.styles.Margin;
import api.matrix.domain.Matrix;
import api.matrix.repository.MatrixRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JPanel {

    private final int thisWidth;
    private final int thisHeight;
    private final int[] sellSize;
    private final Margin tableMargin;
    private final DefaultTableModel tableModel;
    public JTable table;
    private MatrixSelection matrixSelection = new MatrixSelection();
    private MatrixHighlightRenderer matrixHighlightRenderer = new MatrixHighlightRenderer(matrixSelection);

    public JTable getTable(){
        return table;
    }

    public Table(DefaultTableModel model, int thisWidth, int thisHeight, int appBarHeight, int[] sellSize) {
        this.tableModel = model;
        this.thisWidth = thisWidth;
        this.thisHeight = thisHeight;
        this.sellSize = sellSize;
        this.tableMargin = new  Margin(0, appBarHeight);

    }


    public void setUp(){


        this.setBounds(0, tableMargin.Y(), thisWidth, thisHeight);
        this.setLayout(null);


        table = new  JTable(tableModel);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(sellSize[0]);
            table.getColumnModel().getColumn(i).setMinWidth(sellSize[0]);
            table.getColumnModel().getColumn(i).setMaxWidth(sellSize[0]);
        }
        table.setFont(new Font("Arial",  Font.PLAIN, 18));
        table.setRowHeight(sellSize[1]);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setDefaultRenderer( Object.class, matrixHighlightRenderer);

        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, thisWidth, thisHeight);
        scrollPane.setViewportView(table);



        this.add(scrollPane);
    }

    public void highlight(int row, int col, int rows, int columns){
        matrixSelection.rowStart = row;
        matrixSelection.colStart = col;
        matrixSelection.rows = rows;
        matrixSelection.columns = columns;
        table.repaint();
    }
    public void clearHightlight(){
        matrixSelection.rowStart = -1;
        matrixSelection.colStart = -1;


        table.repaint();
    }
    public void clearTable(){
        clearHightlight();
        for (int r = 0; r < table.getRowCount(); r++){
            for (int c = 0; c < table.getColumnCount(); c++) {
                table.setValueAt(null, r, c);
            }
        }
    }

    public void printMatrix(Matrix matrix, int startRow, int startCol){
        clearHightlight();
        clearTable();
        for (int r = 0; r < matrix.getRows(); r++){
            for (int c = 0; c < matrix.getColumns(); c++){
                table.setValueAt(
                        matrix.getMatrixItem(r,c),
                        startRow + r,
                        startCol + c
                );
            }
        }
        highlight(startRow, startCol, matrix.getRows(), matrix.getColumns());
        MatrixRepository.setCurrrentMatrix(matrix.getName());
    }

}
