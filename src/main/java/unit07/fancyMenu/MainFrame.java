package unit07.fancyMenu;

import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame(){
        super("Fancy Menu");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setJMenuBar(new FancyBar());
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
