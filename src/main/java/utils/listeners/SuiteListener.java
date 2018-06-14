package utils.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = LogManager.getLogger(SuiteListener.class.getName());

    @Override
    public void onStart(ISuite arg0) {
        LOGGER.info("Start executing 'Suite' " + arg0.getName());
    }

    @Override
    public void onFinish(ISuite arg0) {
        LOGGER.info("Finish executing 'Suite' " + arg0.getName());
    }

}
