package util.listener;

import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static util.logger.MyLogger.LOGGER;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite arg0) {
        LOGGER.info("Start executing 'Suite' " + arg0.getName());
    }

    @Override
    public void onFinish(ISuite arg0) {
        LOGGER.info("Finish executing 'Suite' " + arg0.getName());
        for (IInvokedMethod method : arg0.getAllInvokedMethods()) {
            if(method.isTestMethod()) {
                LOGGER.info(method.getTestMethod().getMethodName() + " from " + method.getTestMethod().getTestClass().getName() + ": "
                        + (method.getTestResult().getEndMillis() - method.getTestResult().getStartMillis())
                        + "millis");
            }
        }
    }

}
