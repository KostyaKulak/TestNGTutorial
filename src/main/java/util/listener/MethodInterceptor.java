package util.listener;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import util.constant.GroupProps;

import java.util.ArrayList;
import java.util.List;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> instances = new ArrayList<>();
        for (IMethodInstance instance : list)
            if (!instance.getMethod().getTestClass().getName().contains("IndependentTest")) {
                instances.add(instance);
            } else {
                if (instance.getMethod().getGroups().length != 0 && !instance.getMethod().getGroups()[0].equals(GroupProps.SECOND_TEST_GROUP)) {
                    instances.add(instance);
                }
            }
        return instances;
    }
}
