package api.GUI.elements.buttons.calculationbuttons;

import api.GUI.ApplicationMain;
import api.GUI.elements.buttons.ButtonStyled;
import api.matrix.calculations.MatrixCalculations;
import api.matrix.domain.Matrix;

import javax.swing.*;

public class TransposeButton extends ButtonStyled {
    public TransposeButton() {
        super("Transpose");
        this.addActionListener(e -> onClick());
    }

    private void onClick() {
        try {
            Matrix matrix = MatrixCalculations.prepareMatrix();
            if (matrix == null) return;

            Matrix C = MatrixCalculations.transposeMatrix(matrix);

            MatrixCalculations.addNewMatrixToRepository(C);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(ApplicationMain.frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
