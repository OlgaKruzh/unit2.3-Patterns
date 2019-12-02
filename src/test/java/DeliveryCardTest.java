import java.time.LocalDate;

    import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

    class DeliveryCardTest {
        @Test
        void shouldSubmitRequest(){
            open("http://localhost:9999");
            $("[placeholder='Город']").setValue("Новосибирск");
            LocalDate date = LocalDate.now();
            date = date.plusDays(10);
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.DELETE));
            int day = date.getDayOfMonth();
            $("[placeholder = 'Дата встречи']").setValue(String.valueOf(day));
            int month = date.getMonthValue();
            $("[placeholder = 'Дата встречи']").setValue(String.valueOf(month));
            int year = date.getYear();
            $("[placeholder = 'Дата встречи']").setValue(String.valueOf(year));
            $("button").submit();
            $("[name = 'name']").setValue("Герман Греф");
            $("[name = 'phone']").setValue("+12345678911");
            $("[class='checkbox__box']").click();
            $$("[class=\"button__text\"]").find(exactText("Запланировать")).click();
          //  $(withText("Необходимо подтверждение")).waitUntil(visible, 15000);
        }
    }
