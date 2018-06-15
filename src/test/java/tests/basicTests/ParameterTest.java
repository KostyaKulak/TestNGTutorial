package tests.basicTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ParameterTest extends BaseTest {
    @Test(parameters = "searchString")
    public void searchTestWithParameter(String searchString) {
        googleSearchPage.search(searchString);
    }
}
