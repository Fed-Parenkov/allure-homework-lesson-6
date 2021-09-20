package parenkov.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepGithubTest {

    @Test
    public void githubTest() {

        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchRepositories();
        steps.openRepository();
        steps.openIssuesList();
        steps.checkIssueTitle();
    }
}
