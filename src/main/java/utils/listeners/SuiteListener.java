package utils.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import static utils.logger.MyLogger.LOGGER;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite arg0) {
        LOGGER.info("Start executing 'Suite' " + arg0.getName());
    }

    @Override
    public void onFinish(ISuite arg0) {
        LOGGER.info("Finish executing 'Suite' " + arg0.getName());
    }

}
