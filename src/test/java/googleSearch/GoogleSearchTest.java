package googleSearch;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GoogleSearchTest {

    @BeforeEach
    public void initSelenideListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void googleSearch() {
        step("Открываем страницу поиска", () -> open("https://google.com"));
        step("Вводим значение в строке поиска", () -> {
            $(byName("q")).val("Selenide").pressEnter();
        });
        step("Проверяем результат поиска", () -> {
           $("html").shouldHave(Condition.text("selenide.org"));
        });
    }
}