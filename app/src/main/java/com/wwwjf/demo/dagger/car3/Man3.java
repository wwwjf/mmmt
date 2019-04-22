package com.wwwjf.demo.dagger.car3;


import javax.inject.Inject;

/**
 * 基于注解方法
 */
public class Man3 {

    @Inject
    public Car3 car3;

    public Man3 (){
        DaggerMan3Component.create().injectMan3(this);
    }
}
