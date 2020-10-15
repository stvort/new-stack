package ru.otus.ctxlistenerdemo.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.otus.ctxlistenerdemo.api.OnStartup;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class OnStartupAnnotationProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private final BeanDefinitionHelper helper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        helper.getBeansContextList().forEach(bc ->
                Arrays.stream(bc.getBeanClass().getDeclaredMethods())
                        .filter(m -> m.isAnnotationPresent(OnStartup.class))
                        .forEach(m -> helper.invokeMethod(m, bc.getBeanInstance())));
    }


}
