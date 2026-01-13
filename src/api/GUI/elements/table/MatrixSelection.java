package api.GUI.elements.table;

public class MatrixSelection {
    public int rowStart = -1;
    public int rows;
    public int colStart = -1;
    public int columns;

    public boolean isActive(){
        return rowStart != -1 &&  colStart != -1;
    }
    public boolean contains(int row, int col){
        if (!isActive()) return false;
        return row >= rowStart && row < rowStart + rows
                && col >= colStart && col < colStart + columns;
    }
}
