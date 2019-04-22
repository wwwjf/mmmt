package com.wwwjf.demo.dagger;

/**
 * 基于接口方法
 */
public class Man2 implements CarInjector{

    Car car;


    @Override
    public void injectCar(Car car) {
        this.car = car;
    }
}

interface CarInjector{
  void injectCar(Car car);
}
