package basictest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import util.annotation.TesterInfo;
import util.constant.CommonProps;
import util.constant.TestProps;

import static util.logger.MyLogger.LOGGER;

public class SearchTest extends BaseTest {
    private String searchString = "";
    public static int stringLength = 10;

    public SearchTest(String searchString, int stringLength) {
        this.searchString = searchString;
        this.stringLength = stringLength;
    }

    @Test
    public void pageTest() {
        Assert.assertTrue(googleSearchPage.isExpectedPage(CommonProps.BASE_URL));
    }

    @TesterInfo(priority = TesterInfo.Priority.HIGH, createdBy = "Kanstantsin_Kulak@epam.com")
    @Test(dependsOnMethods = "pageTest")
    public void searchTest() {
        String defaultSearchString = searchString.equals("") ? TestProps.THIRD_SEARCH_STRING : searchString;
        googleSearchPage.search(defaultSearchString);
    }


    @Test(dataProviderClass = dataprovidermanager.DataProviderManager.class, dataProvider = "searchStrings")
    public void searchTestWithParams(String searchString) {
        googleSearchPage.search(searchString);
    }

    @TesterInfo(priority = TesterInfo.Priority.LOW, createdBy = "Kanstantsin_Kulak@epam.com", lastModified = "15/06/2018")
    @Test(dependsOnMethods = "searchTest")
    public void refreshTest() {
        googleSearchPage.refresh();
        throw new SkipException("hello skip test");
    }

    @TesterInfo
    @Test
    public void disableTest() {
        LOGGER.info("hello");
    }

    @TesterInfo
    @Test
    public void disableSecondTest() {
        LOGGER.info("hello user");
    }

    @Test
    public void skipTest() {
        LOGGER.info("JAVA FOREVER");
        throw new SkipException("");
    }
}
