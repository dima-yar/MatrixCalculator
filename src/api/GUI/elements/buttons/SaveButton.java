package api.GUI.elements.buttons;

import api.GUI.ApplicationMain;
import api.exceptions.EmptyStartCell;
import api.exceptions.InvalidTableNumber;
import api.exceptions.MatrixNotFound;
import api.matrix.extractor.MatrixExtractor;
import api.matrix.repository.MatrixRepository;

import javax.swing.*;

public class SaveButton extends ButtonStyled {
    public SaveButton() {
        super("Save");
        this.addActionListener(e -> {
            try {
                onClick();
            } catch (MatrixNotFound ex) {
                throw new RuntimeException(ex);
            } catch (EmptyStartCell ex) {
                throw new RuntimeException(ex);
            } catch (InvalidTableNumber ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    private void onClick() throws MatrixNotFound, EmptyStartCell, InvalidTableNumber {
        try{
            if (MatrixRepository.currentMatrix == null) {
                String name = JOptionPane.showInputDialog(ApplicationMain.frame, "Please enter matrix name", "SaveMatrix", JOptionPane.QUESTION_MESSAGE);
                if (name == null) throw new Exception("Matrix name is empty");
                MatrixRepository.putMatrix(MatrixExtractor.findFirstly(ApplicationMain.table, name.trim()));
                MatrixRepository.setCurrrentMatrix(name);
                JOptionPane.showMessageDialog(ApplicationMain.frame, String.format("Successfully saved matrix %s", name), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                MatrixRepository.putMatrix(MatrixExtractor.findFirstly(ApplicationMain.table, MatrixRepository.currentMatrix));
                JOptionPane.showMessageDialog(ApplicationMain.frame, String.format("Successfully saved matrix %s", MatrixRepository.currentMatrix), "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        catch(Exception ex){
            ApplicationMain.tableContainer.clearHightlight();
            JOptionPane.showMessageDialog(ApplicationMain.frame, ex.getMessage());
        }


    }
}
