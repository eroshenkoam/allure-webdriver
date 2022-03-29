package io.github.eroshenkoam;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.qameta.allure.Allure.step;

@ExtendWith(SeleniumJupiter.class)
public class WebDriverSimpleStepsTest {

    private final static String REPOSITORY = "SeleniumHQ/selenium";

    @Test
    public void testGithub(ChromeDriver driver) {
        step("Open main page", () -> {
            driver.get("https://github.com");
        });
        step("Search by query " + REPOSITORY, () -> {
            WebElement searchInput = driver.findElement(By.cssSelector(".header-search-input"));
            searchInput.click();
            searchInput.sendKeys(REPOSITORY);
            searchInput.submit();
        });
        step("Go to repository " + REPOSITORY, () -> {
            driver.findElement(By.linkText(REPOSITORY)).click();
        });
        step("Open Issues tab", () -> {
            driver.findElement(By.partialLinkText("Issues")).click();
        });
    }

}
