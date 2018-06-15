package tests;

import org.testng.annotations.Factory;
import tests.basicTests.SearchTest;
import utils.constants.TestProps;

public class SearchTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new SearchTest(TestProps.FIRST_SEARCH_STRING), new SearchTest(TestProps.SECOND_SEARCH_STRING)};
    }
}
