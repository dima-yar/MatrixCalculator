package api.GUI.elements.buttons;

import api.GUI.ApplicationMain;
import api.GUI.elements.dialogs.SelectMatrixDialog;
import api.matrix.domain.Matrix;
import api.matrix.repository.MatrixRepository;

import java.awt.event.ActionListener;

public class SelectMatrixButton extends ButtonStyled {
    public SelectMatrixButton() {
        super("Select Matrix");
        this.addActionListener(e -> {
            try {
                onClick();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void onClick() throws Exception {
        String selectedMatrix = SelectMatrixDialog.showDialog(ApplicationMain.frame);
        if (selectedMatrix == null){
            return;
        }
        Matrix matrix = MatrixRepository.getMatrix(selectedMatrix);
        ApplicationMain.tableContainer.printMatrix(matrix, 0, 0);
    }
}
