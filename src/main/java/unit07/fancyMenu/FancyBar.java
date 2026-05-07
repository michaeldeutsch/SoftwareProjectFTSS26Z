package unit07.fancyMenu;

import javax.swing.*;

public class FancyBar extends JMenuBar {

    FancyBar(){
        super();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu Help = new JMenu("Help");

        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Open As");
        JMenuItem exit = new JMenuItem("Exit");

        file.add(save);
        file.add(saveAs);
        file.add(exit);

        add(file);
        add(edit);
        add(Help);

        save.addActionListener(e -> JOptionPane.showMessageDialog(this, "Save action"));
        exit.addActionListener(e -> System.exit(0));


    }
}
