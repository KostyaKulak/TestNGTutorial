package runner;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import tests.basicTests.IndependentTest;
import utils.constants.GroupProps;
import utils.listeners.TestListener;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG tng = new TestNG();
        ITestNGListener iTestNGListener = new TestListener();
        tng.addListener(iTestNGListener);

        XmlClass xmlClass = new XmlClass();
        xmlClass.setClass(IndependentTest.class);
        List<XmlClass> xmlClasses = new ArrayList<>();
        xmlClasses.add(xmlClass);

        XmlTest test = new XmlTest();
        test.setName("Group " + GroupProps.FIRST_TEST_GROUP + " test");
        List<String> groups = new ArrayList<>();
        groups.add(GroupProps.FIRST_TEST_GROUP);
        test.setIncludedGroups(groups);
        test.setClasses(xmlClasses);

        List<XmlTest> tests = new ArrayList<>();
        tests.add(test);

        XmlSuite suite = new XmlSuite();
        suite.setName("Run group " + GroupProps.FIRST_TEST_GROUP);
        suite.setTests(tests);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }
}
