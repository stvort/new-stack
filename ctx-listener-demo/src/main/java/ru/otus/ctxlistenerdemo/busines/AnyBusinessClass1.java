package ru.otus.ctxlistenerdemo.busines;

import org.springframework.stereotype.Component;
import ru.otus.ctxlistenerdemo.api.OnStartup;

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

    @OnStartup
    public void anyBusinessMethod3 (){
        System.out.println("AnyBusinessClass1#anyBusinessMethod3");
    }

}
