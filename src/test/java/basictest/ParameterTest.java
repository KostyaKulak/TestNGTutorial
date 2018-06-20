package basictest;

import org.testng.annotations.Test;

public class ParameterTest extends BaseTest {
    @Test(parameters = "searchString")
    public void searchTestWithParameter(String searchString) {
        googleSearchPage.search(searchString);
    }
}
