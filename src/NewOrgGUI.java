import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewOrgGUI extends JFrame{
    private JTextField nameField;
    private JButton createButton;
    private JButton cancelButton;
    private JRadioButton channelRadioButton;
    private JRadioButton groupRadioButton;
    private JTextField descriptionField;
    private JPanel newOrgPanel;
    private JPanel downPanel;
    private JPanel downsecondPanel;

    public NewOrgGUI(Color darker,Color lighter,Client client) {

        setContentPane(newOrgPanel);
        newOrgPanel.setBackground(darker);
        nameField.setBackground(lighter);
        descriptionField.setBackground(lighter);
        downPanel.setBackground(lighter);
        downsecondPanel.setBackground(lighter);
        channelRadioButton.setBackground(lighter);
        groupRadioButton.setBackground(lighter);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(channelRadioButton.isSelected()){
                        client.getDataBase().save();
                    }
                    if(groupRadioButton.isSelected()){
                        client.getDataBase().save();
                    }
                }catch (Exception m){
                    System.out.println("ERROR ! "+m.getMessage());
                }
                dispose();
            }
        });
    }
}
