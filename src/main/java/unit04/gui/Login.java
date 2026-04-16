package unit04.gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    static int MAX_ATTEMPTS = 3;
    static int ATTEMPTS = 0;

    public Login(){
        setTitle("Welcome to my first GUI program");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2,2,10, 10 ));
        JButton loginButton = new JButton("Login");
        //loginButton.setEnabled(false);

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

         panel.add(new JLabel("Username:"));
         panel.add(username);
        panel.add(new JLabel("Username:"));
        panel.add(password);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // cheat
         add(panel,BorderLayout.CENTER);
         add(loginButton,BorderLayout.SOUTH);

         loginButton.addActionListener(e -> {

             ATTEMPTS++;

             if(ATTEMPTS > MAX_ATTEMPTS){
                 JOptionPane.showMessageDialog(this, "Too many attempts");
                 System.exit(0);
                 return;
             }

             if(username.getText().isBlank()){
                 JOptionPane.showMessageDialog(this, "Please enter a username");
                 return;

             }

            // JOptionPane.showMessageDialog(this, "Welcome " + username.getText());
             // junior junior -> juniorWindow
             // senior senior -> seniorWindow
             // admin admin ->  AdminWindow

             if(username.getText().equals("junior") && password.getText().equals("junior")){
                 new JuniorWindow().setVisible(true);
                 dispose();
                 return;
             }else if(username.getText().equals("senior") && password.getText().equals("senior")){
                 new SeniorWindow().setVisible(true);
             } else if (username.getText().equals("admin") && password.getText().equals("admin")) {
                 new AdminWindow().setVisible(true);
             }
                else{
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
             }
         });

        username.addCaretListener(e -> {
            System.out.println("something was entered");
        });


    }


}
