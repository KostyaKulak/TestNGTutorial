package util.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import util.annotation.TesterInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static util.logger.MyLogger.LOGGER;

public class InvokedMethodListener implements IInvokedMethodListener {
    private int countOfDisables = 0;

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
            if (method.isAnnotationPresent(TesterInfo.class)) {
                Annotation testerInfo = method.getAnnotation(TesterInfo.class);
                if (method.getName().equals("disableTest")
                        || method.getName().equals("disableSecondTest")) {
                    if (iInvokedMethod.getTestMethod().getConstructorOrMethod().getEnabled()) {
                        throw new SkipException("");
                    }
                    countOfDisables++;
                    LOGGER.info("Method " + iInvokedMethod.getTestMethod().getMethodName() + " was disabled " + countOfDisables + " times");
                }
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (!iTestResult.isSuccess())
            iTestResult.setStatus(ITestResult.SUCCESS);

    }
}
