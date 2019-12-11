import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

class DeliveryDateChangingTest extends User{
    @Test
    void shouldSubmitRequest() throws Exception {
        User user = new User();
        open("http://localhost:9999");
        user.setUpAll();
        //можно еще формирование даты вынести в отдельный класс, но в данной задаче не вижу смыла
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateFirst = LocalDate.now();
        dateFirst = dateFirst.plusDays(4);
        String dateFirstInput = dateFirst.format(formatter);
        LocalDate dateLast = dateFirst.plusDays(7);
        String dateLastInput = dateLast.format(formatter);

        $("[placeholder='Город']").setValue(getCity());
        $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[placeholder = 'Дата встречи']").sendKeys(Keys.chord(Keys.DELETE));
        $("[placeholder = 'Дата встречи']").setValue(dateFirstInput);
        $("button").submit();
        $("[name = 'name']").setValue(getName());
        $("[name = 'phone']").setValue(getPhone());
        $("[class='checkbox__box']").click();
        $$("[class='button__text']").find(exactText("Запланировать")).click();
        $(withText("Успешно")).waitUntil(visible, 15000);

        $("[placeholder = 'Город']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[placeholder = 'Город']").sendKeys(Keys.chord(Keys.DELETE));
        $("[name = 'name']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[name = 'name']").sendKeys(Keys.chord(Keys.DELETE));
        $("[name = 'phone']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[name = 'phone']").sendKeys(Keys.chord(Keys.DELETE));
        $("[placeholder='Город']").setValue(getCity());
        $("[name = 'name']").setValue(getName());
        $("[name = 'phone']").setValue(getPhone());
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


