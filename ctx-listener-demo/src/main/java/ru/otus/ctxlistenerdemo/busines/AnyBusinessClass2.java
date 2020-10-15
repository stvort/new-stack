package ru.otus.ctxlistenerdemo.busines;

import ru.otus.ctxlistenerdemo.api.OnStartup;


public class AnyBusinessClass2 {

    @OnStartup
    public void anyBusinessMethod1 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod1");
    }

    @OnStartup
    public void anyBusinessMethod2 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod2");
    }

    @OnStartup
    public void anyBusinessMethod3 (){
        System.out.println("AnyBusinessClass2#anyBusinessMethod3");
    }

}
