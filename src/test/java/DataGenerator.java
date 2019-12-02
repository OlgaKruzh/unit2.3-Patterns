import java.time.LocalDate;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class DataGenerator {
    public static void main(String[] args) {

       // class DataGenerator () {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            Faker faker = new Faker(new Locale("ru"));
            String city = faker.address().cityName();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            LocalDate dateFirst = LocalDate.now();
            dateFirst = dateFirst.plusDays(4);
            String dateFirstInput = dateFirst.format(formatter);
            LocalDate dateLast = dateFirst.plusDays(7);
            String dateLastInput = dateLast.format(formatter);

            // System.out.println(name);
            // System.out.println(dateFirstInput);
            // System.out.println(dateLastInput);
        }

    }




