package com.wwwjf.demo.dagger.car3;

import com.wwwjf.demo.dagger.DaggerMan3Component;
import com.wwwjf.demo.dagger.car3.Car3;

import javax.inject.Inject;

/**
 * 基于注解方法
 */
public class Man3 {

    @Inject
    Car3 car3;

    public Man3 (){
        DaggerMan3Component.create().injectMan3(this);
    }
}
