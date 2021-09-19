package parenkov.allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    @Test
    public void githubTest() {
        open("https://github.com");
        $(".header-search-input").sendKeys("selenide");
        $(".header-search-input").submit();

        $(By.linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $("#issue_1543_link").shouldHave(text("Please add stack trace to every error in SoftAsserts"));

    }
}
