package utils.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    private static final Logger LOGGER = LogManager.getLogger(AnnotationTransformer.class.getName());

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        if (method.getAnnotations().length != 0) {
            StringBuilder annotations = new StringBuilder();
            for (Annotation annotation : method.getAnnotations()) {
                annotations.append(annotation.annotationType().getName()).append(" ");
            }
            LOGGER.info("Method " + method.getName() + " use such annotations as " + annotations);
        }
    }
}
