package api.matrix.domain;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private final int rows;
    private final int columns;
    private double[][] data;
    private final String name;


    public Matrix(int rows, int columns, String name) {
        this.rows = rows;
        this.columns = columns;
        this.name = name;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] source, String name) {
        this.rows = source.length;
        this.columns = source[0].length;
        this.name = name;
        this.data = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(source[i], 0, this.data[i], 0, columns);
        }
    }
    public String getName(){
        return name;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public double[][] getMatrix(){
        return data;
    }
    public double getMatrixItem(int row, int column){
        return  data[row][column];
    }
    public void setMatrixItem(int row, int column, double value){
        data[row][column] = value;
    }
    public double[][] toArray(){
        double[][] copy = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, copy[i], 0, columns);
        }
        return data;
    }
}
