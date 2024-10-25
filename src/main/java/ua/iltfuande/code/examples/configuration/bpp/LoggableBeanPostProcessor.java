package ua.iltfuande.code.examples.configuration.bpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;
import ua.iltfuande.code.examples.annotation.Loggable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
public class LoggableBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(LoggableBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var beanClass = bean.getClass();
        var hasAnyMethodLoggableAnnotation = Arrays.stream(beanClass.getDeclaredMethods())
                .anyMatch(method -> method.isAnnotationPresent(Loggable.class));

        if (!hasAnyMethodLoggableAnnotation && !beanClass.isAnnotationPresent(Loggable.class)) {
            return bean;
        }

        if (beanClass.getInterfaces().length > 0) { // JDK proxy
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    ((_, method, args) -> logAndInvoke(bean, beanClass, method, args))
            );
        } else { // CGlib
            var enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback((MethodInterceptor) (_, method, args, _) ->
                    logAndInvoke(bean, beanClass, method, args));
            return enhancer.create();
        }
    }

    private Object logAndInvoke(Object bean, Class<?> beanClass, Method method, Object[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        var originalMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
        var shouldLog = originalMethod.isAnnotationPresent(Loggable.class) || beanClass.isAnnotationPresent(Loggable.class);

        if (shouldLog) {
            var startTime = System.currentTimeMillis();
            log.info("Method {} of {} class started at {} ms", originalMethod.getName(), beanClass.getCanonicalName(), startTime);

            var result = originalMethod.invoke(bean, args);

            var endTime = System.currentTimeMillis();
            log.info("Method {} of {} class finished at {} ms", originalMethod.getName(), beanClass.getCanonicalName(), endTime);

            log.info("Execution time for {} method of {}: {} ms", originalMethod.getName(), beanClass.getCanonicalName(), endTime - startTime);
            return result;
        } else {
            return originalMethod.invoke(bean, args);
        }
    }
}
