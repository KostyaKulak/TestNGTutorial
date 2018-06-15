package tests.basicTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.annotation.TesterInfo;
import utils.constants.CommonProps;
import utils.constants.TestProps;

public class SearchTest extends BaseTest {
    private String searchString = "";

    public SearchTest(String searchString) {
        this.searchString = searchString;
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

    @TesterInfo(priority = TesterInfo.Priority.MEDIUM, createdBy = "Kanstantsin_Kulak@epam.com",lastModified = "15/06/2018")
    @Test(dependsOnMethods = "searchTest")
    public void refreshTest() {
        googleSearchPage.refresh();
    }
}
