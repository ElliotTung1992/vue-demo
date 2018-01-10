package com.github.dge1992.headfirst.test._1_1;

public class CDuck extends SuperDuck{

    public CDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squack();
    }

    @Override
    void display() {
        System.out.println("blue");
    }
}
