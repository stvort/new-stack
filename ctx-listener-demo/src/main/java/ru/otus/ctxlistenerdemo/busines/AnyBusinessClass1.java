package ru.otus.ctxlistenerdemo.busines;

import org.springframework.stereotype.Component;
import ru.otus.ctxlistenerdemo.api.OnStartup;
import ru.otus.ctxlistenerdemo.api.OnStartup2;

@Component
public class AnyBusinessClass1 {

    @OnStartup
    public void anyBusinessMethod1 (){
        System.out.println("AnyBusinessClass1#anyBusinessMethod1");
    }

    @OnStartup
    public void anyBusinessMethod2 (){
        System.out.println("AnyBusinessClass1#anyBusinessMethod2");
    }

    @OnStartup2
    public void anyBusinessMethod3 (){
        System.out.println("AnyBusinessClass1#anyBusinessMethod3");
    }

}
