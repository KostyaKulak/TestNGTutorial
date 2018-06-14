package basicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class SearchTest {
    private String searchString = "";
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    public SearchTest(String searchString) {
        this.searchString = searchString;
    }

    @BeforeClass
    public void loadState() {
        driver = new FirefoxDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.open();
    }

    @Test
    public void pageTest() {
        Assert.assertTrue(googleSearchPage.isExpectedPage("https://www.google.by"));
    }

    @Test(dependsOnMethods = "pageTest")
    public void searchTest() {
        String defaultSearchString = searchString.equals("") ? "hello" : searchString;
        googleSearchPage.search(defaultSearchString);
    }

    @Test(dependsOnMethods = "searchTest")
    public void refreshTest() {
        googleSearchPage.refresh();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
