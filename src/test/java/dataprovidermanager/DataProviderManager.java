package dataprovidermanager;

import basictest.SearchTest;
import org.testng.annotations.DataProvider;

import java.util.Random;

public class DataProviderManager {
    @DataProvider(name = "searchStrings")
    public Object[][] getStrings() {
        String alp[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int stringLength = SearchTest.stringLength;
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(alp[random.nextInt(alp.length - 1)]);
        }
        return new Object[][]{{stringBuilder.toString()}};
    }
}
