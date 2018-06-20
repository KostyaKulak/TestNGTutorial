package runner;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import util.constant.GroupProps;
import util.listener.InvokedMethodListener;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        ITestNGListener listener = new InvokedMethodListener();
        TestNG tng = new TestNG();
        tng.addListener(listener);
        XmlSuite suite = new XmlSuite();
        suite.setName("page group test");
        suite.addIncludedGroup(GroupProps.FIRST_TEST_GROUP);
        List<String> files = new ArrayList<>(new ArrayList<String>() {{
            add("runGroupTest.xml");
        }});
        suite.setSuiteFiles(files);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();
    }
}
