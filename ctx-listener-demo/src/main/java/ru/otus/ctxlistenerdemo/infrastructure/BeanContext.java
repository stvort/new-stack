package ru.otus.ctxlistenerdemo.infrastructure;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BeanContext {
    private final Class<?> beanClass;
    private final Object beanInstance;
}
