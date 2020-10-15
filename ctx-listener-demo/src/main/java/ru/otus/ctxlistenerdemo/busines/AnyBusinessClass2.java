package ru.otus.ctxlistenerdemo.busines;

import ru.otus.ctxlistenerdemo.api.OnStartup;
import ru.otus.ctxlistenerdemo.api.OnStartup2;


public class AnyBusinessClass2 {

    @OnStartup
    public void anyBusinessMethod1 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod1");
    }

    @OnStartup
    public void anyBusinessMethod2 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod2");
    }

    @OnStartup2
    public void anyBusinessMethod3 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod3");
    }

}
