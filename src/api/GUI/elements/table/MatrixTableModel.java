package api.GUI.elements.table;

import javax.swing.table.DefaultTableModel;

public class MatrixTableModel {
    private final int tableWidth;
    private final int tableHeight;
    private final int[] sellSize;
    private final int columnAmonut;
    private final int rowAmonut;

    public MatrixTableModel(int tableWidth, int tableHeight, int[] sellSize){
        this.tableWidth = tableWidth;
        this.tableHeight = tableHeight;
        this.sellSize = sellSize;
        this.columnAmonut = tableWidth / sellSize[0] + 1;
        this.rowAmonut = tableHeight / sellSize[1] + 1;
    }

    public DefaultTableModel generateModel(){
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < columnAmonut; i++){
            model.addColumn("a"+i);
        }
        for (int i = 0; i < rowAmonut; i++){
            String[] blankRow = new String[columnAmonut];
            for  (int j = 0; j < columnAmonut; j++){
                blankRow[j] = "";
            }
            model.addRow(blankRow);
        }

        return model;
    }
}
