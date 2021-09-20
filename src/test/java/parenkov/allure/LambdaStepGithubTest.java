package parenkov.allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepGithubTest {

    @Test
    public void githubTest() {

        step("Открыть главную github.com", () -> {
            open("https://github.com");
        });

        step("Найти репозитории по ключевому слову selenide", () -> {
            $(".header-search-input").sendKeys("selenide");
            $(".header-search-input").submit();
        });

        step("Перейти в репозиторий проекта selenide", () -> {
            $(By.linkText("selenide/selenide")).click();
        });

        step("Перейти к списку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверить текст заголовка issue #1543", () -> {
            $("#issue_1543_link")
                    .shouldHave(text("Please add stack trace to every error in SoftAsserts"));
        });
    }
}
