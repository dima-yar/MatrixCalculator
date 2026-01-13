package api.GUI.elements.buttons;

import api.GUI.ApplicationMain;
import api.matrix.repository.MatrixRepository;

public class ClearButton extends ButtonStyled {
    public ClearButton() {
        super("Clear");
        this.addActionListener( e -> {
            try {
                onClick();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void onClick() throws Exception {
        ApplicationMain.tableContainer.clearTable();
        MatrixRepository.setCurrrentMatrix(null);
    }
}
