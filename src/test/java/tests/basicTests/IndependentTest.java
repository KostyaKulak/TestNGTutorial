package tests.basicTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.constants.CommonProps;
import utils.constants.GroupProps;
import utils.constants.TestProps;

public class IndependentTest extends BaseTest {

    @BeforeClass(groups = {GroupProps.FIRST_TEST_GROUP, GroupProps.SECOND_TEST_GROUP, GroupProps.THIRD_TEST_GROUP})
    @Override
    public void loadState() {
        super.loadState();
    }

    @Test(groups = GroupProps.FIRST_TEST_GROUP)
    public void pageTest() {
        Assert.assertTrue(googleSearchPage.isExpectedPage(CommonProps.BASE_URL));
        Assert.fail();
    }

    @Test(groups = GroupProps.SECOND_TEST_GROUP)
    public void searchTest() {
        googleSearchPage.search(TestProps.THIRD_SEARCH_STRING);
    }

    @Test(groups = GroupProps.THIRD_TEST_GROUP)
    public void refreshTest() {
        googleSearchPage.refresh();
    }

    @AfterClass(groups = {GroupProps.FIRST_TEST_GROUP, GroupProps.SECOND_TEST_GROUP, GroupProps.THIRD_TEST_GROUP})
    @Override
    public void afterClass() {
        super.afterClass();
    }
}
