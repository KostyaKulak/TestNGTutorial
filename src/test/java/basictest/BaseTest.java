package basictest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.GoogleSearchPage;

public class BaseTest {
    protected WebDriver driver;
    protected GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void loadState() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.open();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
