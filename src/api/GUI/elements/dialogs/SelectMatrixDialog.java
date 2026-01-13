package api.GUI.elements.dialogs;

import api.matrix.repository.MatrixRepository;

import javax.swing.*;

public class SelectMatrixDialog {
    public static String showDialog(JFrame parent){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String name : MatrixRepository.getNames()){
            model.addElement(name);
        }
        if(model.isEmpty()){
            JOptionPane.showMessageDialog(parent, "No matrices in repository", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        JList<String> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int result = JOptionPane.showConfirmDialog(
                parent,
                new JScrollPane(list),
                "Select Matrix",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if(result == JOptionPane.OK_OPTION){
            return list.getSelectedValue();
        }
        return null;



    }
    public static String showDialog(JFrame parent, String message){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String name : MatrixRepository.getNames()){
            model.addElement(name);
        }
        if(model.isEmpty()){
            JOptionPane.showMessageDialog(parent, "No matrices in repository", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        JList<String> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int result = JOptionPane.showConfirmDialog(
                parent,
                new JScrollPane(list),
                message,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if(result == JOptionPane.OK_OPTION){
            return list.getSelectedValue();
        }
        return null;



    }
}

