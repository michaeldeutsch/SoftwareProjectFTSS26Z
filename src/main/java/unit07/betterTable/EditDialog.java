package unit07.betterTable;


import javax.swing.*;
import java.awt.*;

public class EditDialog extends JDialog {

    public EditDialog(Frame owner, Hotel hotel, Runnable onSave) {
        super(owner, "Hotel bearbeiten", true);

        setLayout(new GridLayout(5, 2, 5, 5));
        setSize(320, 200);
        setLocationRelativeTo(owner);

        JTextField idField = new JTextField(String.valueOf(hotel.getId()));
        JTextField nameField = new JTextField(hotel.getName());
        JTextField adresseField = new JTextField(hotel.getAdresse());
        JTextField kategorieField = new JTextField(hotel.getKategorie());
        JButton button = new JButton("Change");

        idField.setEditable(false);   // ID nur anzeigen, nicht bearbeiten
        button.setEnabled(false);     // erst aktiv, wenn sich wirklich etwas ändert

        add(new JLabel("ID:")); add(idField);
        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Adresse:")); add(adresseField);
        add(new JLabel("Kategorie:")); add(kategorieField);
        add(new JLabel()); add(button);


        SimpleDocumentListener listener = new SimpleDocumentListener() {
            @Override
            public void update() {
                boolean changed =
                        !nameField.getText().equals(hotel.getName()) ||
                        !adresseField.getText().equals(hotel.getAdresse()) ||
                        !kategorieField.getText().equals(hotel.getKategorie());

                // Button nur im Bearbeitungsmodus aktivieren
                if (button.getText().equals("Change")) {
                    button.setEnabled(changed);
                }
            }
        };

        // gleiche Logik an alle editierbaren Felder hängen
        nameField.getDocument().addDocumentListener(listener);
        adresseField.getDocument().addDocumentListener(listener);
        kategorieField.getDocument().addDocumentListener(listener);

        button.addActionListener(e -> {
            if (button.getText().equals("Change")) {
                // geänderte Werte ins Objekt zurückschreiben
                hotel.setName(nameField.getText());
                hotel.setAdresse(adresseField.getText());
                hotel.setKategorie(kategorieField.getText());

                onSave.run();

                // nach dem Speichern in den Schließen-Modus wechseln
                button.setText("Schließen");
                button.setEnabled(true);
            } else {
                dispose();
            }
        });
    }
}
