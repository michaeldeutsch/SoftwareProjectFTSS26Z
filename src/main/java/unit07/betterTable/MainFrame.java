package unit07.betterTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Hotels");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        var hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(1, "Hotel Wien", "Hauptstraße 1", "4*"));
        hotels.add(new Hotel(2, "Hotel Graz", "Parkweg 12", "3*"));
        hotels.add(new Hotel(3, "Hotel Linz", "Bahnhofstraße 7", "5*"));

        var model = new HotelTableModel(hotels);
        var table = new JTable(model);

        table.setDefaultEditor(Object.class, null); // disable direct editing

        add(new JScrollPane(table), BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    if (row >= 0) {
                        Hotel hotel = model.getHotelAt(row);
                        System.out.println(hotel);
                        new EditDialog(MainFrame.this,hotel,() -> model.refreshRow(row)).setVisible(true);
                    }
                }
            }
        });
    }


}
