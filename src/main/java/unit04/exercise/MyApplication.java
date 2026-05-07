package unit04.exercise;

import java.io.IOException;

public class MyApplication {


    public static void main(String[] args) throws IOException {


            HotelUtility.writeHotelsAsSQL(false);


            HotelUtility.writeHotelsAsSQL(true);

    }
}
