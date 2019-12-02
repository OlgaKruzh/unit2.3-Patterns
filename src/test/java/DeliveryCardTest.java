import java.time.LocalDate;
 import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

    class DeliveryCardTest {
        @Test
        void shouldSubmitRequest() throws Exception {

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

            open("http://localhost:9999");
            $("[placeholder='Город']").setValue(city);
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.DELETE));
            $("[placeholder = 'Дата встречи']").setValue(dateFirstInput);
            $("button").submit();
            $("[name = 'name']").setValue(name);
            $("[name = 'phone']").setValue(phone);
            $("[class='checkbox__box']").click();
            $$("[class='button__text']").find(exactText("Запланировать")).click();
            $(withText("Успешно")).waitUntil(visible, 15000);

            $("[placeholder = 'Город']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[placeholder = 'Город']").sendKeys(Keys.chord(Keys.DELETE));
            $("[name = 'name']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[name = 'name']").sendKeys(Keys.chord(Keys.DELETE));
            $("[name = 'phone']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[name = 'phone']").sendKeys(Keys.chord(Keys.DELETE));
            $("[placeholder='Город']").setValue(city);
            $("[name = 'name']").setValue(name);
            $("[name = 'phone']").setValue(phone);
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.DELETE));
            $("[placeholder = 'Дата встречи']").setValue(dateLastInput);
         //   $("[class='checkbox__box']").click();
            $$("[class='button__text']").find(exactText("Запланировать")).click();
            $(withText("Необходимо подтверждение")).waitUntil(visible, 15000);
            $$("[class='button__text']").find(exactText("Перепланировать")).click();
            $(withText("Успешно")).waitUntil(visible, 15000);

        }
    }
