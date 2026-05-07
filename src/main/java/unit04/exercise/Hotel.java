package unit04.exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private int id;
    private String name;
    private int zipCode;

    public String toSQL() {
        return "INSERT INTO hotel (id, name, zip_code) VALUES (%d, '%s', %d)".formatted(id, name, zipCode);    }
}
