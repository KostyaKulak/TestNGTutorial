package factory;

import basictest.SearchTest;
import org.testng.annotations.Factory;
import util.constant.TestProps;

public class SearchTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new SearchTest(TestProps.FIRST_SEARCH_STRING, 10),
                new SearchTest(TestProps.SECOND_SEARCH_STRING, 20)};
    }
}
