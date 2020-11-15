package ru.otus.ctxlistenerdemo.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.otus.ctxlistenerdemo.api.OnStartup;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class OnStartupAnnotationProcessor {

    private final BeanDefinitionHelper helper;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        helper.getBeansContextList().forEach(bc ->
                Arrays.stream(bc.getBeanClass().getDeclaredMethods())
                        .filter(m -> m.isAnnotationPresent(OnStartup.class))
                        .forEach(m -> helper.invokeMethod(m, bc.getBeanInstance())));
    }


}
