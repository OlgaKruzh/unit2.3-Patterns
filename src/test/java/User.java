import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Locale;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;

@Data
@AllArgsConstructor
public class User {
     String city = "";
     String name = "";
     String phone = "";

    public User() { }

    @BeforeEach
    public void setUpAll() {
        Faker faker = new Faker(new Locale("ru"));
        String city = faker.address().cityName();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        this.city = city;
        this.name = name;
        this.phone = phone;
        }
}











