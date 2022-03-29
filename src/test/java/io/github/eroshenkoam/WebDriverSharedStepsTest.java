package io.github.eroshenkoam;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.eroshenkoam.steps.WebDriverSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(SeleniumJupiter.class)
public class WebDriverSharedStepsTest {

    private final static String REPOSITORY = "SeleniumHQ/selenium";

    @Test
    public void testGithub(ChromeDriver driver) {
        WebDriverSteps steps = new WebDriverSteps(driver);
        steps.openMainPage();
        steps.searchByQuery(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
    }

}
