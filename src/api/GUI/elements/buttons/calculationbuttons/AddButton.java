package api.GUI.elements.buttons.calculationbuttons;

import api.GUI.ApplicationMain;
import api.GUI.elements.buttons.ButtonStyled;
import api.matrix.calculations.MatrixCalculations;
import api.matrix.domain.Matrix;

import javax.swing.*;

public class AddButton extends ButtonStyled {
    public AddButton() {
        super("Add");
        this.addActionListener(e -> {
            try {
                onClick();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void onClick() throws Exception {
        try
        {
            Matrix[] matrices = MatrixCalculations.prepareMatrices();
            if (matrices == null) return;


            Matrix C = MatrixCalculations.addMatrices(matrices[0], matrices[1]);

            MatrixCalculations.addNewMatrixToRepository(C);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(ApplicationMain.frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
