package unit07.betterTable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HotelTableModel extends AbstractTableModel {

    private final List<Hotel> hotels;
    private final String[] cols = {"ID", "Name", "Adresse", "Kategorie"};

    public HotelTableModel(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public int getRowCount() {
        return hotels.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int row, int col) {
        // zentrale Zuordnung: Tabelle -> Objekt
        Hotel h = hotels.get(row);
        return switch (col) {
            case 0 -> h.getId();
            case 1 -> h.getName();
            case 2 -> h.getAdresse();
            case 3 -> h.getKategorie();
            default -> null;
        };
    }

    public Hotel getHotelAt(int row) {
        // Zugriff auf das gewählte Objekt
        return hotels.get(row);
    }

    public void refreshRow(int row) {
        // JTable über geänderte Daten informieren
        fireTableRowsUpdated(row, row);

    }
}
