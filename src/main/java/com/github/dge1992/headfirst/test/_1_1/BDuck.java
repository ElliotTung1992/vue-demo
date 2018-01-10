package com.github.dge1992.headfirst.test._1_1;

public class BDuck extends SuperDuck{

    public BDuck(){
        quackBehavior = new Squack();
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("red");
    }
}
