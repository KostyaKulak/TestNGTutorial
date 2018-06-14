package basicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class ParameterTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void loadState() {
        driver = new FirefoxDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.open();
    }

    @Test(parameters = "searchString")
    public void searchTest(String searchString) {
        googleSearchPage.search(searchString);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
