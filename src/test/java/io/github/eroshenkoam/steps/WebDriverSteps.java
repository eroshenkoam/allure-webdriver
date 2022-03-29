package io.github.eroshenkoam.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class WebDriverSteps {

    private final WebDriver driver;

    public WebDriverSteps (final WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open main page")
    public void openMainPage() {
        driver.get("https://github.com");
    }

    @Step("Search by query {repo}")
    public void searchByQuery(String query) {
        WebElement searchInput = driver.findElement(By.cssSelector(".header-search-input"));
        searchInput.click();
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    @Step("Go to repository {repo}")
    public void goToRepository(String repo) {
        driver.findElement(By.linkText(repo)).click();
    }

    @Step("Open Issues tab")
    public void openIssueTab() {
        driver.findElement(By.partialLinkText("Issues")).click();
    }

}
