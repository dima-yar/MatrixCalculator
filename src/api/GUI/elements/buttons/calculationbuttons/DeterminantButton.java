package api.GUI.elements.buttons.calculationbuttons;

import api.GUI.ApplicationMain;
import api.GUI.elements.buttons.ButtonStyled;
import api.exceptions.EmptyMatrixRepository;
import api.exceptions.MatrixNotFound;
import api.matrix.calculations.MatrixCalculations;
import api.matrix.domain.Matrix;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class DeterminantButton extends ButtonStyled {
    public DeterminantButton() {
        super("Det");
        this.addActionListener(e -> {
            try {
                onClick();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(ApplicationMain.frame, ex.getMessage(), "No matrix in repository", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(ex);
            }
        });
    }
    private void onClick() throws EmptyMatrixRepository {
        try
        {
            Matrix matrix = MatrixCalculations.prepareMatrix();
            if (matrix == null) return;
            else if (matrix.getRows() != matrix.getColumns()) {
                JOptionPane.showMessageDialog(null, "Matrix should have same number of rows and columns");
                return;
            }

            double result = MatrixCalculations.findDeterminant(matrix);

            ApplicationMain.frame.table.printMatrix(matrix, 0, 0);
            JOptionPane.showMessageDialog(
                    ApplicationMain.frame,
                    String.format("Determinant of this matrix is %.2f", result),
                    "Determinant Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (EmptyMatrixRepository ex){
            JOptionPane.showMessageDialog(ApplicationMain.frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
