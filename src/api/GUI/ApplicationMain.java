package api.GUI;

import api.GUI.elements.frame.Frame;
import api.GUI.elements.table.Table;

import javax.swing.*;

public class ApplicationMain {
    public static Frame frame;
    public static Table tableContainer;
    public static JTable table;
    public static String currentMatrix;

    public ApplicationMain(){
        frame = new Frame();
        table = frame.getTable();
        tableContainer = frame.table;
    }

    public void Start(){
        frame.Show();
    }
    public static Frame getFrame(){
        return frame;
    }
}
