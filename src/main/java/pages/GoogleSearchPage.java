package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Constants.BASE_URL;


public class GoogleSearchPage {
    private static final Logger LOGGER = LogManager.getLogger(GoogleSearchPage.class.getName());

    @FindBy(css = "input#lst-ib")
    private WebElement searchField;
    @FindBy(xpath = "//input[@value='Пошук Google']")
    private WebElement searchButton;

    private WebDriver driver;


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPage open() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleSearchPage search(String searchString) {
        LOGGER.info("Search for " + searchString);
        new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(searchString);
        new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public boolean isExpectedPage(String url) {
        LOGGER.debug("Start comparing current page with " + url);
        return driver.getCurrentUrl().contains(url);
    }

    public void refresh() {
        String currentUrl = driver.getCurrentUrl().length() >= 30 ? driver.getCurrentUrl().substring(0, 30) : driver.getCurrentUrl();
        LOGGER.debug("Page " + currentUrl + " was refreshed");
        driver.navigate().refresh();
    }
}
