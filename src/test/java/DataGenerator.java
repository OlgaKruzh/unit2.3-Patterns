import java.time.LocalDate;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class DataGenerator {
    public static void main(String[] args) {

 //    class DataGenerator() {
            Faker faker = new Faker(new Locale("ru"));
            String city = faker.address().cityName();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            LocalDate dateFirst = LocalDate.now();
            dateFirst = dateFirst.plusDays(4);
            LocalDate dateLast = dateFirst.plusDays(7);


            System.out.println(city);
            System.out.println(name);
            System.out.println(phone);
            System.out.println(dateFirst);
            System.out.println(dateLast);
        }

    }



