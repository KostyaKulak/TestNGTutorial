package utils.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import utils.annotation.TesterInfo;
import utils.constants.GroupProps;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static utils.logger.MyLogger.LOGGER;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        if (method.getAnnotations().length != 0) {
            StringBuilder annotations = new StringBuilder();
            for (Annotation annotation : method.getAnnotations()) {
                annotations.append(annotation.annotationType().getName()).append(',');
            }
            annotations.replace(annotations.length() - 1, annotations.length(), "");
            LOGGER.info("Method " + method.getName() + " use such annotations as " + annotations);
        }
        if (method.getName().equals("searchTestWithParameter") ||
                (method.getAnnotation(Test.class).groups().length != 0 &&
                        method.getAnnotation(Test.class).groups()[0].equals(GroupProps.THIRD_TEST_GROUP))) {
            if (iTestAnnotation.getEnabled()) {
                iTestAnnotation.setEnabled(false);
            }
        }
        Annotation annotation = method.getAnnotation(TesterInfo.class);
        if (annotation != null) {
            String createdBy = ((TesterInfo) annotation).createdBy();
            TesterInfo.Priority priority = ((TesterInfo) annotation).priority();
            String lastModified = ((TesterInfo) annotation).lastModified();
            LOGGER.info("Test method " + method.getName()
                    + " from " + method.getDeclaringClass()
                    + ", created by " + createdBy
                    + " and last modified at " + lastModified
                    + ", has " + priority + " priority, ");
        }
    }
}
