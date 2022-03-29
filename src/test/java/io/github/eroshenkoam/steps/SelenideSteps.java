package io.github.eroshenkoam.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search by query {repo}")
    public void searchByQuery(String query) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(query);
        $(".header-search-input").submit();
    }

    @Step("Go to repository {repo}")
    public void goToRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open Issues tab")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

}
