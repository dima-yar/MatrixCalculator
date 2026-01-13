package api.GUI.elements.buttons.calculationbuttons;

import api.GUI.ApplicationMain;
import api.GUI.elements.buttons.ButtonStyled;
import api.matrix.calculations.MatrixCalculations;
import api.matrix.domain.Matrix;

import javax.swing.*;

public class MultiplyButton extends ButtonStyled {
    public MultiplyButton() {
        super("Mult");
        this.addActionListener(e -> onClick());
    }

    private void onClick() {
        try
        {

            Matrix[] matrices = MatrixCalculations.prepareMatrices();
            if (matrices == null) return;

            Matrix C = MatrixCalculations.multiplyMatrices(matrices[0], matrices[1]);

            MatrixCalculations.addNewMatrixToRepository(C);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(ApplicationMain.frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
