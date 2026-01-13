package api.GUI.elements.frame;

import api.GUI.elements.appBar.AppBar;
import api.GUI.elements.sideBar.SideBar;
import api.GUI.elements.table.MatrixTableModel;
import api.GUI.elements.table.Table;
import api.GUI.styles.Padding;

import javax.swing.*;

public class Frame extends JFrame {

    public final int frameWidth = 1280;
    public final int frameHeight = 766;

    //Application Bar
    public final int appBarHeight = 30;
    public final Padding appBarPadding = new Padding(5);
    private AppBar appBar = new AppBar(frameWidth, appBarHeight, appBarPadding);

    //Side Bar
    public final int sideBarWidth = 340;
    public final Padding sideBarPadding = new Padding(10, 20);
    public final SideBar sideBar = new  SideBar(frameWidth, frameHeight, appBarHeight, sideBarWidth, sideBarPadding);

    //Table
    public final int tableWidth = frameWidth - sideBarWidth;
    public final int tableHeight = frameHeight - appBarHeight;
    public final int[] sellSize = {40, 40};
    public final MatrixTableModel  tableModel = new MatrixTableModel(tableWidth, tableHeight, sellSize);
    public Table table = new Table(tableModel.generateModel(), tableWidth, tableHeight, appBarHeight, sellSize);

    public Frame() {
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        appBar.setUp();
        sideBar.setUp();
        table.setUp();

        this.add(appBar);
        this.add(sideBar);
        this.add(table);
    }

    public void Show(){
        this.setVisible(true);
    }

    public JTable getTable(){
        return table.getTable();
    }
}
