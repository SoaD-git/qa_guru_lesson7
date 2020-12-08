package yandexSearch;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchTests {
    @Test
    @DisplayName("Via Chrome Browser - Check That Selenide Exist in Yandex")
    @Description("Verification that it is possible to find Selenide via Yandex using Chrome")
    @Tag("GitHub")
    @Owner("Sergei P")
    void selenideSearchTest() {
        Configuration.browser = "chrome";
        open("https://yandex.ru");
        $(byName("text")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }
}
