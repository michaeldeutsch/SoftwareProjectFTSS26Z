package unit01;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    int id;
    String name;
    String email;
    String password;
    String phone;
    String address;
    String city;
    String country;
    String zip;
    String asdasfd;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
