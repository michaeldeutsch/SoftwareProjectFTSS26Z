import unit02.readFromFile.Hotel;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {


    static void main() throws IOException {

        // data - beginn

        Hotel hotel1 = new Hotel(1,"Sacher",1010  );
        Hotel hotel2 = new Hotel(2,"One",1010  );
        Hotel hotel3 = new Hotel(3,"H2",1010  );

        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(new Hotel(4,"H3",1010  ));
        // in place but wrong format, java it is, csv we need
        // data - end


        writeHotelsAsCSV(hotels, false);
        writeHotelsAsCSV(hotels, false);
        writeHotelsAsCSV(hotels, false);



    }

    private static void writeHotelsAsCSV(ArrayList<Hotel> hotels, boolean append) throws IOException {
        ArrayList<String> hotels_in_csv = new ArrayList<>();


        for(Hotel h : hotels){
            hotels_in_csv.add(h.toCSV());
        }
        String someContent = LocalDate.now().toString();
        someContent = someContent + LocalTime.now().getHour() + LocalDateTime.now().getSecond();

        Path path = Path.of("output/backup" + someContent + ".txt");       // structure / place

        Files.write(path,  // Path
                hotels_in_csv,  // data
                StandardCharsets.UTF_8,
                append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE
                );

        JOptionPane.showMessageDialog(null, "File was written sucessfully");
    }
}
