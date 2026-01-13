package api.matrix.calculations;

import api.GUI.ApplicationMain;
import api.GUI.elements.dialogs.SelectMatrixDialog;
import api.exceptions.EmptyMatrixRepository;
import api.exceptions.MatrixNotFound;
import api.matrix.domain.Matrix;
import api.matrix.repository.MatrixRepository;

import javax.swing.*;

public class MatrixCalculations {

    public static Matrix addMatrices(Matrix m1, Matrix m2) {

        if(m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()) {
            throw new IllegalArgumentException("Matrix dimensions do not match");
        }
        Matrix result = new Matrix(m1.getRows(), m1.getColumns(), String.format("matrix[%s]+matrix[%s]", m1.getName(), m2.getName()));


        for (int i = 0; i< m1.getRows(); i++) {
            for (int j = 0; j< m1.getColumns(); j++) {
                result.setMatrixItem(i, j, m1.getMatrixItem(i, j) +  m2.getMatrixItem(i, j));
            }
        }

        return result;
    }
    public static Matrix subtractMatrices(Matrix m1, Matrix m2) {
        if(m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()) {
            throw new IllegalArgumentException("Matrix dimensions do not match");
        }
        Matrix result = new Matrix(m1.getRows(), m1.getColumns(), String.format("matrix[%s]-matrix[%s]", m1.getName(), m2.getName()));


        for (int i = 0; i< m1.getRows(); i++) {
            for (int j = 0; j< m1.getColumns(); j++) {
                result.setMatrixItem(i, j, m1.getMatrixItem(i, j) -  m2.getMatrixItem(i, j));
            }
        }

        return result;
    }
    public static Matrix multiplyMatrices(Matrix m1, Matrix m2) {
        if(m1.getColumns() != m2.getRows()){
            throw new IllegalArgumentException("Number of columns of A must be equal to number of rows of B");
        }
        Matrix result = new Matrix(m1.getRows(), m2.getColumns(), String.format("matrix[%s]*matrix[%s]", m1.getName(), m2.getName()));

        for (int r = 0; r< m1.getRows(); r++) {
            for (int c = 0; c< m2.getColumns(); c++) {
                double sum = 0;
                for (int c1 = 0; c1< m1.getColumns(); c1++) {
                    sum += m1.getMatrixItem(r, c1) * m2.getMatrixItem(c1, c);
                }
                result.setMatrixItem(r, c, sum);
            }
        }

        return result;
    }
    public static double findDeterminant(Matrix matrix) {
        if (matrix.getRows() == 1) return matrix.getMatrixItem(0, 0);
        if (matrix.getRows() == 2) return matrix.getMatrixItem(0, 0)*matrix.getMatrixItem(1, 1) + matrix.getMatrixItem(0, 1)*matrix.getMatrixItem(1, 0);

        double result = 0;
        for (int c = 0; c< matrix.getColumns(); c++) {
            result += ((c % 2 == 0 ? 1 : -1) * matrix.getMatrixItem(0,c) * MatrixCalculations.findDeterminant(subMatrix(matrix, 0, c)));
        }
        return result;
    }
    public static Matrix transposeMatrix(Matrix matrix) {
        Matrix result = new Matrix(matrix.getColumns(), matrix.getRows(),  String.format("Transposed matrix[%s]", matrix.getName()));

        for (int r = 0; r< matrix.getRows(); r++) {
            for (int c = 0; c< matrix.getColumns(); c++) {
                result.setMatrixItem(c, r, matrix.getMatrixItem(r, c));
            }
        }
        return result;
    }

    public static Matrix subMatrix(Matrix matrix, int excludinRow, int excludinColumn) {
        Matrix result = new Matrix(matrix.getRows() - 1, matrix.getColumns() - 1, "submatrix");
        int r2 = 0;

        for (int r = 0; r< matrix.getRows(); r++) {
            if (r == excludinRow) continue;
            int c2 = 0;
            for (int c = 0; c< matrix.getColumns(); c++) {
                if(c == excludinColumn) continue;
                result.setMatrixItem(r2, c2, matrix.getMatrixItem(r, c2));
                c2++;
            }
            r2++;
        }
        return result;
    }

    public static Matrix[] prepareMatrices() throws EmptyMatrixRepository {
        if (MatrixRepository.getNames().isEmpty()) {
            throw new EmptyMatrixRepository();
        }
        JOptionPane.showMessageDialog(ApplicationMain.frame, "Select two matrices to calculate.", "Addition", JOptionPane.INFORMATION_MESSAGE);

        String matrix1 = SelectMatrixDialog.showDialog(ApplicationMain.frame, "Select first matrix");
        if (matrix1 == null) {
            showCalculationCancellation();
             return null;
        }
        String matrix2 = SelectMatrixDialog.showDialog(ApplicationMain.frame, "Select second matrix");
        if (matrix2 == null) {
            showCalculationCancellation();
            return null;
        }

        Matrix A = MatrixRepository.getMatrix(matrix1);
        Matrix B = MatrixRepository.getMatrix(matrix2);

        return new Matrix[]{A, B};
    }

    public static Matrix prepareMatrix() throws EmptyMatrixRepository {
        if (MatrixRepository.getNames().isEmpty()) {
            throw new EmptyMatrixRepository();
        }
        JOptionPane.showMessageDialog(null, "Select one matrix to calculate.", "Calculation", JOptionPane.INFORMATION_MESSAGE);
        String matrix1 = SelectMatrixDialog.showDialog(ApplicationMain.frame, "Select matrix");
        if (matrix1 == null) {
            showCalculationCancellation();
            return null;
        }

        return MatrixRepository.getMatrix(matrix1);
    }

    public static void addNewMatrixToRepository(Matrix C){
        String matrix3 = JOptionPane.showInputDialog(ApplicationMain.frame, "Name new matrix: (leave empty to auto name)", "Result Name", JOptionPane.QUESTION_MESSAGE);

        if (matrix3 == null || matrix3.trim().isEmpty()) {
            matrix3 = C.getName();
        }

        MatrixRepository.putMatrix(new Matrix(C.getMatrix(), matrix3));

        ApplicationMain.tableContainer.printMatrix(MatrixRepository.getMatrix(matrix3), 0, 0);

    }

    private static void showCalculationCancellation(){
        JOptionPane.showMessageDialog(null, "Calculation cancelled.", "Addition", JOptionPane.INFORMATION_MESSAGE);
    }
}
