package api.GUI.elements.buttons;

import api.exceptions.EmptyStartCell;
import api.exceptions.InvalidTableNumber;
import api.exceptions.MatrixNotFound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonStyled extends JButton {

    public ButtonStyled(String text) {
        super(text);
        this.setBackground(new Color(42, 50, 75));
        this.setForeground(new Color(252, 197, 159));
        this.setFont(new Font("Agency FB", Font.BOLD, 26));
    }
}
