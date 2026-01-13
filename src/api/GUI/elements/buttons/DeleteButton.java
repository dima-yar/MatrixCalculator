package api.GUI.elements.buttons;

import api.GUI.ApplicationMain;
import api.matrix.repository.MatrixRepository;

import javax.swing.*;

public class DeleteButton extends ButtonStyled {
    public DeleteButton() {
        super("Del");
        this.addActionListener(e -> onClick());
    }

    private void onClick() {
        if(MatrixRepository.currentMatrix != null) {
            int toDelete = JOptionPane.showConfirmDialog(null, String.format("Are you sure you want to delete %s matrix?", MatrixRepository.currentMatrix));
            if (toDelete == JOptionPane.YES_OPTION) {
                MatrixRepository.deleteMatrix(MatrixRepository.currentMatrix);
                MatrixRepository.currentMatrix = null;
                ApplicationMain.frame.sideBar.setCurrentMatrix(MatrixRepository.currentMatrix);
                ApplicationMain.tableContainer.clearTable();
                JOptionPane.showMessageDialog(ApplicationMain.frame, "Matrix deleted successfully");
            }
            else{
                JOptionPane.showMessageDialog(ApplicationMain.frame, "Deleting operation cancelled.");
            }

        }
        else{
            JOptionPane.showMessageDialog(ApplicationMain.frame, "No current matrix found");
        }
    }
}
