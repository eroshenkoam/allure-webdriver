package io.github.eroshenkoam;

import io.github.eroshenkoam.config.SelenideConfigExtension;
import io.github.eroshenkoam.steps.SelenideSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@ExtendWith(SelenideConfigExtension.class)
public class SelenideSharedStepsTest {

    private final static String REPOSITORY = "SeleniumHQ/selenium";

    private SelenideSteps steps = new SelenideSteps();

    @Test
    public void testGitHub() {
        steps.openMainPage();
        steps.searchByQuery(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
    }

}
