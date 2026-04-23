package unit05.tableIntro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TableExample extends JFrame {

    TableExample(){
        super("Table Example");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        fillTable(model);



    }

    private static void fillTable(DefaultTableModel model) {
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");

        // static
        model.addRow(new Object[]{"Hans", 11, "Male"});
        model.addRow(new Object[]{"Hans", 11, "Male"});
        model.addRow(new Object[]{"Hans", 11, "Male"});
        model.addRow(new Object[]{"Hans", 11, "Male"});

        //dynamic
        ArrayList<String> names = new ArrayList<>();
        names.add("asdfasfd");
        names.add("ff");
        names.add("ee");
        names.add("tt");
        names.add("hh");

        for(String name : names){
            model.addRow(new Object[]{name, 11, "Male"});
        }





    }
}
