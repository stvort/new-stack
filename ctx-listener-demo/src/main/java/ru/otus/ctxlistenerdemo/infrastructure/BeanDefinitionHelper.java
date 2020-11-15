package ru.otus.ctxlistenerdemo.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class BeanDefinitionHelper {

    private final ApplicationContext ctx;
    private final ConfigurableListableBeanFactory factory;

    private Class<?> classForName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ignored) {
        }
        return null;
    }

    private Class<?> getClassForBeanDefinition(BeanDefinition beanDefinition) {
        var className = Optional.ofNullable(beanDefinition.getBeanClassName())
                .orElseGet(() -> {
                    if (beanDefinition instanceof AnnotatedBeanDefinition) {
                        var annotatedBeanDefinition = (AnnotatedBeanDefinition) beanDefinition;
                        var methodMetadata = annotatedBeanDefinition.getFactoryMethodMetadata();
                        return Optional.ofNullable(methodMetadata).map(MethodMetadata::getReturnTypeName).orElse(null);
                    }
                    return null;
                });
        return classForName(className);
    }

    private Object getBeanForName(String beanName) {
        try {
            return ctx.getBean(beanName);
        } catch (BeansException ignored) {
        }
        return null;
    }

    public List<BeanContext> getBeansContextList() {
        var classMap = Arrays.stream(factory.getBeanDefinitionNames())
                .collect(Collectors.toMap(n -> n, n -> getClassForBeanDefinition(factory.getBeanDefinition(n))));

        return Arrays.stream(factory.getBeanDefinitionNames())
                .map(beanName -> new BeanContext(classMap.get(beanName), getBeanForName(beanName)))
                .filter(bc -> bc.getBeanClass() != null || bc.getBeanInstance() != null)
                .collect(Collectors.toList());
    }

    public void invokeMethod(Method method, Object o) {
        try {
            method.invoke(o);
        } catch (Exception ignored) {
        }
    }
}
