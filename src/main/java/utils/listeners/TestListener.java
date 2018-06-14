package utils.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onStart(ITestContext arg0) {
        LOGGER.info("Start executing 'Test' " + arg0.getName());
    }

    @Override
    public void onFinish(ITestContext arg0) {
        LOGGER.info("Finish executing 'Test' " + arg0.getName());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        printTestResults(arg0);
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        printTestResults(arg0);
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        LOGGER.info("Start executing 'Test method' " + arg0.getName() + " from " + arg0.getMethod().getTestClass().getName());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        printTestResults(arg0);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        printTestResults(arg0);
    }

    private void printTestResults(ITestResult result) {

        if (result.getParameters().length != 0) {
            StringBuilder params = new StringBuilder();
            for (Object parameter : result.getParameters()) {
                params.append(parameter.toString()).append(",");
            }
            params.replace(params.length() - 1, params.length(), "");
            LOGGER.info("Test method had the following parameters : " + params);
        }

        String status;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;
            case ITestResult.FAILURE:
                status = "Failed";
                break;
            case ITestResult.SKIP:
                status = "Skipped";
            default:
                status = "Undefined";
                break;
        }
        LOGGER.info("Test Status: " + status);
        LOGGER.info("Test duration " + (result.getEndMillis() - result.getStartMillis()) + " millis");
    }
}
