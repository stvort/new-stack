package ru.otus.ctxlistenerdemo.busines;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AnyBusinessClass2 anyBusinessClass2() {
        return new AnyBusinessClass2();
    }
}
