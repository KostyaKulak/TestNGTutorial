package tests.basicTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.annotation.TesterInfo;
import utils.constants.CommonProps;
import utils.constants.TestProps;

import java.util.Random;

public class SearchTest extends BaseTest {
    private String searchString = "";
    private int stringLength;

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

    @DataProvider(name = "searchStrings")
    public Object[][] getStrings() {
        String alp[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(alp[random.nextInt(alp.length-1)]);
        }
        return new Object[][]{{stringBuilder.toString()}};
    }

    @Test(dataProvider = "searchStrings")
    public void searchTestWithParams(String searchString){
        googleSearchPage.search(searchString);
    }

    @TesterInfo(priority = TesterInfo.Priority.MEDIUM, createdBy = "Kanstantsin_Kulak@epam.com", lastModified = "15/06/2018")
    @Test(dependsOnMethods = "searchTest")
    public void refreshTest() {
        googleSearchPage.refresh();
    }
}
