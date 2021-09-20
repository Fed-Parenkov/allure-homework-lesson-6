package parenkov.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    @Test
    public void githubTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").as("Поисковая строка").sendKeys("selenide");
        $(".header-search-input").as("Поисковая строка").submit();

        $(By.linkText("selenide/selenide")).as("Ссылка для перехода в репозиторий проекта Selenide").click();
        $("#issues-tab").as("Ссылка для перехода в раздел Issues").click();
        $("#issue_1543_link").as("Сcылка на issue с #1543")
                .shouldHave(text("Please add stack trace to every error in SoftAsserts"));

    }
}
