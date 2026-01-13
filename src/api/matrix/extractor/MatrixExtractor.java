package api.matrix.extractor;

import api.GUI.ApplicationMain;
import api.exceptions.EmptyStartCell;
import api.exceptions.InvalidTableNumber;
import api.exceptions.MatrixNotFound;
import api.matrix.domain.Matrix;

import javax.swing.*;

public class MatrixExtractor {

    private MatrixExtractor() {}

    public static Matrix extractMatrix(JTable table, int startRow, int startColumn, String name) throws EmptyStartCell, InvalidTableNumber {
        int maxRow = table.getRowCount();
        int maxColumn = table.getColumnCount();


        if (isEmpty(table, startRow, startColumn)){
            throw new EmptyStartCell("Start cell is empty");
        }

        int height = 0;
        int width = 0;
        while(startColumn + width < maxRow && !isEmpty(table, startRow, startColumn + width )){
            width++;
        };
        while(startRow + height < maxRow && !isEmpty(table, startRow + height, startColumn )){
            height++;
        };

        Matrix matrix = new Matrix(height, width, name);


        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                Object value = table.getValueAt(startRow + r, startColumn + c);
                try{
                    double number = Double.parseDouble(value.toString());
                    matrix.setMatrixItem(r, c, number);
                }catch(NumberFormatException e){
                    throw new InvalidTableNumber(String.format("Invalid number at table [ %d, %,d]", startRow + r, startColumn + c));
                }
            }
        }
        ApplicationMain.tableContainer.highlight(startRow, startColumn, height, width);
        return matrix;
    }

    public static Matrix findFirstly(JTable table, String name) throws EmptyStartCell, InvalidTableNumber, MatrixNotFound {
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                if(!isEmpty(table, r, c)){
                    return extractMatrix(table, r, c, name);
                }
            }
        }
        throw new MatrixNotFound();
    }

    private static boolean isEmpty(JTable table, int row, int column){
        Object value = table.getValueAt(row, column);
        return value == null || value.toString().isEmpty();

    }

}
