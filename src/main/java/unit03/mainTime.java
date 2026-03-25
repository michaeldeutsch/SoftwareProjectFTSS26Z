package unit03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class mainTime {


    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toLocalDate());

        System.out.println("Hello World");
        LocalDate date = LocalDate.now();
        System.out.println(date.getYear());

    }
}
