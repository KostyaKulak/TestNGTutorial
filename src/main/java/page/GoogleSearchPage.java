package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.constant.CommonProps;

import static util.logger.MyLogger.LOGGER;

public class GoogleSearchPage {
    @FindBy(css = "input#lst-ib")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
    private WebElement searchButton;
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPage open() {
        driver.navigate().to(CommonProps.BASE_URL);
        return this;
    }

    public GoogleSearchPage search(String searchString) {
        LOGGER.info("Search for " + searchString);
        open();
        new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(searchString);
        searchButton.click();
        return this;
    }

    public boolean isExpectedPage(String url) {
        LOGGER.info("Start comparing current page with " + url);
        return driver.getCurrentUrl().contains(url);
    }

    public void refresh() {
        String currentUrl = driver.getCurrentUrl().length() >= CommonProps.MAX_OUTPUT_ADDRESS ?
                driver.getCurrentUrl().substring(0, CommonProps.MAX_OUTPUT_ADDRESS) : driver.getCurrentUrl();
        LOGGER.info("Page " + currentUrl + " was refreshed");
        driver.navigate().refresh();
    }
}
