package com.wwwjf.demo.dagger;

import com.wwwjf.demo.dagger.car3.Car3;

import dagger.Module;
import dagger.Provides;

@Module
public class Car3Module {

    @Provides
    static Car3 providerCar(String brand){
        return new Car3();
    }
}
