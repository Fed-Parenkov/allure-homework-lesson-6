package parenkov.allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    @Step("Открыть главную github.com")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозитории по ключевому слову selenide")
    public void searchRepositories() {
        $(".header-search-input").sendKeys("selenide");
        $(".header-search-input").submit();
    }

    @Step("Перейти в репозиторий проекта selenide")
    public void openRepository() {
        $(By.linkText("selenide/selenide")).click();
    }

    @Step("Перейти к списку Issues")
    public void openIssuesList() {
        $("#issues-tab").click();
    }

    @Step("Проверить текст заголовка issue #1543")
    public void checkIssueTitle() {
        $("#issue_1543_link")
                .shouldHave(text("Please add stack trace to every error in SoftAsserts"));
    }


}
