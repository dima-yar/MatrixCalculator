package api.GUI.elements.sideBar;

import api.GUI.elements.buttons.*;
import api.GUI.elements.buttons.calculationbuttons.*;
import api.GUI.styles.Margin;
import api.GUI.styles.Padding;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SideBar extends JPanel {

    private final int thisWidth;
    private final int thisHeight;
    private final Padding padding;
    private final Margin margin;
    public JLabel currentMatrix =  new JLabel();

    public SideBar(int parentWidth, int parentHeight, int appBarHeight, int thisWidth, Padding padding) {
        margin = new Margin(parentWidth - thisWidth, appBarHeight);
        this.thisHeight = parentHeight -  appBarHeight;
        this.thisWidth = thisWidth;
        this.padding = padding;

    }

    public void setCurrentMatrix(String currentMatrix) {
        this.currentMatrix.setText("Current Matrix: " + currentMatrix);
    }

    public void setUp() {


        this.setBounds(margin.X(), margin.Y(), thisWidth, thisHeight);
        this.setBackground(new Color(149, 135, 245));
        //this.setBorder(BorderFactory.createLineBorder(new Color(149, 131, 241)));
        this.setLayout(null);



        int buttonWidth = ((thisWidth) / 2) - (2  * padding.X());
        int buttonHeight = 56;


        //Bottom Panel
        JPanel statusPanel = new JPanel();
        int statusPanelHeight= this.getHeight() * 30 / 100;

        statusPanel.setBounds(0, this.getHeight() - statusPanelHeight, this.getWidth(), statusPanelHeight);
        statusPanel.setBackground(new Color(149, 135, 245));
        statusPanel.setLayout(null);
        statusPanel.setBorder(BorderFactory.createLineBorder( new Color(109, 95, 205), 3));

        //Select Matrix Button
        SelectMatrixButton selectMatrix = new SelectMatrixButton();
        selectMatrix.setBounds(padding.X(), padding.Y(), 2 * buttonWidth, buttonHeight);

        //CurrentMatrix state
        currentMatrix.setText("Select Matrix: No selected matrices");

        currentMatrix.setBounds(padding.X(), 3 * padding.Y(), statusPanel.getWidth() - 2 * padding.X(), statusPanel.getHeight() -  selectMatrix.getHeight() - 3 * padding.Y());
        currentMatrix.setFont(new Font("Arial", Font.PLAIN, 25));
        statusPanel.add(selectMatrix);
        statusPanel.add(currentMatrix);

        this.add(statusPanel);

        //sideBar Butons
        List<ButtonStyled> sideBarButtons = new ArrayList<>(List.of());

        //Add Button
        AddButton addButton = new AddButton();
        addButton.setBounds(padding.X(), padding.Y(), buttonWidth, buttonHeight);
        sideBarButtons.add(addButton);


        //Subtract Button
        SubtractButton subtractButton = new SubtractButton();
        subtractButton.setBounds(padding.X() + buttonWidth, padding.Y(), buttonWidth, buttonHeight);
        sideBarButtons.add(subtractButton);

        //Multiply Button
        MultiplyButton multiplyButton = new MultiplyButton();
        multiplyButton.setBounds(padding.X(), padding.Y() + buttonHeight + 5, buttonWidth, buttonHeight);

        sideBarButtons.add(multiplyButton);

        //Determinant Button
        DeterminantButton determinantButton = new DeterminantButton();
        determinantButton.setBounds(padding.X()  +buttonWidth, padding.Y() + buttonHeight + 5, buttonWidth, buttonHeight);

        sideBarButtons.add(determinantButton);

        //Transpose Button
        TransposeButton transposeButton = new TransposeButton();
        transposeButton.setBounds(padding.X(), padding.Y() + 2 * (buttonHeight + 5), buttonWidth * 2, buttonHeight);

        sideBarButtons.add(transposeButton);

        //Save Button
        SaveButton saveButton = new SaveButton();
        saveButton.setBounds(
                padding.X(),
                this.getHeight() - statusPanelHeight - buttonHeight - padding.Y(),
                buttonWidth,
                buttonHeight);

        sideBarButtons.add(saveButton);

        //Delete Button
        DeleteButton deleteButton = new DeleteButton();
        deleteButton.setBounds(
                padding.X() + buttonWidth,
                this.getHeight() - statusPanelHeight - buttonHeight - padding.Y(),
                buttonWidth,
                buttonHeight);

        sideBarButtons.add(deleteButton);


        //
        ClearButton clearButton = new ClearButton();
        clearButton.setBounds(
                padding.X(),
                this.getHeight() - statusPanelHeight - 2 * buttonHeight - 2 * padding.Y(),
                buttonWidth * 2,
                buttonHeight);

        sideBarButtons.add(clearButton);

        //Initializing Buttons
        for(JButton button : sideBarButtons){
            this.add(button);
        }

    }

}
