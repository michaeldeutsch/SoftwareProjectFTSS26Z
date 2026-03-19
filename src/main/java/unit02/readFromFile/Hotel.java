package unit02.readFromFile;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hotel {
    int id;
    String name;
    int post_code;

    public String toCSV() {
        return id+","+name+","+post_code;
    }
}
