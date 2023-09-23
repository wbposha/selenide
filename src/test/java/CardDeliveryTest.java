import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;



public class CardDeliveryTest {

    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldRegister() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));
    }

    @Test
    public void firstNameTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(" ");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='name']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Фамилия и имя Поле обязательно для заполнения"));
    }

    @Test
    public void secondNameTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван4ик");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='name']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Фамилия и имя Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void thirdNameTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Ivan Ivanov");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='name']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Фамилия и имя Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void fourthNameTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван-Иваныч Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));
    }

    @Test
    public void fifthNameTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("иван иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));
    }

    @Test
    public void firstCityTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(" ");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='city']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void secondCityTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Samara");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='city']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    public void thirdCityTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("123456");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='city']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    public void firstNumberTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue(" ");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='phone']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Мобильный телефон Поле обязательно для заполнения"));
    }

    @Test
    public void secondNumberTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='phone']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Мобильный телефон Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void thirdNumberTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(5,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+1293012388920310293921");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='phone']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Мобильный телефон Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void firstDateTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(1000,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));
    }

    @Test
    public void secondDateTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(0,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='date']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void thirdDateTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(-3,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='date']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void fourthDateTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(1,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='date']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void fifthDateTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(2,"dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+79001488228");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='date']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Заказ на выбранную дату невозможен"));
    }
}
