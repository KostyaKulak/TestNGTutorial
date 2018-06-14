import basicTests.SearchTest;
import org.testng.annotations.Factory;

public class SearchTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new SearchTest("java"), new SearchTest("c++")};
    }
}
