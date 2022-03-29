package io.github.eroshenkoam;

import io.github.eroshenkoam.config.SelenideConfigExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@ExtendWith(SelenideConfigExtension.class)
public class SelenideSimpleStepsTest {

    private final static String REPOSITORY = "SeleniumHQ/selenium";

    @Test
    public void testGitHub() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search by query " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open Issues tab", () -> {
            $(partialLinkText("Issues")).click();
        });

    }

}
