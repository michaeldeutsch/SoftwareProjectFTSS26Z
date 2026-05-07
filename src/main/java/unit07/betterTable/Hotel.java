package unit07.betterTable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hotel {
    private int id;
    private String name;
    private String adresse;
    private String kategorie;
}
