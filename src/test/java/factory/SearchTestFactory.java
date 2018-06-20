package factory;

import org.testng.annotations.Factory;
import basictest.SearchTest;
import util.constant.TestProps;

public class SearchTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new SearchTest(TestProps.FIRST_SEARCH_STRING, 10),
                new SearchTest(TestProps.SECOND_SEARCH_STRING, 20)};
    }
}
